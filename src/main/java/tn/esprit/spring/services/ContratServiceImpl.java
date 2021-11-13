package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ContratServiceImpl implements IContratService {

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;


	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}
	public int ajouterContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return contrat.getReference();
	}
	
	public void affecterContratAEmploye(int contratId, int employeId) {

		try {
			Contrat contratManagedEntity = contratRepository.findById(contratId).orElse(null);
			Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
			if (contratManagedEntity != null && employeManagedEntity != null) {
				contratManagedEntity.setEmploye(employeManagedEntity);
				contratRepository.save(contratManagedEntity);
			}
		} catch (NullPointerException npe) {
			l.error(npe);
		}

	}
	//
	public void deleteAllContratJPQL() {
		contratRepository.deleteAllContratJPQL();
	}
	
	public void deleteContratById(int contratId) {

		Contrat contratManagedEntity = contratRepository.findById(contratId).orElse(null);
		if (contratManagedEntity != null) {
			contratRepository.delete(contratManagedEntity);
		} else {
			l.error("Contrat may be NULL");
		}

	}

}
