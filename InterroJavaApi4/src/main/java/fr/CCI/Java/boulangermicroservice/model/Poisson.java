package fr.CCI.Java.boulangermicroservice.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=10, allocationSize=100)
public class Poisson {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
    @Column(unique=true)
    private String nom;
    @ManyToOne
    private Espece espece;
    private String img;

    public Poisson() {
    }

    public Poisson(int id, String nom, Espece espece, String img) {
        this.id = id;
        this.nom = nom;
        this.espece = espece;
        this.img = img;
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

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
