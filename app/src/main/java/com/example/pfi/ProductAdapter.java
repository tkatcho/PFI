package com.example.pfi;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pfi.classes.Produit;

import java.util.List;

import kotlin.Pair;

public class ProductAdapter extends ArrayAdapter<kotlin.Pair<Produit, Integer>> {
    private List<Pair<Produit, Integer>> produitsList;

    public ProductAdapter(Context context, List<kotlin.Pair<Produit, Integer>> produits) {
        super(context, 0, produits);
        this.produitsList = produits;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_panier, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.tvImageView);
        TextView productName = convertView.findViewById(R.id.tvName);
        TextView productPrice = convertView.findViewById(R.id.tvPrice);
        TextView quantity = convertView.findViewById(R.id.tvQuantity);
        Button removeButton = convertView.findViewById(R.id.btnRemoveFromBuy);

        Pair<Produit, Integer> item = getItem(position);
        Produit produit = item.getFirst();
        Integer quantite = item.getSecond();


        imageView.setImageResource(produit.getImagePath());
        productName.setText(produit.getNom());
        productPrice.setText(String.valueOf("PRIX:"+produit.getPrix()*quantite));
        quantity.setText( "QTY:"+String.valueOf(quantite));

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Update the underlying data list and adapter
                produitsList.remove(position);

                notifyDataSetChanged();
                PanierPageActivity.test(v,item.getFirst(),item.getSecond());

            }
        });

        return convertView;
    }
}
