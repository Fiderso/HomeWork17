package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products = new Product[5];

    // Добавление продукта
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }

        System.out.println("Невозможно добавить продукт");
    }

    // Получение общей стоимости корзины
    public int getTotalPrice() {
        int total = 0;

        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }

        return total;
    }

    // Подсчёт специальных товаров
    public int getSpecialProductsCount() {
        int count = 0;

        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                count++;
            }
        }

        return count;
    }

    // Печать содержимого корзины
    public void printBasket() {
        boolean isEmpty = true;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: "
                    + getSpecialProductsCount());
        }
    }

    // Проверка наличия продукта
    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    // Очистка корзины
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
