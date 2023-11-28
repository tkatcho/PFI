package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;

import java.util.List;

import kotlin.Pair;

public class PanierPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier_page);


        Intent intent = getIntent();
        if (intent != null) {
            Panier panier = (Panier) intent.getSerializableExtra("panier");

            if (panier != null) {
                List<Pair<Produit, Integer>> produits = panier.getProduits();
                int prixTotal = panier.getPrixTotal();

                for (Pair<Produit, Integer> pair : produits) {
                    Produit produit = pair.getFirst();
                    int quantite = pair.getSecond();
                    Log.d("PanierData", "Produit: " + produit + ", Quantite: " + quantite);
                }

                Log.d("PanierData", "Prix Total: " + prixTotal);
            }
        }
    }
}