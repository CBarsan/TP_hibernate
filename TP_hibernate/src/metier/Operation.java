package metier;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation {
	
	private int numOperation;
	private Calendar dateOperation;
	private Compte compte;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(int numOperation) {
		this.numOperation = numOperation;
	}
	public Calendar getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Calendar dateOperation) {
		this.dateOperation = dateOperation;
	}
	public Operation(int numOperation, Calendar dateOperation) {
		super();
		this.numOperation = numOperation;
		this.dateOperation = dateOperation;
	}
	
	public Operation () {
				
	}
	
	@ManyToOne
	@JoinColumn(name="compte_id")
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

}
