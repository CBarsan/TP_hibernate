package metier;

import java.util.Calendar;

public class CompteCourant extends Compte {
	
	private int decouvert;
	
	

	public CompteCourant(int numCompte, Calendar dateCompte, double solde,
			int decouvert) {
		super(numCompte, dateCompte, solde);
		this.decouvert = decouvert;
	}



	public int getDecouvert() {
		return decouvert;
	}



	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}



	public CompteCourant(int numCompte, Calendar dateCompte, double solde) {
		super(numCompte, dateCompte, solde);
		// TODO Auto-generated constructor stub
	}

}
