package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import org.skypro.skyshop.article.Article;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        // Создаём товары
        Product phone = new SimpleProduct("Телефон", 50000);
        Product laptop = new SimpleProduct("Ноутбук", 80000);
        Product headphones = new DiscountedProduct(
                "Наушники", 5000, 20
        );
        Product mouse = new DiscountedProduct(
                "Мышка", 2000, 10
        );
        Product keyboard = new FixPriceProduct("Клавиатура");

        // Создаём корзину
        ProductBasket basket = new ProductBasket();

        basket.addProduct(phone);
        basket.addProduct(laptop);
        basket.addProduct(headphones);
        basket.addProduct(mouse);
        basket.addProduct(keyboard);

        // Демонстрация корзины
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // Создаём статьи
        Article article1 = new Article(
                "Как выбрать телефон",
                "При выборе телефона обратите внимание на процессор и камеру."
        );

        Article article2 = new Article(
                "Как выбрать ноутбук",
                "Ноутбук должен соответствовать вашим задачам."
        );

        Article article3 = new Article(
                "Обзор наушников",
                "Наушники бывают проводные и беспроводные."
        );

        // Создаём поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары
        searchEngine.add(phone);
        searchEngine.add(laptop);
        searchEngine.add(headphones);
        searchEngine.add(mouse);
        searchEngine.add(keyboard);

        // Добавляем статьи
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        // Демонстрация поиска
        System.out.println("\nПоиск: телефон");
        Searchable[] result1 = searchEngine.search("телефон");
        System.out.println(Arrays.toString(result1));

        System.out.println("\nПоиск: ноутбук");
        Searchable[] result2 = searchEngine.search("ноутбук");
        System.out.println(Arrays.toString(result2));

        System.out.println("\nПоиск: наушники");
        Searchable[] result3 = searchEngine.search("наушники");
        System.out.println(Arrays.toString(result3));

        System.out.println("\nПоиск: компьютер");
        Searchable[] result4 = searchEngine.search("компьютер");
        System.out.println(Arrays.toString(result4));
    }
}
