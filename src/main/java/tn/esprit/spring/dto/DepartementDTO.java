package tn.esprit.spring.dto;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartementDTO {

    private int id;
	private String name;
	private List<EmployeDTO> employes = new ArrayList<>();
	private EntrepriseDTO entreprise;
	private List<MissionDTO> missions = new ArrayList<>();
	
	public DepartementDTO(String name) {
		super();
		this.name = name;
	}

	public DepartementDTO(int id) {
		super();
		this.id = id;
	}

	public DepartementDTO(int id, String name, EntrepriseDTO entreprise) {
		super();
		this.id = id;
		this.name = name;
		this.entreprise = entreprise;
	}

	public DepartementDTO(int id, String name, EntrepriseDTO entreprise, List<MissionDTO> missions) {
		super();
		this.id = id;
		this.name = name;
		this.entreprise = entreprise;
		this.missions = missions;
	}
	
	
	
	
	
	
	
	
}
