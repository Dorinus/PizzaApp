package com.example.pizzaapp.ui.shoppingcart;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.pizzaapp.R;
import com.example.pizzaapp.models.ShoppingCart;

/**
 * A fragment representing a list of Items.
 */
// Hadi
public class shoppingCartFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public shoppingCartFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static shoppingCartFragment newInstance(int columnCount) {
        shoppingCartFragment fragment = new shoppingCartFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            ShoppingCartRecyclerViewAdapter adapter = new ShoppingCartRecyclerViewAdapter(ShoppingCart.getInstance().getProducts());
            recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new ShoppingCartRecyclerViewAdapter.OnListItemClickListener() {
                @Override
                public void onListItemClick(int clickedItemIndex) {
                    ShoppingCart.getInstance().removeIndex(clickedItemIndex);
                    adapter.notifyItemRemoved(clickedItemIndex);
                }
            });

        }
        return view;
    }

}