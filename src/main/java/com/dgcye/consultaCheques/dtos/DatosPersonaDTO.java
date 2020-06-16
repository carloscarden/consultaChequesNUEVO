package com.dgcye.consultaCheques.dtos;


import com.dgcye.consultaCheques.model.Pers;

public class DatosPersonaDTO {
	private String documento = null;
	private String apellido = null;
	private String descDistrito;
	private int numDistrito;
	private String tipo_org;
	private int dependencia;
	private int escuela; 
	private String reg;
	
	
	
	public DatosPersonaDTO(Pers p) {
		super();
		// TODO Auto-generated constructor stub
		this.documento = p.getDocu();
		this.apellido = p.getNombre();
	}
	
	
	
	public DatosPersonaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDescDistrito() {
		return descDistrito;
	}
	public void setDescDistrito(String descDistrito) {
		this.descDistrito = descDistrito;
	}
	public int getNumDistrito() {
		return numDistrito;
	}
	public void setNumDistrito(int numDistrito) {
		this.numDistrito = numDistrito;
	}
	public String getTipo_org() {
		return tipo_org;
	}
	public void setTipo_org(String tipo_org) {
		this.tipo_org = tipo_org;
	}
	public int getDependencia() {
		return dependencia;
	}
	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}
	public int getEscuela() {
		return escuela;
	}
	public void setEscuela(int escuela) {
		this.escuela = escuela;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	
	
	

}
