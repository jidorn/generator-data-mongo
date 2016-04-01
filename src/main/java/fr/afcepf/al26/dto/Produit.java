package fr.afcepf.al26.dto;

import fr.afcepf.al26.entities.Commande;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public class Produit {
    private String refProduit;
    private String nom;
    private double prix;
    private int quantite;
    private Commande commande;

    public Produit() {
    }

    public Produit(String paramRefProduit, String paramNom, double paramPrix, int paramQuantite, Commande paramCommande) {
        refProduit = paramRefProduit;
        nom = paramNom;
        prix = paramPrix;
        quantite = paramQuantite;
        commande = paramCommande;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String paramRefProduit) {
        refProduit = paramRefProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String paramNom) {
        nom = paramNom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double paramPrix) {
        prix = paramPrix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int paramQuantite) {
        quantite = paramQuantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande paramCommande) {
        commande = paramCommande;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "refProduit='" + refProduit + '\'' +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", commande=" + commande +
                '}';
    }
}
