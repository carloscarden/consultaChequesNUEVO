package com.dgcye.consultaCheques.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Logconsultacheques implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "docuconsulta")
	String docuConsulta;
	
	@Column(name = "secuconsulta")
	int secuConsulta;
	
	@Column(name = "ejercicioconsulta")
	int ejercicioConsulta;
	
	@Column(name = "usuario")
	String usuario;
	
	
	@Column(name = "fechaconsulta")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	Date fechaConsulta;
	
	
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
