package fr.afcepf.al26.idao;

import fr.afcepf.al26.dto.Produit;
import fr.afcepf.al26.entities.Commande;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexandrequere on 1/04/2016.
 */
@Repository
public interface IProduitDao {
    Produit create(Produit paramProduit);

    Produit getProduitById(String paramId);

    Produit getProduitByRef(String paramRef);

    Produit updateProduit(Produit paramProduit);

    void deteProduit(Produit paramProduit);

    List<Produit> getProduitByDateCommande(String date);

    List<Produit> getCommandeByVendeur(String paramVendeur);

    List<Produit> getProduitByCommande(Commande paramCommande);

}
