package com.example.pizzaapp.ui.burger;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.pizzaapp.databinding.FragmentBurgerBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class BurgerRecyclerViewAdapter extends RecyclerView.Adapter<BurgerRecyclerViewAdapter.ViewHolder> {

    private final List<Product> productList;

    public BurgerRecyclerViewAdapter(List<Product> items) {
        productList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentBurgerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.product = productList.get(position);
        holder.prodcutName.setText(productList.get(position).getName());
        holder.productDescription.setText(productList.get(position).getDescription());
        holder.productIngredients.setText(productList.get(position).getIngredients());
        holder.prodcutPrice.setText(Double.toString(productList.get(position).getPrice()));
        holder.productWeight.setText(Double.toString(productList.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView prodcutName;
        public final TextView prodcutPrice;
        public final TextView productIngredients;
        public final TextView productDescription;
        public final TextView productWeight;
        public Product product;

        public ViewHolder(FragmentBurgerBinding binding) {
            super(binding.getRoot());
            prodcutName = binding.productName;
            prodcutPrice = binding.productPrice;
            productIngredients = binding.productIngredients;
            productDescription = binding.productDescription;
            productWeight = binding.productWeight;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + prodcutPrice.getText() + "'";
        }
    }
}