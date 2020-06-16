package com.dgcye.consultaCheques.dtos;
import java.io.Serializable;

public class VDetalleDTO {
    int liqid;
    String codigo;
    String bod;
    String clave;
    String origen;
    double pesos;
	double pesossubv;
	String descripcioncodigo;
	String imputa;
	
	public VDetalleDTO() {
		super();
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