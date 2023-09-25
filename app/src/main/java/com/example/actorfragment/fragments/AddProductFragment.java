package com.example.actorfragment.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.actorfragment.databinding.FragmentAddProductBinding;
import com.example.actorfragment.entities.Product;
import com.example.actorfragment.databinding.FragmentAddProductBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.Calendar;
import java.util.Date;

public class AddProductFragment extends Fragment {

    FragmentAddProductBinding binding;

    public AddProductFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commitBtnInit();
    }



    private void commitBtnInit(){
        binding.commitBtn.setOnClickListener((v)->{
            String Name = binding.productName.getText().toString();
            String Type = binding.productType.getText().toString();
            String Company = binding.productCompany.getText().toString();
            Product product = new Product(Name, Type, Company);

            ListFragment.products.add(product);

            getActivity().getSupportFragmentManager().popBackStack();
        });
    }
}