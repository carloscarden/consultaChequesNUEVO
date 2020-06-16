package com.dgcye.consultaCheques.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Rev implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rev")
    String rev;
	
	@Column(name = "descr")
    String descr;
	
	public Rev() {
		super();
	}


	public boolean equals(Object o) {
		Rev elem = (Rev)o; 
		if (this.getRev() == elem.getRev()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @return
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @return
	 */
	public String getRev() {
		return rev;
	}

	/**
	 * @param string
	 */
	public void setDescr(String string) {
		descr = string;
	}

	/**
	 * @param string
	 */
	public void setRev(String string) {
		rev = string;
	}

}