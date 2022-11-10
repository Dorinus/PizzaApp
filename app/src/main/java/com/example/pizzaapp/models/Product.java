package com.example.pizzaapp.models;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String description;
    private double price;
    private double weight;
    private String ingredients;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, String description, double price, double weight, String ingredients) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getIngredients() {
        return ingredients;
    }

    public List<Product> getProducts() {
        ArrayList<Product> prodcuts = new ArrayList<>();
        prodcuts.add(new Product("Burger 1", "Descriptiooooooooon fwfewf ef sfsef fesefsef sefsefse aaa aaaaaaa bbbbbbbb",10.5,0.6,"Salad, Tomatoes, Meat"));
        prodcuts.add(new Product("Burger 23", 1100.0));
        return  prodcuts;
    }
}
