package com.example.pizzaapp.ui.beverages;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pizzaapp.databinding.FragmentBeverageBinding;
import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.ui.beverages.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class BeverageRecyclerViewAdapter extends RecyclerView.Adapter<BeverageRecyclerViewAdapter.ViewHolder> {

    private final List<Product> beverages;

    public BeverageRecyclerViewAdapter(List<Product> items) {
        beverages = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentBeverageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.product = beverages.get(position);
        holder.prodcutName.setText(beverages.get(position).getName());
        holder.prodcutPrice.setText(Double.toString(beverages.get(position).getPrice()));
        holder.productWeight.setText(Double.toString(beverages.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return beverages.size();
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
        }

        @Override
        public String toString() {
            return super.toString() + " '" + prodcutPrice.getText() + "'";
        }
    }
}