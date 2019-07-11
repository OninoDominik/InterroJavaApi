package fr.CCI.Java.boulangermicroservice.dao;

import fr.CCI.Java.boulangermicroservice.model.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspeceDao extends JpaRepository<Espece, Integer>{

    Espece findById(int id);
}
