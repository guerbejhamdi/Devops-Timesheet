package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.EmployeTest;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	
	private static final Logger l= LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public Employe authenticate(String login, String password) {
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}


	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Optional<Employe> empOptional = employeRepository.findById(employeId);
		if(empOptional.isPresent()){
			Employe employe =	empOptional.get();
			employe.setEmail(email);
			employeRepository.save(employe);	
		}
	
	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		Optional<Employe> empOptional = employeRepository.findById(employeId);
		Optional<Departement> depOptional = deptRepoistory.findById(depId);
		if(empOptional.isPresent()&&  depOptional.isPresent()){
			Departement depManagedEntity = depOptional.get();
			Employe employeManagedEntity = empOptional.get();
			if(depManagedEntity.getEmployes() == null){

				List<Employe> employes = new ArrayList<>();
				employes.add(employeManagedEntity);
				depManagedEntity.setEmployes(employes);
			}else{

				depManagedEntity.getEmployes().add(employeManagedEntity);
			}

		
			deptRepoistory.save(depManagedEntity); 
		}
	

		

	}
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Optional<Departement> depOptional =deptRepoistory.findById(depId);
		if(depOptional.isPresent()){
			Departement dep = depOptional.get();
			int employeNb = dep.getEmployes().size();
			for(int index = 0; index < employeNb; index++){
				if(dep.getEmployes().get(index).getId() == employeId){
					dep.getEmployes().remove(index);
					break;//a revoir
				}
			}
		}
	

		
	} 
	
	// Tablesapce (espace disque) 



	

	public String getEmployePrenomById(int employeId) {
		l.info("inside  methode getEmployePrenomById ");
		Optional<Employe> empOptional = employeRepository.findById(employeId);
		if(empOptional.isPresent()){
			Employe employeManagedEntity =empOptional.get();
			l.info("returning employe prenom ");
			return employeManagedEntity.getPrenom();
			
		}else {
			l.error("Error on (prenomEmploye) or (EmployeId) ");
			
			return null;
			
		}
		
	
	}
	 
	public void deleteEmployeById(int employeId)
	{Optional<Employe> empOptional = employeRepository.findById(employeId);
	if(empOptional.isPresent()){
		Employe employe = empOptional.get();
		//Desaffecter l'employe de tous les departements
				//c'est le bout master qui permet de mettre a jour
				//la table d'association
		
		for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
		}

		employeRepository.delete(employe);
	}
	
	
	}



	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}
	

	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	
	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		return (List<Employe>) employeRepository.findAll();
	}

}
