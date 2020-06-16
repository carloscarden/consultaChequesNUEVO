package com.dgcye.consultaCheques.model;

import java.io.Serializable;

public class CatId implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cat;
	private String esDeno;
	
	
	
	public CatId() {
		super();
		// TODO Auto-generated constructor stub
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

	
	

}
