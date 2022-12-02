package com.example.pizzaapp.ui.pizza;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pizzaapp.R;
import com.example.pizzaapp.models.Product;
import com.example.pizzaapp.repositories.ProductRepository;
import com.example.pizzaapp.ui.burger.BurgerRecyclerViewAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
// Hadi
public class PizzaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private PizzaRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PizzaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PizzaFragment newInstance(int columnCount) {
        PizzaFragment fragment = new PizzaFragment();
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
        View view = inflater.inflate(R.layout.fragment_pizza_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            FirestoreRecyclerOptions<Product> options = new FirestoreRecyclerOptions.Builder<Product>()
                    .setQuery(ProductRepository.getInstance().getAllPizzas(), Product.class)
                    .build();

            adapter = new PizzaRecyclerViewAdapter(options);

            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.startListening();
    }
}