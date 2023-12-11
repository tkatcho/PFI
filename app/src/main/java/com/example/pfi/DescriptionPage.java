package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;
import com.example.pfi.databinding.ActivityDescriptionPageBinding;

import java.util.Set;

public class DescriptionPage extends AppCompatActivity {
    private ActivityDescriptionPageBinding binding;
    private Produit product;

    private int chosenQuantite;
    private Panier panier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_description_page);

        Intent intent = getIntent();
        product = (Produit) intent.getSerializableExtra("product");
        panier = (Panier) intent.getSerializableExtra("panier");

        //for testing
        product = new Produit("Breakfast",5,"Un bon dejeuner", R.drawable.vegetable,5);


        binding.setProduct(product);

        binding.setQuantityInput(String.valueOf(product.getQuantite()));
        binding.quantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    int newQuantity = Integer.parseInt(charSequence.toString());
                    chosenQuantite = newQuantity;
                } catch (NumberFormatException e) {
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void onBuyButtonClick(View view) {
        if (chosenQuantite > 0 && chosenQuantite <= product.getQuantite()) {
            panier.ajouterProduit(product,chosenQuantite);
            Intent intent = new Intent(this, MenuPage.class);
            intent.putExtra("source","desc");
            intent.putExtra("panier",panier);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid quantity selected.", Toast.LENGTH_SHORT).show();
        }
    }
}