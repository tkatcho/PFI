package com.example.pfi.classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfi.R;

/**
 * Classe qui initialise les Views et layout du recycler view (ViewHolder)
 */
public class ViewHolder extends RecyclerView.ViewHolder {

   public ImageView imageView;
    public TextView nameView , priceView;
    public View linearLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        linearLayout = itemView.findViewById(R.id.linear);
    }
}
