package tn.esprit.spring.mapper;

import tn.esprit.spring.dto.DepartementDTO;
import tn.esprit.spring.dto.EntrepriseDTO;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;



public class DepartementMapper {

private DepartementMapper() {
		
	}

public static Departement toEntity(DepartementDTO departementDto) {
		
		 Entreprise entreprise = EntrepriseMapper.toEntity(departementDto.getEntreprise());
		
		Departement departement = new Departement();
		
		departement.setId(departementDto.getId());
		departement.setName(departementDto.getName());
		departement.setEntreprise(entreprise);
		
				return departement;
	
	}
	
	
	public static DepartementDTO toDto(Departement departement) {
		 EntrepriseDTO entreprise = EntrepriseMapper.toDto(departement.getEntreprise());
		
		
		 DepartementDTO departementDTO = new DepartementDTO();
			
			departementDTO.setId(departement.getId());
			departementDTO.setName(departement.getName());
			departementDTO.setEntreprise(entreprise);

		       return departementDTO;
		
	
	}
	
	
	
	
	
	
	
	
	
}
