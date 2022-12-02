package com.example.pizzaapp.repositories;

import com.example.pizzaapp.models.Product;
import com.google.firebase.firestore.Query;

import java.util.List;

// Hadi
public class ProductRepository {
    private  static ProductRepository instance;
    private ProductDao productDao;
    private List<Product> productList;

    private ProductRepository() {
        this.productDao = ProductDao.getInstance();
    }

    public static ProductRepository getInstance(){
        if(instance == null)
            instance = new ProductRepository();

        return instance;
    }

    public Query getAllBurgers(){
        return  productDao.getAllBurgers();
    }

    public Query getAllPizzas(){
        return  productDao.getAllPizzas();
    }

    public Query getAllBeverages(){
        return  productDao.getAllBeverages();
    }



}
