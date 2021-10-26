package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartementService {
	
	
	public List<Departement> getAllDepartements();
	public Double getSalaireMoyenByDepartementId(int departementId);
	public void deleteDepartementById(int depId);
	public int ajouterDepartement(Departement dep);

	
	
	

	
}
