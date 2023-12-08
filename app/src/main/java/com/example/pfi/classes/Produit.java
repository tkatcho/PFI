package com.example.pfi.classes;

import java.io.Serializable;

public class Produit implements Serializable {
    private String nom;
    private int prix;
    private int quantite;//quantite qu'il y a
    private String description;
    private int imagePath;

    public Produit(String nom, int prix, String description, int imagePath,int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.imagePath = imagePath;
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
