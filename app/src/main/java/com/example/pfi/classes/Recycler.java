package com.example.pfi.classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfi.R;

public class Recycler extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView , priceView;
    public Recycler(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
    }
}
