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
}
