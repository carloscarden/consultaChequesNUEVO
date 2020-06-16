package com.dgcye.consultaCheques.dtos;

public class DetCodigoDTO {
	String codigo = null;
	String descripcion = null;
	String importe = null;

	public DetCodigoDTO() {
		super();
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
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return
	 */
	public String getImporte() {
		return importe;
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
	public void setDescripcion(String string) {
		descripcion = string;
	}

	/**
	 * @param string
	 */
	public void setImporte(String string) {
		importe = string;
	}

}
