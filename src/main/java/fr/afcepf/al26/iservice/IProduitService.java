package fr.afcepf.al26.iservice;

import fr.afcepf.al26.dto.Produit;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public interface IProduitService {
    Produit creer(Produit paramProduit);
    Produit getProduitByRef(String paramRef);
}
