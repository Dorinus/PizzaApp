package com.example.pizzaapp.repositories;

import com.example.pizzaapp.models.Product;

import java.util.List;

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

    public List<Product> getAllBurgers(){
        this.productList = productDao.getAllBurgers();
        return  this.productList;
    }

    public List<Product> getAllPizzas(){
        return  productDao.getAllPizzas();
    }

    public List<Product> getAllBeverages(){
        return  productDao.getAllBeverages();
    }



}
