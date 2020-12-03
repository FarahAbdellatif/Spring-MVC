package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String fct;

	@ManyToOne
	@JoinColumn(name="id_dep")
	private Departement dep;
	@ManyToOne
	@JoinColumn(name="id_proj")
	private Projet proj;
	
	public String getFct() {
		return fct;
	}

	public void setFct(String fct) {
		this.fct = fct;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Departement getDep() {
		return dep;
	}

	public void setDep(Departement dep) {
		this.dep = dep;
	}

	public Projet getProj() {
		return proj;
	}

	public void setProj(Projet proj) {
		this.proj = proj;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(Integer id, String nom, String fct, Departement dep, Projet proj) {
		super();
		this.id = id;
		this.nom = nom;
		this.fct = fct;
		this.dep = dep;
		this.proj = proj;
	}



	
	

}