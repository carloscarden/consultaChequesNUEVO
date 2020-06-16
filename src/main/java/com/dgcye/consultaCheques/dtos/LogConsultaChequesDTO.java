package com.dgcye.consultaCheques.dtos;

import java.util.Date;

import com.dgcye.consultaCheques.model.Logconsultacheques;

public class LogConsultaChequesDTO {
	private Integer id;
	private String docuConsulta;
	private Integer secuConsulta;
	private Integer ejercicioConsulta;
	private String usuario;
	private Date fechaConsulta;
	
	public LogConsultaChequesDTO(Logconsultacheques l) {
		super();
		// TODO Auto-generated constructor stub
		this.id = l.getId();
		this.docuConsulta = l.getDocuConsulta();
		this.secuConsulta = l.getEjercicioConsulta();
		this.ejercicioConsulta = l.getEjercicioConsulta();
		this.usuario = l.getUsuario();
		this.fechaConsulta = l.getFechaConsulta();
	}
	
	public LogConsultaChequesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocuConsulta() {
		return docuConsulta;
	}
	public void setDocuConsulta(String docuConsulta) {
		this.docuConsulta = docuConsulta;
	}
	public int getSecuConsulta() {
		return secuConsulta;
	}
	public void setSecuConsulta(int secuConsulta) {
		this.secuConsulta = secuConsulta;
	}
	public int getEjercicioConsulta() {
		return ejercicioConsulta;
	}
	public void setEjercicioConsulta(int ejercicioConsulta) {
		this.ejercicioConsulta = ejercicioConsulta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	
	
	
	

}
