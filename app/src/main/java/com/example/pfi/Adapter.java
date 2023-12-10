package com.example.pfi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfi.classes.Produit;
import com.example.pfi.classes.ViewHolder;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Produit> produits;

    public Adapter(Context context) {
        this.context = context;
    }

    public Adapter(List<Produit> produits) {
        this.produits = produits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameView.setText(produits.get(position).getNom());
        holder.priceView.setText(produits.get(position).getPrix());
        holder.imageView.setImageResource(produits.get(position).getImagePath());
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }
}
