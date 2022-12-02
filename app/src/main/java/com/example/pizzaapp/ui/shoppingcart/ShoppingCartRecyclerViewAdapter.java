package com.example.pizzaapp.ui.shoppingcart;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaapp.R;
import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.databinding.FragmentShoppingCartItemBinding;
import com.example.pizzaapp.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
// Hadi
public class ShoppingCartRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingCartRecyclerViewAdapter.ViewHolder> {

    private List<Product> productList;
    private OnListItemClickListener listener;

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public void setOnItemClickListener (OnListItemClickListener clickedListener){
        listener = clickedListener;
    }


    public ShoppingCartRecyclerViewAdapter(ArrayList<Product> items) {
        productList = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentShoppingCartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), listener);

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
        public final Button button;
        public Product product;

        public ViewHolder(FragmentShoppingCartItemBinding binding, OnListItemClickListener listener) {
            super(binding.getRoot());
            prodcutName = binding.productName;
            prodcutPrice = binding.productPrice;
            productIngredients = binding.productIngredients;
            productDescription = binding.productDescription;
            productWeight = binding.productWeight;
            button = binding.productButtonRemove;

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onListItemClick(getAdapterPosition());
                }
            });

        }

        @Override
        public String toString() {
            return super.toString() + " '" + prodcutPrice.getText() + "'";
        }

    }
}