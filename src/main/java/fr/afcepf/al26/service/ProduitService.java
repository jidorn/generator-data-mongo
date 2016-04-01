package fr.afcepf.al26.service;

import fr.afcepf.al26.dto.Produit;
import fr.afcepf.al26.idao.IProduitDao;
import fr.afcepf.al26.iservice.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexandrequere on 1/04/2016.
 */
@Service
public class ProduitService implements IProduitService{

    @Autowired
    private IProduitDao produitDao;
    @Override
    public Produit creer(Produit paramProduit) {
        return produitDao.create(paramProduit);
    }

    @Override
    public Produit getProduitByRef(String paramRef) {
        return produitDao.getProduitByRef(paramRef);
    }
}
