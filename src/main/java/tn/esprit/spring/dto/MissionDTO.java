package tn.esprit.spring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionDTO {

private int id;
	
	private String name;
	
	private String description;
	
	private DepartementDTO departement;
	
	private  List<TimesheetDTO> timesheets;

	public MissionDTO(int id, String name, String description, DepartementDTO departement) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.departement = departement;
	}
	
	
	
	
	
}
