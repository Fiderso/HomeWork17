package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {

        // Создаём продукты
        Product product1 = new Product("Телефон", 50000);
        Product product2 = new Product("Ноутбук", 80000);
        Product product3 = new Product("Наушники", 5000);
        Product product4 = new Product("Мышка", 2000);
        Product product5 = new Product("Клавиатура", 4000);
        Product product6 = new Product("Монитор", 25000);

        // Создаём корзину
        ProductBasket basket = new ProductBasket();

        // 1. Добавление продуктов
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // 2. Попытка добавить шестой продукт
        basket.addProduct(product6);

        // 3. Печать содержимого корзины
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // 4. Получение стоимости корзины
        System.out.println("\nСтоимость корзины: " + basket.getTotalPrice());

        // 5. Поиск существующего продукта
        System.out.println("\nЕсть ли телефон? " + basket.containsProduct("Телефон"));

        // 6. Поиск отсутствующего продукта
        System.out.println("Есть ли планшет? " + basket.containsProduct("Планшет"));

        // 7. Очистка корзины
        basket.clearBasket();

        // 8. Печать пустой корзины
        System.out.println("\nПосле очистки:");
        basket.printBasket();

        // 9. Стоимость пустой корзины
        System.out.println("\nСтоимость пустой корзины: " + basket.getTotalPrice());

        // 10. Поиск продукта в пустой корзине
        System.out.println("Есть ли телефон? "
                + basket.containsProduct("Телефон"));
    }
}
