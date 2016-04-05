package fr.afcepf.al26.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by alexandrequere on 5/04/2016.
 */
@XmlRootElement
public class ProduitDto {
    private String nom;
    private List<ValeursDto> valeursDtos;

    public ProduitDto() {
    }

    public ProduitDto(String paramNom, List<ValeursDto> paramValeursDtos) {
        nom = paramNom;
        valeursDtos = paramValeursDtos;
    }

    public ProduitDto(String paramNom) {
        nom = paramNom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String paramNom) {
        nom = paramNom;
    }

    public List<ValeursDto> getValeursDtos() {
        return valeursDtos;
    }

    public void setValeursDtos(List<ValeursDto> paramValeursDtos) {
        valeursDtos = paramValeursDtos;
    }

    @Override
    public String toString() {
        return "ProduitDto{" +
                "nom='" + nom + '\'' +
                ", valeursDtos=" + valeursDtos +
                '}';
    }
}
