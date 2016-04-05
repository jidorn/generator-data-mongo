package fr.afcepf.al26.idao;

import org.apache.log4j.Logger;

/**
 * Nom des informations pour la configurations et pour mongodb.
 */
public interface Generic {
    String HOST = "localhost";
    int PORT = 27017;
    String DATABASE = "idkdostat";
    String COLLECTION_PRODUIT = "produits";
    String COLLECTION_STOCK = "stock";
    String PRODUIT_NAME = "nom_produit";
    String REFERENCE_PRODUIT = "ref_produit";
    String PRODUIT_PRIX = "prix_produit";
    String PRODUIT_QUANTITY = "quantity_produit";
    String PRODUIT_COMMANDE = "commande";
    String COMMANDE_NUMERO = "numero_commande";
    String COMMANDE_DATE = "date_commande";
    String COMMANDE_VENDEUR = "vendeur_commande";
    String STOCK_QUANTITY = "quantity_stock";
}
