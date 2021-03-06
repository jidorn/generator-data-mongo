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
import javax.ws.rs.core.MediaType;
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

    public RiaConnect() {
        mongoClient = new MongoClient(Generic.HOST, Generic.PORT);
        db = mongoClient.getDatabase(Generic.DATABASE);
        log.info("Connect to database successfully to " + Generic.DATABASE);
        collection = db.getCollection(Generic.COLLECTION_PRODUIT);
    }

    @PostConstruct
    public void init() {
        log.info("je passe par le post construct");
    }

    @GET
    @Produces("application/json " + ";charset=utf-8")
    @Path("/quantiteparproduit")
    public ProduitDto getQuantityByProduct(
            @DefaultValue("IDKDO Romantique") @QueryParam("catalogue") String catalogue,
            @DefaultValue("1") @QueryParam("moisAFournir") String mois) {
        log.info("la collection : " + collection);
        ProduitDto produitDto = new ProduitDto(mois);
        final List<ValeursDto> valeursDtoList = new ArrayList<>();
        Document match = Document.parse("{$match: {'commande.vendeur':'IDKDO',catalogue:'" + catalogue + "','commande.date':{'$gte':ISODate('2015-01-01')}}}");
        Document project = Document.parse("{$project:{name:1,quantite:1,'month':{$month:'$commande.date'}}}");
        Document group = Document.parse("{$group:{_id:{'produit':'$name','date':'$month'},'total':{$sum:'$quantite'}}}");
        Document project2 = Document.parse("{$project:{'_id':0,nomProduit:'$_id.produit',mois:'$_id.date',total:1}}");
        Document match2 = Document.parse("{$match:{mois:" + mois + "}}");
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
                log.info("A tester : " + paramDocument.toJson());
                ValeursDto valeursDto = new ValeursDto(paramDocument.getString("nomProduit"), String.valueOf(paramDocument.getInteger("total")));
                log.info(valeursDto.toString());
                valeursDtoList.add(valeursDto);
            }
        });
        produitDto.setValeursDtos(valeursDtoList);
        return produitDto;
    }

    @GET
    @Produces("application/json"+";charset=utf-8")
    @Path("/evolutionpardate")
    public ProduitDto getEvolutionProductByDate(
            @DefaultValue("IDKDO Romantique") @QueryParam("catalogue") String catalogue,
            @DefaultValue("If you wait CD Album")@QueryParam("article") String article) {
        Document matchX = Document.parse("{$match: {'commande.vendeur':'IDKDO',catalogue:'" + catalogue + "',name:'" + article + "','commande.date':{'$gte':ISODate('2015-01-01')}}}");
        Document projectX = Document.parse("{$project:{name:1,quantite:1,'month':{$month:'$commande.date'}}}");
        Document groupX = Document.parse("{$group:{_id:{'produit':'$name','date':'$month'},'total':{$sum:'$quantite'}}}");
        Document project2 = Document.parse("{$project:{'_id':0,nomProduit:'$_id.produit',mois:'$_id.date',total:1}}");
        List<Document> operationsX = new ArrayList<>();
        final List<ValeursDto> valeursDtoList = new ArrayList<>();
        ProduitDto produitDto = new ProduitDto(article);
        operationsX.add(matchX);
        operationsX.add(projectX);
        operationsX.add(groupX);
        operationsX.add(project2);
        AggregateIterable<Document> iterableX = collection.aggregate(operationsX);
        iterableX.forEach(new Block<Document>() {
            @Override
            public void apply(Document paramDocument) {
                log.info("A tester : "+paramDocument.toJson());
                ValeursDto valeursDto = new ValeursDto(String.valueOf(paramDocument.getInteger("mois")),String.valueOf(paramDocument.getInteger("total")));
                log.info(valeursDto.toString());
                valeursDtoList.add(valeursDto);
            }
        });


        produitDto.setValeursDtos(valeursDtoList);
        log.info("le final : "+produitDto.toString());

        return produitDto;
    }
}
