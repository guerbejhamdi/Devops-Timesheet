package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Integer>{
	
	
	    
	    @Query("Select "
				+ "DISTINCT AVG(cont.salaire) from Contrat cont "
				+ "join cont.employe emp "
				+ "join emp.departements deps "
				+ "where deps.id=:depId")
	    public Double getSalaireMoyenByDepartementId(@Param("depId")int departementId);

}
