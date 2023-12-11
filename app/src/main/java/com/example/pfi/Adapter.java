package com.example.pfi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfi.classes.Produit;
import com.example.pfi.classes.ViewHolder;

import java.util.List;

/**
 * Classe pour créer l'adapter de mon RecyclerView
 */
public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Produit> produits;

    //initialisation

    public Adapter(Context context, List<Produit> produitList) {
        this.context = context;
        this.produits = produitList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Produit product = produits.get(position);


        holder.nameView.setText(product.getNom());
        holder.priceView.setText(String.valueOf(product.getPrix())); // Convert int to String
        holder.imageView.setImageResource(product.getImagePath());

        // Set an OnClickListener on the LinearLayout
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send to another page
                Intent intent = new Intent(view.getContext(), DescriptionPage.class);

                // Pass the product
                intent.putExtra("product", product);
                // Start the description activity
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return produits != null ? produits.size() : 0;
    }
}