package com.example.actorfragment.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.actorfragment.databinding.FragmentRemoveProductBinding;
import com.example.actorfragment.entities.Product;
import com.example.actorfragment.databinding.FragmentRemoveProductBinding;

public class RemoveProductFragment extends Fragment {


    FragmentRemoveProductBinding binding;

    Product selectedProduct;
    long selectedProductId;

    public RemoveProductFragment(Product selectedProduct, long selectedProductId) {
        this.selectedProduct = selectedProduct;
        this.selectedProductId = selectedProductId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRemoveProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setData();
        agreeBtnInit();
        disagreeBtnInit();
    }

    private void agreeBtnInit(){
        binding.selectedAgreeBtn.setOnClickListener(view -> {
            ListFragment.products.remove((int) selectedProductId);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    private void disagreeBtnInit(){
        binding.selectedDisagreeBtn.setOnClickListener(view -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    public void setData(){
        binding.selectedProductName.setText(selectedProduct.getName());
        binding.selectedProductType.setText(selectedProduct.getType());
        binding.selectedProductCompany.setText(selectedProduct.getCompany());
    }

}