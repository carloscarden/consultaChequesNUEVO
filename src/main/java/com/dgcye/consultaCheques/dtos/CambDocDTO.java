package com.dgcye.consultaCheques.dtos;

import java.util.Date;

public class CambDocDTO {
	int idcambdoc;
	String docunew;
	int secunew;
	String docuold;
	int secuold;
	String esdeno;
	int idant;
	int idsig;
	Date vigh;
	Date vigd;
	
	

	public CambDocDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdcambdoc() {
		return idcambdoc;
	}

	public void setIdcambdoc(int idcambdoc) {
		this.idcambdoc = idcambdoc;
	}

	public String getDocunew() {
		return docunew;
	}

	public void setDocunew(String docunew) {
		this.docunew = docunew;
	}

	public int getSecunew() {
		return secunew;
	}

	public void setSecunew(int secunew) {
		this.secunew = secunew;
	}

	public String getDocuold() {
		return docuold;
	}

	public void setDocuold(String docuold) {
		this.docuold = docuold;
	}

	public int getSecuold() {
		return secuold;
	}

	public void setSecuold(int secuold) {
		this.secuold = secuold;
	}

	public String getEsdeno() {
		return esdeno;
	}

	public void setEsdeno(String esdeno) {
		this.esdeno = esdeno;
	}

	public int getIdant() {
		return idant;
	}

	public void setIdant(int idant) {
		this.idant = idant;
	}

	public int getIdsig() {
		return idsig;
	}

	public void setIdsig(int idsig) {
		this.idsig = idsig;
	}

	public Date getVigh() {
		return vigh;
	}

	public void setVigh(Date vigh) {
		this.vigh = vigh;
	}

	public Date getVigd() {
		return vigd;
	}

	public void setVigd(Date vigd) {
		this.vigd = vigd;
	}

}
