package fr.afcepf.al26.test;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.afcepf.al26.dto.ProduitDto;
import fr.afcepf.al26.dto.ValeursDto;
import fr.afcepf.al26.idao.Generic;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandrequere on 1/04/2016.
 */
public class MainTest {
    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    private final static String DATABASE = "idkdostat";
    private final static String COLLECTION = "produits";
    private static Logger log = Logger.getLogger(MainTest.class);

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(HOST, PORT);
        MongoDatabase db = mongoClient.getDatabase(DATABASE);
        log.info("Connect to database successfully to " + DATABASE);
        String catalogue = "IDKDO Romantique";
        String month = "2";

        MongoCollection<Document> collection = db.getCollection(Generic.COLLECTION_PRODUIT);

        Document match = Document.parse("{$match: {'commande.vendeur':'IDKDO',catalogue:'" + catalogue + "','commande.date':{'$gte':ISODate('2015-01-01')}}}");
        Document project = Document.parse("{$project:{name:1,quantite:1,'month':{$month:'$commande.date'}}}");
        Document group = Document.parse("{$group:{_id:{'produit':'$name','date':'$month'},'total':{$sum:'$quantite'}}}");
        Document project2 = Document.parse("{$project:{'_id':0,nomProduit:'$_id.produit',mois:'$_id.date',total:1}}");
        Document match2 = Document.parse("{$match:{mois:"+month+"}}");
        final List<ValeursDto> valeursDtoList = new ArrayList<>();
        List<Document> operations = new ArrayList<>();
        ProduitDto produitDto = new ProduitDto(month);
        operations.add(match);
        operations.add(project);
        operations.add(group);
        operations.add(project2);
        if (!month.isEmpty()){
            operations.add(match2);
        }
        //List<Document> iterable = collection.aggregate(operations).into(new ArrayList<Document>());
        AggregateIterable<Document> iterable = collection.aggregate(operations);
/*
        for (Document doc :
                iterable) {
            ValeursDto valeursDto = new ValeursDto(doc.getString("nomProduit"), String.valueOf(doc.getInteger("total")));
            valeursDtoList.add(valeursDto);
        }
        */
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document paramDocument) {
                log.info("A tester : "+paramDocument.toJson());
                ValeursDto valeursDto = new ValeursDto(paramDocument.getString("nomProduit"),String.valueOf(paramDocument.getInteger("total")));
                log.info(valeursDto.toString());
                valeursDtoList.add(valeursDto);
            }
        });
        produitDto.setValeursDtos(valeursDtoList);
        log.info("le final : "+produitDto.toString());
    }
}
