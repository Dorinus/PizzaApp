package com.example.pizzaapp.ui.pizza;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pizzaapp.databinding.FragmentPizzaBinding;
import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.ui.pizza.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PizzaRecyclerViewAdapter extends RecyclerView.Adapter<PizzaRecyclerViewAdapter.ViewHolder> {

    private final List<Product> pizzas;

    public PizzaRecyclerViewAdapter(List<Product> items) {
        pizzas = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPizzaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.product = pizzas.get(position);
        holder.prodcutName.setText(pizzas.get(position).getName());
        holder.productDescription.setText("Description: "+pizzas.get(position).getDescription());
        holder.productIngredients.setText("Ingredients: " + pizzas.get(position).getIngredients());
        holder.prodcutPrice.setText(Double.toString(pizzas.get(position).getPrice()));
        holder.productWeight.setText(Double.toString(pizzas.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
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
        }

        @Override
        public String toString() {
            return super.toString() + " '" + prodcutPrice.getText() + "'";
        }
    }
}