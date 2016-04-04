//requete 1.
db.produits.aggregate([{$match: {"commande.vendeur":"IDKDO",catalogue:"IDKDO Romantique","commande.date":{"$gte":ISODate("2015-01-01")}}}, {$project:{name:1,quantite:1,"month":{$month:"$commande.date"}}}, {$group:{_id:{"produit":"$name","date":"$month"},"total":{$sum:"$quantite"}}}]).pretty()

