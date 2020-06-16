package com.dgcye.consultaCheques.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Ecargo implements Serializable {
	@Id
	@Column(name = "cidr")
	int cidr;
	
	@Column(name = "item")
	int item;
	
	@Column(name = "apart")
	int apart;
	
	@Column(name = "docu")
	String docu;
	
	@Column(name = "secu")
	int secu;
	
	@Column(name = "foja")
	int foja;
	
	@Column(name = "apynom")
	String apynom;
	
	@Column(name = "escue")
	int escue;
	
	
	@ManyToOne
	@JoinColumn(name="dist")
	Distrito dist;
	
	@Column(name = "cat")
	String cat;
	
	@Column(name = "cargo")
	int cargo;
   	
	public Ecargo() {
		super();
	}


	public boolean equals(Object o) {
		Ecargo elem = (Ecargo)o; 
		if (this.getCidr() == elem.getCidr()){
			return true;
		}else{
			return false;
		}
	}
	

	/**
	 * @return
	 */
	public int getApart() {
		return apart;
	}

	/**
	 * @return
	 */
	public String getApynom() {
		return apynom;
	}

	/**
	 * @return
	 */
	public int getCargo() {
		return cargo;
	}

	/**
	 * @return
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * @return
	 */
	public int getCidr() {
		return cidr;
	}

	/**
	 * @return
	 */
	public Distrito getDist() {
		return dist;
	}

	/**
	 * @return
	 */
	public String getDocu() {
		return docu;
	}

	/**
	 * @return
	 */
	public int getEscue() {
		return escue;
	}

	/**
	 * @return
	 */
	public int getFoja() {
		return foja;
	}

	/**
	 * @return
	 */
	public int getItem() {
		return item;
	}

	/**
	 * @return
	 */
	public int getSecu() {
		return secu;
	}

	/**
	 * @param i
	 */
	public void setApart(int i) {
		apart = i;
	}

	/**
	 * @param string
	 */
	public void setApynom(String string) {
		apynom = string;
	}

	/**
	 * @param i
	 */
	public void setCargo(int i) {
		cargo = i;
	}

	/**
	 * @param cat
	 */
	public void setCat(String string) {
		cat = string;
	}

	/**
	 * @param i
	 */
	public void setCidr(int i) {
		cidr = i;
	}

	/**
	 * @param distrito
	 */
	public void setDist(Distrito dist) {
		this.dist = dist;
	}

	/**
	 * @param string
	 */
	public void setDocu(String string) {
		docu = string;
	}

	/**
	 * @param i
	 */
	public void setEscue(int i) {
		escue = i;
	}

	/**
	 * @param i
	 */
	public void setFoja(int i) {
		foja = i;
	}

	/**
	 * @param i
	 */
	public void setItem(int i) {
		item = i;
	}

	/**
	 * @param i
	 */
	public void setSecu(int i) {
		secu = i;
	}

}