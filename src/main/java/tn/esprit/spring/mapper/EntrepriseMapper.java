package tn.esprit.spring.mapper;


import tn.esprit.spring.dto.EntrepriseDTO;
import tn.esprit.spring.entities.Entreprise;


public class EntrepriseMapper {

private EntrepriseMapper() {
		
	}
	
	public static Entreprise toEntity(EntrepriseDTO entrepriseDto) {
		
		
		Entreprise entreprise = new Entreprise();
		
		entreprise.setId(entrepriseDto.getId());
		entreprise.setName(entrepriseDto.getName());
		entreprise.setRaisonSocial(entrepriseDto.getRaisonSocial());
				return entreprise;
	
	}
	
	
	public static EntrepriseDTO toDto(Entreprise entreprise) {
		
		
		 EntrepriseDTO entrepriseDTO = new EntrepriseDTO();
			
		 entrepriseDTO.setId(entreprise.getId());
		 entrepriseDTO.setName(entreprise.getName());
		 entrepriseDTO.setRaisonSocial(entreprise.getRaisonSocial());
		 
					return entrepriseDTO;
	
	}
	
	
	
	
	
	
	
}
