package com.example.pizzaapp.ui.pizza;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaapp.R;
import com.example.pizzaapp.databinding.FragmentPizzaBinding;
import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.models.ShoppingCart;
import com.example.pizzaapp.ui.burger.BurgerRecyclerViewAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.List;
// Hadi
public class PizzaRecyclerViewAdapter extends FirestoreRecyclerAdapter<Product, PizzaRecyclerViewAdapter.ViewHolder> {



    public PizzaRecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPizzaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }



    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Product model) {
        holder.product = model;
        holder.prodcutName.setText(model.getName());
        holder.productDescription.setText(model.getDescription());
        holder.productIngredients.setText(model.getIngredients());
        holder.prodcutPrice.setText(Double.toString(model.getPrice()));
        holder.productWeight.setText(Double.toString(model.getWeight()));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView prodcutName;
        public final TextView prodcutPrice;
        public final TextView productIngredients;
        public final TextView productDescription;
        public final TextView productWeight;
        public Product product;

        public ViewHolder(FragmentPizzaBinding binding) {
            super(binding.getRoot());
            prodcutName = binding.productName;
            prodcutPrice = binding.productPrice;
            productWeight = binding.productWeight;
            productIngredients = binding.productIngredients;
            productDescription = binding.productDescription;

            itemView.findViewById(R.id.button_order).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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