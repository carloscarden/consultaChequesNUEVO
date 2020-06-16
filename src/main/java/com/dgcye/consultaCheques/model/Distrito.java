package com.dgcye.consultaCheques.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Distrito implements Serializable {
	@Id
	@Column(name = "distrito")
    int distrito;
	
	@Column(name = "descripcion")
    String descripcion;
	
	@Column(name = "region")
    int region;
	
	@Column(name = "area")
    int area;
	
	public Distrito() {
		super();
	}


	public boolean equals(Object o) {
		Distrito elem = (Distrito)o; 
		if (this.getDistrito() == elem.getDistrito()){
			return true;
		}else{
			return false;
		}
	}
	


	/**
	 * @return
	 */
	public int getArea() {
		return area;
	}

	/**
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return
	 */
	public int getDistrito() {
		return distrito;
	}

	/**
	 * @return
	 */
	public int getRegion() {
		return region;
	}

	/**
	 * @param i
	 */
	public void setArea(int i) {
		area = i;
	}

	/**
	 * @param string
	 */
	public void setDescripcion(String string) {
		descripcion = string;
	}

	/**
	 * @param i
	 */
	public void setDistrito(int i) {
		distrito = i;
	}

	/**
	 * @param i
	 */
	public void setRegion(int i) {
		region = i;
	}

}