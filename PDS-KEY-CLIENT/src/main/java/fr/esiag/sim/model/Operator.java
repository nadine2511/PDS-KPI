package fr.esiag.sim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="OPERATOR")
public class Operator {
	
	@Id
	@Column(name="idOperator")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOperator;
	
	private String firstNameOP;
	
	private String lastNameOP;
	
	private int idSector;
	
	private String loginOperator;
	
	private String passwordOp;
	
	public int getIdOperator() {
		return idOperator;
	}

	public void setIdOperator(int idOperator) {
		this.idOperator = idOperator;
	}

	public String getFirstNameOP() {
		return firstNameOP;
	}

	public void setFirstNameOP(String firstNameOP) {
		this.firstNameOP = firstNameOP;
	}

	public String getLastNameOP() {
		return lastNameOP;
	}

	public void setLastNameOP(String lastNameOP) {
		this.lastNameOP = lastNameOP;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getLoginOperator() {
		return loginOperator;
	}

	public void setLoginOperator(String loginOperator) {
		this.loginOperator = loginOperator;
	}

	public String getPasswordOp() {
		return passwordOp;
	}

	public void setPasswordOp(String passwordOp) {
		this.passwordOp = passwordOp;
	}

}
