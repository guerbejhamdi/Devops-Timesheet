package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;
    private static final Logger LOGGER = LogManager.getLogger(DepartementServiceImpl.class);


	public List<Departement> getAllDepartements() {
		LOGGER.info("Currently in getAllDepartements(");
		
		return (List<Departement>) deptRepoistory.findAll();
	}
	
	public Double getSalaireMoyenByDepartementId(int departementId) {
		return deptRepoistory.getSalaireMoyenByDepartementId(departementId);
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}
	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	 



}
