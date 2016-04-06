//requete 1 sans tri par mois
db.produits.aggregate([
    {$match: {"commande.vendeur":"IDKDO",catalogue:"IDKDO Romantique","commande.date":{"$gte":ISODate("2015-01-01")}}},
    {$project:{name:1,quantite:1,"month":{$month:"$commande.date"}}},
    {$group:{_id:{"produit":"$name","date":"$month"},"total":{$sum:"$quantite"}}}
]).pretty();

//requete 1 avec tri par mois
db.produits.aggregate([{$match: {"commande.vendeur":"IDKDO",catalogue:"IDKDO Romantique","commande.date":{"$gte":ISODate("2015-01-01")}}},{$project:{name:1,quantite:1,"month":{$month:"$commande.date"}}},{$group:{_id:{"produit":"$name","date":"$month"},"total":{$sum:"$quantite"}}},{$project:{"_id":0,prod:"$_id.produit",mois:"$_id.date",total:1}},{$match:{mois:9}}]).pretty();
