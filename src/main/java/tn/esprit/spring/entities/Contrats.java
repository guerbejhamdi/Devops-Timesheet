package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Contrats {

	
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	private String typeContrat;
	
	private float salaire;

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	
}