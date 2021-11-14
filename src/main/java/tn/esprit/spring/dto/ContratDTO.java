package tn.esprit.spring.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContratDTO {

	
	
	private int reference;
	
	
	private Date dateDebut;
	
	private String typeContrat;
	
	
	private float telephone;
	
	
	private EmployeDTO employe;

	private float salaire;

	public ContratDTO(int reference, Date dateDebut, String typeContrat, float telephone,
			float salaire) {
		super();
		this.reference = reference;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.telephone = telephone;
		this.salaire = salaire;
	}

	public ContratDTO(int reference, Date dateDebut, String typeContrat, float telephone) {
		super();
		this.reference = reference;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.telephone = telephone;
	}

	public ContratDTO(int reference, Date dateDebut, String typeContrat) {
		super();
		this.reference = reference;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
	}

	
	
	
	
}
