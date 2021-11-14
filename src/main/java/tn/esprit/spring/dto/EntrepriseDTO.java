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
public class EntrepriseDTO {

private int id;
	
	private String name;
	
	
	private String raisonSocial;
	
	
	private List<DepartementDTO> departements = new ArrayList<>();


	public EntrepriseDTO(int id, String name, String raisonSocial) {
		super();
		this.id = id;
		this.name = name;
		this.raisonSocial = raisonSocial;
	}


	public EntrepriseDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	
}
