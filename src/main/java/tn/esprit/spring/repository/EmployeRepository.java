package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Integer>  {
	
	@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
	public Employe getEmployeByEmailAndPassword(@Param("email")String login, @Param("password")String password);
	
	@Query("SELECT count(*) FROM Employe")
    public int countemp();
	
    @Query("SELECT nom FROM Employe")
    public List<String> employeNames();
    
    @Modifying
    @Transactional
    @Query("UPDATE Employe e SET e.email=:email1 where e.id=:employeId")
    public void mettreAjourEmailByEmployeIdJPQL(@Param("email1")String email, @Param("employeId")int employeId);
    
    @Query("select c.salaire from Contrat c join c.employe e where e.id=:employeId")
    public float getSalaireByEmployeIdJPQL(@Param("employeId")int employeId);
    
    

	
    		
   

}
