package com.dgcye.consultaCheques.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Cambdoc implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idcambdoc")
	int idcambdoc;
	
	@Column(name = "docunew")
    String docunew;
	
	@Column(name = "secunew")
    int secunew;
	
	@Column(name = "docuold")
    String docuold;
	
	@Column(name = "secuold")
    int secuold;
	
	@Column(name = "esDeno")
    String esdeno;
	
	@Column(name = "idant")
    int idant;
	
	@Column(name = "idsig")
    int idsig;
	
	@Column(name = "vigh")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
    Date vigh;
	
	@Column(name = "vigd")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	Date vigd;
	
	
	public Cambdoc() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof Cambdoc))
		  return false;
		final Cambdoc elem = (Cambdoc)o;

		if (this.getIdcambdoc() != elem.getIdcambdoc())
		  return false;
		
		return true;
	}

	/**
	 * @return
	 */
	public String getDocunew() {
		return docunew;
	}

	/**
	 * @return
	 */
	public String getDocuold() {
		return docuold;
	}

	/**
	 * @return
	 */
	public String getEsdeno() {
		return esdeno;
	}

	/**
	 * @return
	 */
	public int getIdant() {
		return idant;
	}

	/**
	 * @return
	 */
	public int getIdcambdoc() {
		return idcambdoc;
	}

	/**
	 * @return
	 */
	public int getIdsig() {
		return idsig;
	}

	/**
	 * @return
	 */
	public int getSecunew() {
		return secunew;
	}

	/**
	 * @return
	 */
	public int getSecuold() {
		return secuold;
	}

	/**
	 * @return
	 */
	public Date getVigd() {
		return vigd;
	}

	/**
	 * @return
	 */
	public Date getVigh() {
		return vigh;
	}

	/**
	 * @param string
	 */
	public void setDocunew(String string) {
		docunew = string;
	}

	/**
	 * @param string
	 */
	public void setDocuold(String string) {
		docuold = string;
	}

	/**
	 * @param string
	 */
	public void setEsdeno(String string) {
		esdeno = string;
	}

	/**
	 * @param i
	 */
	public void setIdant(int i) {
		idant = i;
	}

	/**
	 * @param i
	 */
	public void setIdcambdoc(int i) {
		idcambdoc = i;
	}

	/**
	 * @param i
	 */
	public void setIdsig(int i) {
		idsig = i;
	}

	/**
	 * @param i
	 */
	public void setSecunew(int i) {
		secunew = i;
	}

	/**
	 * @param i
	 */
	public void setSecuold(int i) {
		secuold = i;
	}

	/**
	 * @param date
	 */
	public void setVigd(Date date) {
		vigd = date;
	}

	/**
	 * @param date
	 */
	public void setVigh(Date date) {
		vigh = date;
	}

}