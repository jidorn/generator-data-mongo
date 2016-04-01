package fr.afcepf.al26.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.afcepf.al26.dto.Produit;
import fr.afcepf.al26.entities.Commande;
import fr.afcepf.al26.idao.Generic;
import fr.afcepf.al26.idao.IProduitDao;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.List;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public class ProduitDao implements IProduitDao {
    private MongoClient mongoClient;
    private MongoDatabase db;
    private static Logger log = Logger.getLogger(ProduitDao.class);

    public ProduitDao() {
        mongoClient = new MongoClient(Generic.HOST,Generic.PORT);
        db = mongoClient.getDatabase(Generic.DATABASE);
        log.info("Connect to database successfully to " + Generic.DATABASE);
    }

    @Override
    public Produit create(Produit paramProduit) {
        MongoCollection<Document> collection = db.getCollection(Generic.COLLECTION_PRODUIT);
        Document document = new Document(Generic.REFERENCE_PRODUIT,paramProduit.getRefProduit())
                .append(Generic.PRODUIT_NAME,paramProduit.getNom())
                .append(Generic.PRODUIT_PRIX,paramProduit.getPrix())
                .append(Generic.PRODUIT_QUANTITY,paramProduit.getQuantite())
                .append(Generic.PRODUIT_COMMANDE,
                        new Document(Generic.COMMANDE_NUMERO,paramProduit.getCommande().getNumero())
                                .append(Generic.COMMANDE_DATE,paramProduit.getCommande().getDate())
                                .append(Generic.COMMANDE_VENDEUR,paramProduit.getCommande().getVendeur())
        );
        collection.insertOne(document);
        return paramProduit;
    }

    @Override
    public Produit getProduitById(String paramId) {
        return null;
    }

    @Override
    public Produit getProduitByRef(String paramRef) {
        MongoCollection<Document> collection = db.getCollection(Generic.COLLECTION_PRODUIT);
        Document document = collection.find(Filters.eq(Generic.REFERENCE_PRODUIT,paramRef)).first();
        Document currentCommande = (Document) document.get(Generic.PRODUIT_COMMANDE);
        return new Produit(document.getString(Generic.REFERENCE_PRODUIT),
                document.getString(Generic.PRODUIT_NAME),
                document.getDouble(Generic.PRODUIT_PRIX),
                document.getInteger(Generic.PRODUIT_QUANTITY),
                new Commande(currentCommande.getString(Generic.COMMANDE_NUMERO),
                        currentCommande.getString(Generic.COMMANDE_DATE),
                        currentCommande.getString(Generic.COMMANDE_VENDEUR)));
    }

    @Override
    public Produit updateProduit(Produit paramProduit) {
        return null;
    }

    @Override
    public void deteProduit(Produit paramProduit) {

    }

    @Override
    public List<Produit> getProduitByDateCommande(String date) {
        return null;
    }

    @Override
    public List<Produit> getCommandeByVendeur(String paramVendeur) {
        return null;
    }

    @Override
    public List<Produit> getProduitByCommande(Commande paramCommande) {
        return null;
    }
}
