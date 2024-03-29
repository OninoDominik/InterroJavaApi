package fr.CCI.Java.boulangermicroservice.dao;
import java.util.List;

import fr.CCI.Java.boulangermicroservice.model.Espece;
import fr.CCI.Java.boulangermicroservice.model.Poisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoissonDao extends JpaRepository<Poisson, Integer>{

    List<Poisson> findByEspece(Espece espece);
    Poisson findById(int id);
}
