package com.example.pizzaapp.models;

import android.util.Log;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;

    public double getTotalPrice(){
        double totalPrice = 0.0;
        for(int i = 0; i < products.size(); i++){
            totalPrice+= products.get(i).getPrice();
        }
        return totalPrice;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        try {
            products.remove(products.indexOf(product));
        }catch (Exception e){
            Log.e("NoProduct", "removeProduc: ",e );
        }
    }

    public int totalItems(){
        return products.size();
    }
}
