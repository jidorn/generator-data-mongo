package fr.afcepf.al26.programme;

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

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandrequere on 5/04/2016.
 */
@Path("/mongostat")
public class RiaConnect {
    private Logger log = Logger.getLogger(this.getClass());
    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    @PostConstruct
    public void init(){
        mongoClient = new MongoClient(Generic.HOST, Generic.PORT);
        db = mongoClient.getDatabase(Generic.DATABASE);
        log.info("Connect to database successfully to " + Generic.DATABASE);
        collection = db.getCollection(Generic.COLLECTION_PRODUIT);
    }
    @GET
    @Path("/quantiteparproduit")
    public ProduitDto getQuantityByProduct(
            @DefaultValue("IDKDO Romantique") @QueryParam("catalogue") String catalogue,
            @DefaultValue("1") @QueryParam("moisAFournir") String mois){
        ProduitDto produitDto = new ProduitDto(mois);
        final List<ValeursDto> valeursDtoList = new ArrayList<>();
        Document match = Document.parse("{$match: {'commande.vendeur':'IDKDO',catalogue:'" + catalogue + "','commande.date':{'$gte':ISODate('2015-01-01')}}}");
        Document project = Document.parse("{$project:{name:1,quantite:1,'month':{$month:'$commande.date'}}}");
        Document group = Document.parse("{$group:{_id:{'produit':'$name','date':'$month'},'total':{$sum:'$quantite'}}}");
        Document project2 = Document.parse("{$project:{'_id':0,prod:'$_id.produit',mois:'$_id.date',total:1}}");
        Document match2 = Document.parse("{$match:{mois:"+mois+"}}");
        List<Document> operations = new ArrayList<>();
        operations.add(match);
        operations.add(project);
        operations.add(group);
        operations.add(project2);
        operations.add(match2);
        AggregateIterable<Document> iterable = collection.aggregate(operations);
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
        return produitDto;
    }
}
