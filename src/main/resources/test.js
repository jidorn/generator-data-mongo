//produit #1
[
    '{{repeat(500, 1000)}}',
    {
        _id: '{{objectId()}}',
        name: function (tags) {
            var produit = [
                "Livre romantique",
                "Livraison de rose",
                "Boite à musique",
                "bougies parfumées",
                "Boite à musique gravée",
                "Verre à whisky gravée",
                "Coussin personnalisé-photo",
                "Plante messagère grow me",
                "Taylor Swift CD Album",
                "Boite de chocolat coeur",
                "If you wait CD Album"
            ];
            return produit[tags.integer(0, produit.length - 1)];
        },
        prix: "{{integer(200,500,'$0,0.00')}}",
        quantite: "{{integer(1,10)}}",
        catalogue: "IDKDO Romantique",
        commande: {
            numero: "{{objectId()}}",
            date: "{{date(new Date(2006,0,1), new Date())}}",
            vendeur: "IDKDO"
        }
    }
]

//produit #2
    ['{{repeat(500, 1000)}}',
{
    _id: '{{objectId()}}',
    name: function (tags) {
        var produit = [
            "Miffy Lampe grand modele",
            "Peluche doudou lapin Miffy",
            "Mobile lumineux nuit étoilé VTECH",
            "Super livre enchanté"
        ];
        return produit[tags.integer(0, produit.length - 1)];
    },
    prix: "{{integer(200,500,'$0,0.00')}}",
    quantite: "{{integer(1,10)}}",
    catalogue: "Miffy Naissance",
    commande: {
        numero: "{{objectId()}}",
        date: "{{date(new Date(2006,0,1), new Date(),'ISODateTimeTZ')}}",
        vendeur: "IDKDO"
    }
}
    ]


//produit #3
    [
    '{{repeat(500, 1000)}}',
    {
        _id: '{{objectId()}}',
        name: function (tags) {
            var produit = [
                "Livre romantique",
                "Livraison de rose",
                "Boite à musique",
                "bougies parfumées",
                "Boite à musique gravée",
                "Verre à whisky gravée",
                "Coussin personnalisé-photo",
                "Plante messagère grow me",
                "Taylor Swift CD Album",
                "Boite de chocolat coeur",
                "If you wait CD Album"
            ];
            return produit[tags.integer(0, produit.length - 1)];
        },
        prix: "{{integer(200,500,'$0,0.00')}}",
        quantite: "{{integer(1,10)}}",
        catalogue: "IDKDO Accessoire Femme",
        commande: {
            numero: "{{objectId()}}",
            date: "{{date(new Date(2006,0,1), new Date(),'ISODateTimeTZ')}}",
            vendeur: "IDKDO"
        }
    }
    ]

//produit #4
    [
    '{{repeat(500, 1000)}}',
    {
        _id: '{{objectId()}}',
        name: function (tags) {
            var produit = [
                "Verre whisky gravé",
                "Coussin personnalisé photo",
                "plante messagere grow me",
                "Taylor Swift CD Album",
                "Boite de chocolat coeur",
                "If you wait CD Album"
            ];
            return produit[tags.integer(0, produit.length - 1)];
        },
        prix: "{{integer(200,500,'$0,0.00')}}",
        quantite: "{{integer(1,10)}}",
        catalogue: "IDKDO Accessoire Homme",
        commande: {
            numero: "{{objectId()}}",
            date: "{{date(new Date(2006,0,1), new Date(),'ISODateTimeTZ')}}",
            vendeur: "IDKDO"
        }
    }
    ]


//produit #5
    [
    '{{repeat(500, 1000)}}',
    {
        _id: '{{objectId()}}',
        name: function (tags) {
            var produit = [
                "collier en platine",
                "Boucle d'oreille Love",
                "Collier Love"
            ];
            return produit[tags.integer(0, produit.length - 1)];
        },
        prix: "{{integer(200,500,'$0,0.00')}}",
        quantite: "{{integer(1,10)}}",
        catalogue: "Dinh Bijoux Femme",
        commande: {
            numero: "{{objectId()}}",
            date: "{{date(new Date(2006,0,1), new Date(),'ISODateTimeTZ')}}",
            vendeur: "Dinh Van"
        }
    }
    ]


//produit #5
    [
    '{{repeat(500, 1000)}}',
    {
        _id: '{{objectId()}}',
        name: function (tags) {
            var produit = [
                "Boutons de manchette Punaise",
                "Bague Margot argent et spinelle noire"
            ];
            return produit[tags.integer(0, produit.length - 1)];
        },
        prix: "{{integer(200,500,'$0,0.00')}}",
        quantite: "{{integer(1,10)}}",
        catalogue: "Dinh Bijoux Homme",
        commande: {
            numero: "{{objectId()}}",
            date: "{{date(new Date(2006,0,1), new Date(),'ISODateTimeTZ')}}",
            vendeur: "Dinh Van"
        }
    }
    ]

