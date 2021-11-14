package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.dto.DepartementDTO;
import tn.esprit.spring.dto.EntrepriseDTO;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.mapper.DepartementMapper;
import tn.esprit.spring.mapper.EntrepriseMapper;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(EntrepriseDTO entreprise) {
		entrepriseRepoistory.save(EntrepriseMapper.toEntity(entreprise));
		return entreprise.getId();
	}

	public int ajouterDepartement(DepartementDTO dep) {
		deptRepoistory.save(DepartementMapper.toEntity(dep));
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
				Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
				Optional <Departement> depManagedEntity = deptRepoistory.findById(depId);
				if(entrepriseManagedEntity.isPresent() && depManagedEntity.isPresent()) {
				depManagedEntity.get().setEntreprise(entrepriseManagedEntity.get());
				deptRepoistory.save(depManagedEntity.get());
				}
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> emptyList = null;
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		List<String> depNames = new ArrayList<>();
		if(entrepriseManagedEntity.isPresent()) {
		for(Departement dep : entrepriseManagedEntity.get().getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
		}
		return emptyList;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		if(entrepriseManagedEntity.isPresent()) {
			entrepriseRepoistory.delete(entrepriseManagedEntity.get());	
		}
		
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		Optional <Departement> depManagedEntity = deptRepoistory.findById(depId);
		if(depManagedEntity.isPresent()) {
			deptRepoistory.delete(depManagedEntity.get());	
		}
		
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		if(entrepriseManagedEntity.isPresent()) {
			return entrepriseManagedEntity.get();	
		}
		return null;
	}

}
