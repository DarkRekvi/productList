package com.example.actorfragment.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.actorfragment.Options;
import com.example.actorfragment.entities.Product;
import com.example.actorfragment.adapters.ProductAdapter;
import com.example.actorfragment.R;
import com.example.actorfragment.databinding.FragmentListBinding;

import java.util.ArrayList;
import java.util.Date;

public class ListFragment extends Fragment {

    FragmentListBinding binding;
    public static ArrayList<Product> products = new ArrayList<>();
    public ListView productsList;

    public ListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setInitialData();
        setInitList(view);
        addUserBtnInit();
    }

    private void setInitList(View view) {
        productsList = binding.productsList;

        ProductAdapter productAdapter = new ProductAdapter(this.getContext(), R.layout.list_item, products);

        productsList.setAdapter(productAdapter);

//        AdapterView.OnItemClickListener itemAddListener = (parent, v, position, id) -> {
//            Actor selectedActor = (Actor)parent.getItemAtPosition(position);
//            Toast.makeText(getContext(), "Был выбран пункт " + selectedActor.getFullName(),
//                    Toast.LENGTH_SHORT).show();
//        };
//        actorsList.setOnItemClickListener(itemAddListener);

        AdapterView.OnItemLongClickListener itemDeleteListener = (parent, v, position, id) -> {
            Product selectedActor = (Product)parent.getItemAtPosition(position);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new RemoveProductFragment(selectedActor, id),"remove_actor")
                    .addToBackStack(null)
                    .commit();
            return false;
        };

        productsList.setOnItemLongClickListener(itemDeleteListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void addUserBtnInit(){
        binding.addProductBtn.setOnClickListener((view)->{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment, new AddProductFragment(),"add_actor")
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void setInitialData(){

    }
}