package com.example.pfi.classes;

import kotlin.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Panier implements Serializable {
    private List<Pair<Produit, Integer>> produits = new ArrayList<>();
    private int prixTotal = 0;

    public Panier() {

    }

    // Methods to manipulate the products in the cart
    public void ajouterProduit(Produit produit, int quantite) {
        produits.add(new Pair<>(produit, quantite));
        prixTotal += produit.getPrix() * quantite;
    }

    public void retirerProduit(Produit produit, int quantite) {
        produits.removeIf(pair -> pair.getFirst().equals(produit) && pair.getSecond() == quantite);
        prixTotal -= produit.getPrix() * quantite;
    }

    public List<Pair<Produit, Integer>> getProduits() {
        return produits;
    }

    public int getPrixTotal() {
        return prixTotal;
    }


    @Override
    public String toString() {
        return "Panier{" +
                "produits=" + produits +
                ", prixTotal=" + prixTotal +
                '}';
    }
}
