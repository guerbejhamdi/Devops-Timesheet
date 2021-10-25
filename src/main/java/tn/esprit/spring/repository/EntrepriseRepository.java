package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
    @Query("Select "
			+ "DISTINCT emp from Employe emp "
			+ "join emp.departements dps "
			+ "join dps.entreprise entrep "
			+ "where entrep=:entreprise")
    public List<Employe> getAllEmployeByEntreprisec(@Param("entreprise") Entreprise entreprise);
	
}
