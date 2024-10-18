<?php
class Person
{
    private $id;
    private $name;
    private $passport;

    public function setPassport(Passport $passport): void
    {
        $this->passport = $passport;
        $passport->setPerson($this);
    }
}

class Passport
{
    private $number;
    private $expirationDate;
    private $person;

    public function setPerson(Person $person): void
    {
        $this->person = $person;
    }
}

//-----------------------------------------------------//

class Auteur
{
    private $id;
    private $nom;
    /** @var Livre[] */
    private $livres = [];

    public function addLivre(Livre $livre): void
    {
        $this->livres[] = $livre;
        $livre->setAuteur($this);
    }
}

class Livre
{
    private $id;
    private $titre;
    private $auteur;
}

//-----------------------------------------------------//

class Etudiant
{
    private $id;
    private $nom;
    /** @var Cours[] */
    private $cours = [];

    public function ajouterCours(Cours $cours): void
    {
        $this->cours[] = $cours;
        $cours->ajouterEtudiant($this);
    }
}

class Cours
{
    private $id;
    private $nom;
    /** @var Etudiant[] */
    private $etudiants = [];

    public function ajouterEtudiant(Etudiant $etudiant): void
    {
        $this->etudiants[] = $etudiant;
    }
}