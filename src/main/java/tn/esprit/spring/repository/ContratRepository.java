package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{

	// JPQL 

    @Modifying
    @Transactional
    @Query("DELETE from Contrat")
    public void deleteAllContratJPQL();
} 
