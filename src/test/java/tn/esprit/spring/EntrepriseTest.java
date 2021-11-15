package tn.esprit.spring;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.logging.log4j.LogManager;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	
	@Autowired
	public IDepartementService IDep;
	
	   @Autowired
		public EntrepriseServiceImpl entrepriseServiceImpl;
		@Autowired
		public IEntrepriseService IEmps;

    private static final Logger l= LogManager.getLogger(EntrepriseTest.class);
    
    @Test
   	public void testAddEntreprise() {
    	Departement dep= new Departement("Informatique");
    	IDep.ajouterDepartement(dep);
    	Entreprise enp = new Entreprise("med ink","idk");
    	IEmps.ajouterEntreprise(enp);
		l.info("add successful ");
    	
    }

}
