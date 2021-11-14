package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;

	private String email;

	private String password;
	
	private boolean actif;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )
	private List<Departement> departements;
	
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private List<Timesheet> timesheets;
	
	
	public Employe() {
		super();
	}
	
		
	public Employe(int id, String prenom, String nom, String email, String password, boolean actif, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}
	

	public Employe(String prenom, String nom, String email, String password, boolean actif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.actif = actif;
		this.role = role;
	}
	
	
	
}
