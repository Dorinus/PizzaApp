package com.example.pizzaapp.ui.beverages;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaapp.R;
import com.example.pizzaapp.databinding.FragmentBeverageBinding;
import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.models.ShoppingCart;
import com.example.pizzaapp.ui.burger.BurgerRecyclerViewAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import android.widget.Toast;

import java.util.List;

// Hadi
public class BeverageRecyclerViewAdapter extends FirestoreRecyclerAdapter<Product, BeverageRecyclerViewAdapter.ViewHolder> {

    public BeverageRecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentBeverageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Product model) {
        holder.product = model;
        holder.prodcutName.setText(model.getName());
        holder.prodcutPrice.setText(Double.toString(model.getPrice()));
        holder.productWeight.setText(Double.toString(model.getWeight()));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView prodcutName;
        public final TextView prodcutPrice;
        public final TextView productWeight;
        public Product product;

        public ViewHolder(FragmentBeverageBinding binding) {
            super(binding.getRoot());
            prodcutName = binding.productName;
            prodcutPrice = binding.productPrice;
            productWeight = binding.productWeight;


            itemView.findViewById(R.id.button_order).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(binding.getRoot().getContext(), "clicked add bevereges",Toast.LENGTH_SHORT).show();

                    ShoppingCart.getInstance().addProduct(product);
                }
            });
        }


        @Override
        public String toString() {
            return super.toString() + " '" + prodcutPrice.getText() + "'";
        }
    }
}