package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends AppCompatActivity {
    Panier panier = new Panier();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        RecyclerView RecyclerView = findViewById(R.id.recycler);

        List<Produit> items =  new ArrayList<Produit>();
        items.add(new Produit("Breakfast",2,"description",R.drawable.breakfast,1)); // for now


        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(new Adapter(getApplicationContext(),));
    }


    private void initializeProducts(){

    }

    public void Buy(View view){
        Intent intent = new Intent(this, PanierPageActivity.class);
        intent.putExtra("panier",panier);
        startActivity(intent);
    }
}