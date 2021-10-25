package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public void deleteAllContratJPQL();
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public void deleteContratById(int contratId);

	
	
	

	
}
