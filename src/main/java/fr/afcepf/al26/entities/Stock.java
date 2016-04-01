package fr.afcepf.al26.entities;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public class Stock {
    private String refProduit;
    private String nameStock;
    private int quantity;

    public Stock() {
    }

    public Stock(String refProduit, String nameStock, int quantity) {
        this.refProduit = refProduit;
        this.nameStock = nameStock;
        this.quantity = quantity;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    public String getNameStock() {
        return nameStock;
    }

    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                ", refProduit='" + refProduit + '\'' +
                ", nameStock='" + nameStock + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
