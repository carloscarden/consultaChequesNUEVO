package com.dgcye.consultaCheques.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CatId.class)
public class Cat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cat")
    private String cat;
	
	
	@Id
	@Column(name = "esDeno")
	private String esDeno;
	
	@Column(name = "descr")
	private String descr;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "ensenanza")
	private String ensenanza;
	
	@Column(name = "reg")
	private String reg;
	
	public Cat() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof Cat))
		  return false;
		final Cat elem = (Cat)o;

		if (!this.getCat().equals(elem.getCat()))
		  return false;
		

		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getCat().hashCode();
		return result;
	}


	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}




	public String getEsDeno() {
		return esDeno;
	}


	public void setEsDeno(String esDeno) {
		this.esDeno = esDeno;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getEnsenanza() {
		return ensenanza;
	}


	public void setEnsenanza(String ensenanza) {
		this.ensenanza = ensenanza;
	}


	public String getReg() {
		return reg;
	}


	public void setReg(String reg) {
		this.reg = reg;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}