package com.dgcye.consultaCheques.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@IdClass(Pers.class)
public class Pers implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pin")
	int pin;
	
	@Id
	@Column(name = "vigd")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	Date vigd;
	
	
	@Id
	@Column(name = "vigh")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
	Date vigh;
	
	@Column(name = "docu")
    String docu;
	
	@Column(name = "nombre")
    String nombre;
	
	@Column(name = "alta")
	@Temporal(value=TemporalType.DATE)
    @JsonFormat(pattern="MM-dd-yyyy")
	@DateTimeFormat(pattern="MM-dd-yyyy")
    Date alta;
    
    @Column(name = "sexo")
    String sexo;
    
    
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Date getVigd() {
		return vigd;
	}
	public void setVigd(Date vigd) {
		this.vigd = vigd;
	}
	public Date getVigh() {
		return vigh;
	}
	public void setVigh(Date vigh) {
		this.vigh = vigh;
	}
	public String getDocu() {
		return docu;
	}
	public void setDocu(String docu) {
		this.docu = docu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
    
    
    
    

}
