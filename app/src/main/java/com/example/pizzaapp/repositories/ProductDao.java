package com.example.pizzaapp.repositories;

import com.example.pizzaapp.database.DataBase;
import com.example.pizzaapp.models.Product;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

//Dorin
public class ProductDao implements IProductDao {

    private static ProductDao instance;

    private ProductDao() {
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    public Query getAllBurgers() {

        CollectionReference burgersRef = DataBase.getDataBase().collection("products");
        Query query= burgersRef.orderBy("name",Query.Direction.DESCENDING);
        return query;
        }


    public Query getAllPizzas(){
        //TODO Delete Dummy Data
//        List<Product> listOfProducts = new ArrayList<>();
//        listOfProducts.add(new Product("Margherita", "Nothing pizza", 50.5,0.5,"Bread, Tomat"));
//        listOfProducts.add(new Product("Salsicia", "A lot of salsicia", 80.9,0.5,"Bread, Tomat, Salsicia"));
//        return listOfProducts;
        CollectionReference pizzasRef = DataBase.getDataBase().collection("pizzas");
        Query query= pizzasRef.orderBy("name",Query.Direction.DESCENDING);
        return query;
    }

    public Query getAllBeverages(){
//        //TODO Delete Dummy Data
//        List<Product> listOfProducts = new ArrayList<>();
//        listOfProducts.add(new Product("Cola", null, 20.0,0.5,null));
//        listOfProducts.add(new Product("Sprite", null, 19.0,0.5,null));
//
//        return listOfProducts;
        CollectionReference beveragesRef = DataBase.getDataBase().collection("beverages");
        Query query= beveragesRef.orderBy("name",Query.Direction.DESCENDING);
        return query;
    }

}


//    public List<Product> getAllProducts() {
//        // Read from the database
//
//        List<Product> products = new ArrayList<>();
//        DatabaseReference myRef = DataBase.getDataBase().getReference();
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                Product value = dataSnapshot.getValue(Product.class);
//                Log.d("Succes", "Value is: " + value);
//                products.add(value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("Error", "Failed to read value.", error.toException());
//            }
//        });
//
//        return products;
//    }
//}
