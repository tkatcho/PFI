package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfi.classes.Panier;
import com.example.pfi.classes.Produit;
import com.example.pfi.classes.User;

import java.util.List;

import kotlin.Pair;

/**
 * Gère le panier
 */
public class PanierPageActivity extends AppCompatActivity {
    private ProductAdapter adapter;
    private static Panier panier;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier_page);


        Intent intent = getIntent();
        panier = (Panier) intent.getSerializableExtra("panier");
        user = (User) intent.getSerializableExtra("user");


        ListView listView = findViewById(R.id.listViewProducts);
        adapter = new ProductAdapter(this, panier.getProduits());
        listView.setAdapter(adapter);

        TextView uname = findViewById(R.id.UserName);
        TextView umoney = findViewById(R.id.userMoney);
        TextView total = findViewById(R.id.total);

        uname.setText(user.getuName());
        umoney.setText("Balance:" + user.getMoney());
        total.setText("Total:" + panier.getPrixTotal());


        findViewById(R.id.cancelPurchaseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PanierPageActivity.this, MenuPage.class);
                intent1.putExtra("user",user);
                intent1.putExtra("panier",panier);
                intent1.putExtra("source","desc");
                startActivity(intent1);
            }
        });
        findViewById(R.id.CompleteTransaction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(panier.getPrixTotal() > user.getMoney()){
                    Toast.makeText(PanierPageActivity.this, "Not enough money", Toast.LENGTH_SHORT).show();
                }
                else{
                    user.setMoney(user.getMoney()-panier.getPrixTotal());
                    panier = new Panier();
                    Intent intent1 = new Intent(PanierPageActivity.this, FinalPage.class);
                    intent1.putExtra("user",user);
                    intent1.putExtra("panier",panier);
                    startActivity(intent1);
                }
            }
        });

        }
        public static void test(View v,Produit pos,Integer quantite){
            panier.retirerProduit(pos,quantite);
            panier.setPrixTotal(panier.calculerTotal());

        }
        public void uppdate(View view){
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }
}