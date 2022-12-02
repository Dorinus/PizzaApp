package com.example.pizzaapp.models;

import android.util.Log;

import java.util.ArrayList;

// Hadi and Dorin
public class ShoppingCart {
    public Order order;
    private static ShoppingCart instance;

    private ShoppingCart() {
        order = new Order();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addProduct(Product product) {
        Log.i("Product_Added", ("addProduct: " + product.getName()));
        order.addProduct(product);
    }

    public void removeProduct(Product product) {
        order.removeProduct(product);
    }

    public int totalItems() {
        return order.totalItems();
    }

    public double getTotalPrice() {
        return order.getTotalPrice();
    }

    public ArrayList<Product> getProducts(){
        return order.getProducts();
    }

    public void removeIndex(int clickedItemIndex) {
        order.removeIndex(clickedItemIndex);
    }
}
