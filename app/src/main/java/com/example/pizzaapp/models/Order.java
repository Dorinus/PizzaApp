package com.example.pizzaapp.models;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

//Hadi
public class Order {
    private ArrayList<Product> products;
    private String name;
    private String number;
    private String address;

    public Order() {
        this.products = new ArrayList<>();
    }


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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void removeIndex(int clickedItemIndex) {
        products.remove(clickedItemIndex);
    }


    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
