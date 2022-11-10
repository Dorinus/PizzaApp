package com.example.pizzaapp.repositories;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pizzaapp.MainActivity;
import com.example.pizzaapp.database.DataBase;
import com.example.pizzaapp.models.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private static ProductDao instance;

    private ProductDao() {
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    public List<Product> getAllBurgers() {

        List<Product> listOfProducts = new ArrayList<>();
        Task<QuerySnapshot> querySnapshotTask = DataBase.getDataBase().collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Succes", document.getId() + " => " + document.getData());
                                listOfProducts.add(document.toObject(Product.class));
                            }
                        } else {
                            Log.w("Not succes", "Error getting documents.", task.getException());
                        }

                    }
                });
        return listOfProducts;
        }


    public List<Product> getAllPizzas(){
        //TODO Delete Dummy Data
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product("Margherita", "Nothing pizza", 50.5,0.5,"Bread, Tomat"));
        listOfProducts.add(new Product("Salsicia", "A lot of salsicia", 80.9,0.5,"Bread, Tomat, Salsicia"));

        return listOfProducts;
    }

    public List<Product> getAllBeverages(){
        //TODO Delete Dummy Data
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product("Cola", null, 20.0,0.5,null));
        listOfProducts.add(new Product("Sprite", null, 19.0,0.5,null));

        return listOfProducts;
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
