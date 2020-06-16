package com.dgcye.consultaCheques.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Dep implements Serializable {
	@Id
	@Column(name = "dep")
    private Integer dep;
	
	@Column(name = "descr")
    private String descr;
 	
	public Dep() {
		super();
	}


	public boolean equals(Object o) {
		Dep elem = (Dep)o; 
		if (this.getDep() != elem.getDep()){
			return true;
		}else{
			return false;
		}
	}


	public Integer getDep() {
		return dep;
	}


	public void setDep(Integer dep) {
		this.dep = dep;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	

}