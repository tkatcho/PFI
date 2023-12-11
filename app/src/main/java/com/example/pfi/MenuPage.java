package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;

import java.util.ArrayList;
import java.util.List;

public class MenuPage extends AppCompatActivity {
    Panier panier = new Panier();

    List<Produit> produitList = new ArrayList<>();

    /**
     * initialise le RecyclerView et la liste de produit
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        RecyclerView recyclerView = findViewById(R.id.recycler);


        initializeProducts();

       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(new Adapter(getApplicationContext(), produitList));
    }


    /**
     * Initialise tout les produits dans la liste produitList
     */
    private void initializeProducts(){
        produitList.add(new Produit("Breakfast",5,"Un bon dejeuner",R.drawable.breakfast,5));
        produitList.add(new Produit("Fish",10,"Poisson fraichement ceuilli",R.drawable.fish,3));
        produitList.add(new Produit("Fish Taco",15,"Taco poisson",R.drawable.fishtaco,1));
        produitList.add(new Produit("Calimar fri",10,"Amazing calmari straight from the waters of the artic ocean",R.drawable.friedcalimari,5));
        produitList.add(new Produit("Choix du chef",10,"Pense tu etre chanceux aujourd'hui?",R.drawable.luckylunch,2));
        produitList.add(new Produit("Choix du travailleur",5,"Un bon dejeuner",R.drawable.minerstreat,5));
        produitList.add(new Produit("Pancakes",10,"Recouvert de nutella, creme et fraises",R.drawable.pancakes,5));
        produitList.add(new Produit("PepperPoppers",4,"Excellent entrer",R.drawable.pepperpoppers,5));
        produitList.add(new Produit("Pie",12,"Une bonne tarte au pommes",R.drawable.pie,5));
        produitList.add(new Produit("Gateau rose",30,"Un gateau pour une occasion speciale",R.drawable.pinkcake,2));
        produitList.add(new Produit("Red hot challenge",10,"Un menu qui brulera votre langue",R.drawable.spicy,5));
        produitList.add(new Produit("Burger",10,"Un bon burger ordinaire",R.drawable.survivalburger,5));
        produitList.add(new Produit("Legumes",10,"Un bon choix vegetarien",R.drawable.vegetable,5));
    }

    /**
     * Crée un intent pour l'envoyer à la prochaine page
     * @param view
     * // peut être va retourner qqch bc logcat says that there's an error w this class
     */
    public int Buy(View view){
     Intent intent = new Intent(this, PanierPageActivity.class);
     intent.putExtra("panier",panier);
     startActivity(intent);
    }
}