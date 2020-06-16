package com.dgcye.consultaCheques.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@IdClass(Estab.class)
public class Estab implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "escuid")
	int escuid;
	
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
	
	
	
	@ManyToOne
	@JoinColumn(name="distrito")
	Distrito distrito;
	
	
	@ManyToOne
	@JoinColumn(name="dep")
    Dep dependencia;
    
    @ManyToOne
	@JoinColumn(name="tipo_org",referencedColumnName="org")
    Org tipo_org;
    
    @Column(name = "numero")
    int numero;
    
    @Column(name = "nombre")
    String nombre;
    
    @Column(name = "rural")
    int rural;
    
    @Column(name = "secciones")
    int secciones;
    
    @Column(name = "turnos")
    int turnos;
    
    @Column(name = "subvencion")
    int subvencion;
    
    @Column(name = "dob_escol")
    int dob_escol;
     
	
	public Estab() {
	}


	public boolean equals(Object o) {
		if (o == null)
		  return false;
		if (this == o)
		  return true;
		if (!(o instanceof Estab))
		  return false;
		final Estab elem = (Estab)o;

		if (this.getEscuid() != elem.getEscuid())
		  return false;
		
		if (!this.getVigd().equals(elem.getVigd()))
		  return false;
		
		if (!this.getVigh().equals(elem.getVigh()))
		  return false;
		  
		return true;

	}

	public int hashCode() {
		int result = 14;
		result = 29 * result + getEscuid() + getVigd().hashCode() + getVigh().hashCode();
		return result;
	}

	/**
	 * @return
	 */
	public Dep getDependencia() {
		return dependencia;
	}

	/**
	 * @return
	 */
	public Distrito getDistrito() {
		return distrito;
	}

	/**
	 * @return
	 */
	public int getDob_escol() {
		return dob_escol;
	}

	/**
	 * @return
	 */
	public int getEscuid() {
		return escuid;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return
	 */
	public int getRural() {
		return rural;
	}

	/**
	 * @return
	 */
	public int getSecciones() {
		return secciones;
	}

	/**
	 * @return
	 */
	public int getSubvencion() {
		return subvencion;
	}

	/**
	 * @return
	 */
	public Org getTipo_org() {
		return tipo_org;
	}

	/**
	 * @return
	 */
	public int getTurnos() {
		return turnos;
	}

	/**
	 * @return
	 */
	public Date getVigd() {
		return vigd;
	}

	/**
	 * @return
	 */
	public Date getVigh() {
		return vigh;
	}

	/**
	 * @param dep
	 */
	public void setDependencia(Dep dep) {
		dependencia = dep;
	}

	/**
	 * @param distrito
	 */
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	/**
	 * @param i
	 */
	public void setDob_escol(int i) {
		dob_escol = i;
	}

	/**
	 * @param i
	 */
	public void setEscuid(int i) {
		escuid = i;
	}

	/**
	 * @param string
	 */
	public void setNombre(String string) {
		nombre = string;
	}

	/**
	 * @param i
	 */
	public void setNumero(int i) {
		numero = i;
	}

	/**
	 * @param i
	 */
	public void setRural(int i) {
		rural = i;
	}

	/**
	 * @param i
	 */
	public void setSecciones(int i) {
		secciones = i;
	}

	/**
	 * @param i
	 */
	public void setSubvencion(int i) {
		subvencion = i;
	}

	/**
	 * @param org
	 */
	public void setTipo_org(Org org) {
		tipo_org = org;
	}

	/**
	 * @param i
	 */
	public void setTurnos(int i) {
		turnos = i;
	}

	/**
	 * @param date
	 */
	public void setVigd(Date date) {
		vigd = date;
	}

	/**
	 * @param date
	 */
	public void setVigh(Date date) {
		vigh = date;
	}

}