package metier.entities;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@XmlRootElement
@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	
	private double solde;
	
	private Date dateCreation;

	public Compte() {
		super();
	}   
	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}   
	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
   
}
