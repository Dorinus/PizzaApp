package com.example.pizzaapp.repositories;

import com.example.pizzaapp.models.Product;
import com.google.firebase.firestore.Query;

import java.util.List;

// Dorin
public interface IProductDao {
    public Query getAllBurgers();
    public Query getAllPizzas();
    public Query getAllBeverages();
}
