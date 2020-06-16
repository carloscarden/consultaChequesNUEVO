package com.dgcye.consultaCheques.dtos;

public class VEDetalleDTO {
    int eliqid;
    String codigo;
    String bod;
    String origen;
    int per;
    double pesos;
	String descripcioncodigo;
	int periodo;
	
	public VEDetalleDTO() {
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
	public int getEliqid() {
		return eliqid;
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
	public int getPer() {
		return per;
	}

	/**
	 * @return
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * @return
	 */
	public double getPesos() {
		return pesos;
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
	 * @param i
	 */
	public void setEliqid(int i) {
		eliqid = i;
	}

	/**
	 * @param string
	 */
	public void setOrigen(String string) {
		origen = string;
	}

	/**
	 * @param string
	 */
	public void setPer(int i) {
		per = i;
	}

	/**
	 * @param string
	 */
	public void setPeriodo(int i) {
		periodo = i;
	}

	/**
	 * @param d
	 */
	public void setPesos(double d) {
		pesos = d;
	}

}