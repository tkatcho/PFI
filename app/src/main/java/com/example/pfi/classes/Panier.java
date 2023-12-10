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
    public boolean ajouterProduit(Produit produit, int quantite) {
        // Check if the requested quantity is available
        if (quantite > 0 && quantite <= produit.getQuantite()) {
            produits.add(new Pair<>(produit, quantite));
            prixTotal += produit.getPrix() * quantite;
            return true;
        } else {
            System.out.println("Error: Insufficient quantity available for product " + produit.getNom());
            return false;
        }
    }

    public void retirerProduit(Produit produit, int quantite) {
        // Check if the requested quantity is valid
        if (quantite > 0) {
            // Find the Pair in the list that matches the specified product and quantity
            for (Pair<Produit, Integer> pair : produits) {
                if (pair.getFirst().equals(produit) && pair.getSecond() == quantite) {
                    produits.remove(pair);
                    prixTotal -= produit.getPrix() * quantite;
                    return;
                }
            }

            System.out.println("Error: Product " + produit.getNom() + " with quantity " + quantite + " not found in the cart");
        } else {
            System.out.println("Error: Invalid quantity specified for product " + produit.getNom());
        }
    }

    public List<Pair<Produit, Integer>> getProduits() {
        return produits;
    }
    public Produit getProduitIdx(int idx) {
        if (idx >= 0 && idx < produits.size()) {
            Pair<Produit, Integer> pair = produits.get(idx);
            return pair.getFirst();
        } else {
            // Handle the case where the index is out of bounds
            System.out.println("Error: Index out of bounds");
            return null; // Or throw an exception, depending on your error handling strategy
        }
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
