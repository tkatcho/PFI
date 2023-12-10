package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.pfi.classes.Produit;
import com.example.pfi.databinding.ActivityDescriptionPageBinding;

import java.util.Set;

public class DescriptionPage extends AppCompatActivity {
    private ActivityDescriptionPageBinding binding;
    private Produit product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_description_page);

        // Simulate a product (replace with your actual product)
        product = new Produit("Breakfast",5,"Un bon dejeuner", R.drawable.vegetable,5);

        
        binding.setProduct(product);

         //Set up two-way data binding for the quantity input
        binding.setQuantityInput(String.valueOf(product.getQuantite()));
        binding.quantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    int newQuantity = Integer.parseInt(charSequence.toString());
                    product.setQuantite(newQuantity);
                } catch (NumberFormatException e) {
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void onBuyButtonClick(View view) {
        // Handle the buy button click here
        int quantityToBuy = product.getQuantite();

        // Check if quantity is within the allowed range (minimum and maximum)
        if (quantityToBuy > 0 && quantityToBuy < product.getQuantite()) {

            // Perform the purchase or other action
            // You can access the quantity as product.getQuantity()
        } else {
            Toast.makeText(this, "Invalid quantity selected.", Toast.LENGTH_SHORT).show();
        }
    }
}