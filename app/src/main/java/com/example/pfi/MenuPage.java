package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;
import com.example.pfi.classes.User;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends AppCompatActivity {
    Panier panier = new Panier();
    MediaPlayer mp;
    List<Produit> produitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        RecyclerView RecyclerView = findViewById(R.id.recycler);
        mp = MediaPlayer.create(this, R.raw.christmassong);
        //mp.stop();
        mp.start();
        Intent intent = getIntent();

        if(intent!=null){
            String sourceActivity = intent.getStringExtra("source");
            if(sourceActivity!=null && sourceActivity.equals("desc")){
                panier = (Panier) intent.getSerializableExtra("panier");
                Toast.makeText(this,"in the basket!",Toast.LENGTH_LONG).show();
            }
        }


        initializeProducts();
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(new Adapter(this, produitList));

    }


    /**
     * Dans cette classe, nous ajoutons les produits dans produitsList
     */
    private void initializeProducts(){
        produitList.add(new Produit("Breakfast",5,"A good breakfast!",R.drawable.breakfast,5));
        produitList.add(new Produit("Fish",10,"Fresh fish",R.drawable.fish,3));
        produitList.add(new Produit("Fish Taco",15,"Delicious fish taco",R.drawable.fishtaco,1));
        produitList.add(new Produit("Calmar fri",10,"Amazing calmar straight from the waters of the artic ocean",R.drawable.friedcalimari,5));
        produitList.add(new Produit("Chef's choice",10,"Are you lucky today?",R.drawable.luckylunch,2));
        produitList.add(new Produit("Worker's choice",5,"A delicicous breakfast",R.drawable.minerstreat,5));
        produitList.add(new Produit("Pancakes",10,"Covered with nutella, cream and strawberries",R.drawable.pancakes,5));
        produitList.add(new Produit("PepperPoppers",4,"Excellent appetizer",R.drawable.pepperpoppers,5));
        produitList.add(new Produit("Pie",12,"A delicious apple pie",R.drawable.pie,5));
        produitList.add(new Produit("Pink cake",30,"A special cake for a special occasion!",R.drawable.pinkcake,2));
        produitList.add(new Produit("Red hot challenge",10,"This one will burn your tongue!",R.drawable.spicy,5));
        produitList.add(new Produit("Burger",10,"A good ordinary burger",R.drawable.survivalburger,5));
        produitList.add(new Produit("Veggie",10,"A good vegetarian choice!",R.drawable.vegetable,5));
    }

    /**
     *classe qui emmène l'usager vers la page de description
     * @param view
     */
    public void description(View view){
        Intent intent = new Intent(this, DescriptionPage.class);
        intent.putExtra("panier",panier);
        intent.putExtra("produit","produitAMettre");
        startActivity(intent);
    }

    /**
     * classe qui va emmener l'usager vers la page du panier
     * @param view
     */
    public void Buy(View view){
        Intent intent = new Intent(this, PanierPageActivity.class);
        User user = new User("tk","tk",10);
        mp.stop();
        intent.putExtra("panier",panier);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}