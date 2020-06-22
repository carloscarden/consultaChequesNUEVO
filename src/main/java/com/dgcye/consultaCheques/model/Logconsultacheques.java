package com.dgcye.consultaCheques.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Logconsultacheques implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "docuconsulta")
	private String docuConsulta;
	
	@Column(name = "secuconsulta")
	private Integer secuConsulta;
	
	@Column(name = "ejercicioconsulta")
	private Integer ejercicioConsulta;
	
	@Column(name = "usuario")
	private String usuario;
	
	
	@Column(name = "fechaconsulta")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date fechaConsulta;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDocuConsulta() {
		return docuConsulta;
	}


	public void setDocuConsulta(String docuConsulta) {
		this.docuConsulta = docuConsulta;
	}


	public Integer getSecuConsulta() {
		return secuConsulta;
	}


	public void setSecuConsulta(Integer secuConsulta) {
		this.secuConsulta = secuConsulta;
	}


	public Integer getEjercicioConsulta() {
		return ejercicioConsulta;
	}


	public void setEjercicioConsulta(Integer ejercicioConsulta) {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	

}
