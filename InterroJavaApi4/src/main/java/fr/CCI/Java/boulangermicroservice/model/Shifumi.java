package fr.CCI.Java.boulangermicroservice.model;

import fr.CCI.Java.boulangermicroservice.enumeration.Resultat;
import fr.CCI.Java.boulangermicroservice.enumeration.Shif;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shifumi {

    public Shifumi() {
    }

    @Id
    private int id;
    private Shif monjet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shif getMonjet() {
        return monjet;
    }

    public void setMonjet(Shif monjet) {
        this.monjet = monjet;
    }

    public Resultat isWinning(Shif sonShif) {
        if (sonShif == Shif.pierre && (this.monjet == Shif.papier || this.monjet == Shif.bombe || this.monjet == Shif.pierre)) {
            if (this.monjet == Shif.pierre) {
                return Resultat.egalite;
            }
            return Resultat.victoire;
        } else if (sonShif == Shif.ciseaux && (this.monjet == Shif.pierre || this.monjet == Shif.ciseaux)) {
            if (this.monjet == Shif.ciseaux) {
                return Resultat.egalite;
            }
            return Resultat.victoire;
        } else if (sonShif == Shif.papier && (this.monjet == Shif.ciseaux || this.monjet == Shif.bombe || this.monjet == Shif.papier)) {
            if (this.monjet == Shif.papier) {
                return Resultat.egalite;
            }
            return Resultat.victoire;
        } else if (sonShif == Shif.bombe && (this.monjet == Shif.ciseaux || this.monjet == Shif.bombe)) {
            if (this.monjet == Shif.bombe) {
                return Resultat.egalite;
            }
            return Resultat.victoire;
        }
        return Resultat.defaite;
    }
}


