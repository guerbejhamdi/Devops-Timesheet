package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.dto.DepartementDTO;
import tn.esprit.spring.dto.EntrepriseDTO;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(EntrepriseDTO ssiiConsultingDto);
	public int ajouterDepartement(DepartementDTO dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public void deleteEntrepriseById(int entrepriseId);
	public void deleteDepartementById(int depId);
	public Entreprise getEntrepriseById(int entrepriseId);
}
