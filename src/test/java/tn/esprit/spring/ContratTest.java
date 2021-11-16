package tn.esprit.spring;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.logging.log4j.LogManager;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {

	
	@Autowired
	public IEmployeService IEmps;
	
	   @Autowired
		public ContratServiceImpl contratServiceImpl;
		@Autowired
		public IContratService IContrat;

    private static final Logger l= LogManager.getLogger(ContratTest.class);

    @Test
	public void testAddContrat(){
        
        Date current = new Date();
        l.info(" Create the Current Date");
        Employe emp = new Employe("harbaoui", "ichrak", "ichrak.harbaoui@esprit.tn", true, Role.INGENIEUR);
        Contrat contrat= new Contrat(current,"travail Administratif",1000);

        IEmps.addOrUpdateEmploye(emp);
        l.info("Employe ajoutéé");

		contratServiceImpl.ajouterContrat(contrat);
        IContrat.affecterContratAEmploye(contrat.getReference(),emp.getId());
        l.info("Contrat affecté à employé");
	}
}
