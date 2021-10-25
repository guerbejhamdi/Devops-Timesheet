package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger logger = Logger.getLogger(DepartementServiceImpl.class);


	@Autowired
	DepartementRepository deptRepoistory;


	public List<Departement> getAllDepartements() {
		
		logger.info("In getAllDepartements() : ");
		return (List<Departement>) deptRepoistory.findAll();
	}
	
	public Double getSalaireMoyenByDepartementId(int departementId) {
		return deptRepoistory.getSalaireMoyenByDepartementId(departementId);
	}


}
