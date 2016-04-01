package fr.afcepf.al26.entities;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public class Commande {
    private String numero;
    private String date;
    private String vendeur;

    public Commande() {
    }

    public Commande(String paramNumero, String paramDate, String paramVendeur) {
        numero = paramNumero;
        date = paramDate;
        vendeur = paramVendeur;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "numero='" + numero + '\'' +
                ", date='" + date + '\'' +
                ", vendeur='" + vendeur + '\'' +
                '}';
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String paramNumero) {
        numero = paramNumero;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String paramDate) {
        date = paramDate;
    }

    public String getVendeur() {
        return vendeur;
    }

    public void setVendeur(String paramVendeur) {
        vendeur = paramVendeur;
    }
}
