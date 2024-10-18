<?php
class CompteBancaire
{
    private $solde;

    public function __construct($soldeInitial)
    {
        $this->solde = $soldeInitial;
    }

    public function getSolde()
    {
        return $this->solde;
    }

    public function deposer($montant)
    {
        if ($montant > 0) {
            $this->solde += $montant;
        } else {
            echo "Le montant doit être positif.";
        }
    }

    public function retirer($montant)
    {
        if ($montant <= $this->solde) {
            $this->solde -= $montant;
        } else {
            echo "Solde insuffisant.";
        }
    }
}