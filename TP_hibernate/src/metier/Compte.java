package metier;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte {
	
	private int numCompte;
	private Date dateCompte;
	private double solde;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public Date getDateCompte() {
		return dateCompte;
	}
	public void setDateCompte(Date dateCompte) {
		this.dateCompte = dateCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Compte(int numCompte, Date dateCompte, double solde) {
		super();
		this.numCompte = numCompte;
		this.dateCompte = dateCompte;
		this.solde = solde;
	}
	
	
	
	
	

}
