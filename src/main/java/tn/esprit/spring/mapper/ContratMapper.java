package tn.esprit.spring.mapper;


import tn.esprit.spring.dto.ContratDTO;
import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;


public class ContratMapper {

	private ContratMapper() {
		
	}
	
	public static Contrat toEntity(ContratDTO contratDto) {
		
		if(contratDto == null) {
			return null;
		}
		Contrat contrat = new Contrat();
		Employe e = EmployeMapper.toEntity(contratDto.getEmploye());
		contrat.setDateDebut(contratDto.getDateDebut());
		contrat.setReference(contratDto.getReference());
		contrat.setSalaire(contratDto.getSalaire());
		contrat.setEmploye(e);
		contrat.setTypeContrat(contratDto.getTypeContrat());
		
				return contrat;
	
	}
	
	
	public static ContratDTO toDto(Contrat contrat) {
		EmployeDTO e = EmployeMapper.toDto(contrat.getEmploye());
	
		return ContratDTO.builder()
				.reference(contrat.getReference())
				.dateDebut(contrat.getDateDebut())
				.salaire(contrat.getSalaire())
				.employe(e)
				.build();
	
	}
	
	
}

