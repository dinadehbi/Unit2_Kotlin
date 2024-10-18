<?php
class Livre
{
    public $titre;
    public $isbn;
    public $auteurs;
}

class Auteur
{
    public $nom;
    public $prenom;
}

$livre1 = new Livre();
$livre1->titre = "Le Petit Prince";
$livre1->isbn = "9782266000016";
$livre1->auteurs = [
    new Auteur("Saint-Exupéry", "Antoine de")
];

$json = json_encode($livre1);

file_put_contents('tuto-7.json', $json);

$json = file_get_contents('tuto-7.json');

$livreLu = json_decode($json);

echo $livreLu->auteurs;