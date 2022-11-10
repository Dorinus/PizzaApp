package com.example.pizzaapp.database;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class DataBase {
    private static FirebaseFirestore db = null;
    private static FirebaseDatabase database = null;

    private DataBase() {

    }

    //Firestore databse
    public static FirebaseFirestore getDataBase() {
        try {
            if (db == null){
                db = FirebaseFirestore.getInstance();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return db;
    }

    // RealTime database
//    public static FirebaseDatabase getDataBase() {
//        try {
//            if (database == null){
//                database = FirebaseDatabase.getInstance();
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return database;
//    }
}
