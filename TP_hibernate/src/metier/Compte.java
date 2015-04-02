package metier;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compte {
	
	private int numCompte;
	private Calendar dateCompte;
	private double solde;
	private Set <Operation> operations = new HashSet<Operation>();
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public Calendar getDateCompte() {
		return dateCompte;
	}
	public void setDateCompte(Calendar dateCompte) {
		this.dateCompte = dateCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Compte(int numCompte, Calendar dateCompte, double solde) {
		super();
		this.numCompte = numCompte;
		this.dateCompte = dateCompte;
		this.solde = solde;
	}
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte") 
	public Set <Operation> getOperations() {
		return operations;
	}
	public void setOperations(Set <Operation> operations) {
		this.operations = operations;
	}
	
	
	
	
	

}
