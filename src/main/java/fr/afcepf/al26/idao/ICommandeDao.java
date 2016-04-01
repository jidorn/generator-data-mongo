package fr.afcepf.al26.idao;

import fr.afcepf.al26.entities.Commande;

import java.util.List;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public interface ICommandeDao {
    Commande create(Commande paramCommande);
    Commande getCommandeById(String paramId);
    Commande getCommandeByNumero(String paramNumero);
    Commande updateCommande(Commande paramCommande);
    void deteCommande(Commande paramCommande);
    List<Commande> getCommandeByDate(String date);
    List<Commande> getCommandeByVendeur(String paramVendeur);

}
