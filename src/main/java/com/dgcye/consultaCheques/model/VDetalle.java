package com.dgcye.consultaCheques.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(VDetalle.class)
public class VDetalle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "liqid")
    int liqid;
	
	@Id
	@Column(name = "codigo")
    String codigo;
	
	@Id
	@Column(name = "bod")
    String bod;
	
	@Id
	@Column(name = "clave")
    String clave;
	
	@Column(name = "origen")
    String origen;
	
	@Column(name = "pesos")
    double pesos;
	
	@Column(name = "pesossubv")
	double pesossubv;
	
	@Column(name = "descripcioncodigo")
	String descripcioncodigo;
	
	@Column(name = "imputa")
	String imputa;
	
	public VDetalle() {
		super();
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof VDetalle))
		  return false;
		final VDetalle elem = (VDetalle)o;

		if (this.getLiqid() != elem.getLiqid())
		  return false;
		
		if (!this.getCodigo().equals(elem.getCodigo()))  
		  return false;
		
		if (!this.getBod().equals(elem.getBod()))  
		  return false;
		
		if (!this.getClave().equals(elem.getClave()))  
		  return false;
		  
		return true;
	}
	
	public int hashCode() {
		int result = 14;
		result = 29 * result + getCodigo().hashCode() + getLiqid() + getBod().hashCode() + getClave().hashCode();
		return result;
	}


	/**
	 * @return
	 */
	public String getBod() {
		return bod;
	}

	/**
	 * @return
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return
	 */
	public String getDescripcioncodigo() {
		return descripcioncodigo;
	}

	/**
	 * @return
	 */
	public String getImputa() {
		return imputa;
	}

	/**
	 * @return
	 */
	public int getLiqid() {
		return liqid;
	}

	/**
	 * @return
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @return
	 */
	public double getPesos() {
		return pesos;
	}

	/**
	 * @return
	 */
	public double getPesossubv() {
		return pesossubv;
	}

	/**
	 * @param string
	 */
	public void setBod(String string) {
		bod = string;
	}

	/**
	 * @param string
	 */
	public void setClave(String string) {
		clave = string;
	}

	/**
	 * @param string
	 */
	public void setCodigo(String string) {
		codigo = string;
	}

	/**
	 * @param string
	 */
	public void setDescripcioncodigo(String string) {
		descripcioncodigo = string;
	}

	/**
	 * @param string
	 */
	public void setImputa(String string) {
		imputa = string;
	}

	/**
	 * @param i
	 */
	public void setLiqid(int i) {
		liqid = i;
	}

	/**
	 * @param string
	 */
	public void setOrigen(String string) {
		origen = string;
	}

	/**
	 * @param d
	 */
	public void setPesos(double d) {
		pesos = d;
	}

	/**
	 * @param d
	 */
	public void setPesossubv(double d) {
		pesossubv = d;
	}

}