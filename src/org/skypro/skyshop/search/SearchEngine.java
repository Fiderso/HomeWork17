package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] searchableItems;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }

    // Добавление объекта в поисковый движок
    public void add(Searchable item) {
        for (int i = 0; i < searchableItems.length; i++) {
            if (searchableItems[i] == null) {
                searchableItems[i] = item;
                return;
            }
        }
    }

    // Поиск объектов
    public Searchable[] search(String search) {
        Searchable[] results = new Searchable[5];

        int resultIndex = 0;

        for (Searchable item : searchableItems) {

            if (item == null) {
                continue;
            }

            if (item.getSearchTerm().contains(search)) {
                results[resultIndex] = item;
                resultIndex++;

                if (resultIndex == results.length) {
                    break;
                }
            }
        }

        return results;
    }
}
