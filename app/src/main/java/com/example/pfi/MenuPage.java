package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;

public class MenuPage extends AppCompatActivity {
    Panier panier = new Panier();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
    }

    /**
     * Class to set fonts
     *
     */



    private void initializeProducts(){

    }

    public void Buy(View view){
        Intent intent = new Intent(this, PanierPageActivity.class);
        intent.putExtra("panier",panier);
        startActivity(intent);
    }
}