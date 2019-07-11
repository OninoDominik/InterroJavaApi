package fr.CCI.Java.boulangermicroservice.model;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq2", initialValue=100, allocationSize=1000)
public class Espece {
    public Espece() {
    }

    public Espece(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
    private String nom;
    private String Description;
}
