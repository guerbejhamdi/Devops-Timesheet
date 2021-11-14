package tn.esprit.spring.mapper;


import tn.esprit.spring.dto.ContratDTO;
import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;



public class EmployeMapper {

private EmployeMapper() {
		
	}
	
	public static Employe toEntity(EmployeDTO employeDto) {
		
		Contrat contrat = ContratMapper.toEntity(employeDto.getContrat());
		Employe employe = new Employe();
		employe.setId(employeDto.getId());
		employe.setEmail(employeDto.getEmail());
		employe.setPassword(employeDto.getPassword());
		employe.setNom(employeDto.getNom());
		employe.setPrenom(employeDto.getPrenom());
		employe.setActif(employeDto.isActif());		
		employe.setContrat(contrat);
		employe.setRole(employeDto.getRole());
				return employe;
	
	}
	
	
	public static EmployeDTO toDto(Employe employe) {
		ContratDTO contrat = ContratMapper.toDto(employe.getContrat());
		EmployeDTO employeDto = new EmployeDTO();
		employeDto.setId(employe.getId());
		employeDto.setEmail(employe.getEmail());
		employeDto.setPassword(employe.getPassword());
		employeDto.setNom(employe.getNom());
		employeDto.setPrenom(employe.getPrenom());
		employeDto.setActif(employe.isActif());		
		employeDto.setContrat(contrat);
		employeDto.setRole(employe.getRole());
				return employeDto;
	
	}
	
	
	
	
	
	
}
