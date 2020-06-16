package com.dgcye.consultaCheques.model;

import java.io.Serializable;

public class VInfocheqId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pin;
	
	private Integer secu;
	
	private String esDeno;
	
	private Integer opid;
	
	private Integer fecAfec;
	
	private Integer liqid;
	
	private Integer nroCheq;
	
	
	

	public VInfocheqId() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getPin() {
		return pin;
	}




	public void setPin(Integer pin) {
		this.pin = pin;
	}




	public Integer getSecu() {
		return secu;
	}




	public void setSecu(Integer secu) {
		this.secu = secu;
	}




	public String getEsDeno() {
		return esDeno;
	}




	public void setEsDeno(String esDeno) {
		this.esDeno = esDeno;
	}




	public Integer getOpid() {
		return opid;
	}




	public void setOpid(Integer opid) {
		this.opid = opid;
	}




	public Integer getFecAfec() {
		return fecAfec;
	}




	public void setFecAfec(Integer fecAfec) {
		this.fecAfec = fecAfec;
	}




	public Integer getLiqid() {
		return liqid;
	}




	public void setLiqid(Integer liqid) {
		this.liqid = liqid;
	}




	public Integer getNroCheq() {
		return nroCheq;
	}




	public void setNroCheq(Integer nroCheq) {
		this.nroCheq = nroCheq;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	

}
