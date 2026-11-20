package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {

        // Создаём обычные товары
        Product phone = new SimpleProduct("Телефон", 50000);
        Product laptop = new SimpleProduct("Ноутбук", 80000);

        // Создаём товары со скидкой
        Product headphones = new DiscountedProduct(
                "Наушники", 5000, 20
        );

        Product mouse = new DiscountedProduct(
                "Мышка", 2000, 10
        );

        // Создаём товар с фиксированной ценой
        Product keyboard = new FixPriceProduct("Клавиатура");

        // Создаём корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем товары
        basket.addProduct(phone);
        basket.addProduct(laptop);
        basket.addProduct(headphones);
        basket.addProduct(mouse);
        basket.addProduct(keyboard);

        // Проверяем заполнение корзины
        basket.addProduct(new SimpleProduct("Монитор", 25000));

        // Печатаем корзину
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // Проверяем общую стоимость
        System.out.println("\nСтоимость корзины: "
                + basket.getTotalPrice());

        // Проверяем специальные товары
        System.out.println("Специальных товаров: "
                + basket.getSpecialProductsCount());

        // Проверяем поиск
        System.out.println("\nЕсть ли телефон? "
                + basket.containsProduct("Телефон"));

        System.out.println("Есть ли планшет? "
                + basket.containsProduct("Планшет"));

        // Очищаем корзину
        basket.clearBasket();

        // Проверяем пустую корзину
        System.out.println("\nПосле очистки:");
        basket.printBasket();

        System.out.println("Стоимость пустой корзины: "
                + basket.getTotalPrice());

        System.out.println("Специальных товаров: "
                + basket.getSpecialProductsCount());
    }
}
