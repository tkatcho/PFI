package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;

public class MenuPage extends AppCompatActivity {
    Panier panier = new Panier();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
    }

    private void initializeProducts(){

    }

    public void Buy(View view){
        Intent intent = new Intent(this, PanierPageActivity.class);
        intent.putExtra("panier",panier);
        startActivity(intent);
    }
}