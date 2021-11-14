package tn.esprit.spring.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.spring.entities.Role;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeDTO  {
	
	
	private int id;
	
	private String prenom;
	
	private String nom;
	
	private String email;

	private String password;
	
	private boolean actif;
	
	private Role role;
	
	private List<DepartementDTO> departements;
	
	private ContratDTO contrat;
	
	private List<TimesheetDTO> timesheets;

	public EmployeDTO(String prenom, String nom, String email, String password, boolean actif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}



	
	
	
	
	
	
	
	
}
