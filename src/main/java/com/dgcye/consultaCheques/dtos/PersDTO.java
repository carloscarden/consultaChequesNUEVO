package com.dgcye.consultaCheques.dtos;
import java.util.Date;

public class PersDTO {
	int pin;
	Date vigd;
	Date vigh;
    String docu;
    String nombre;
    Date alta;
    String sexo;
    	


	public PersDTO() {
		super();
	}

	public Date getAlta() {
		return alta;
	}


	public String getDocu() {
		return docu;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPin() {
		return pin;
	}

	public String getSexo() {
		return sexo;
	}

    public Date getVigd() {
		return vigd;
	}

	public Date getVigh() {
		return vigh;
	}

	public void setAlta(Date date) {
		alta = date;
	}

	public void setDocu(String string) {
		docu = string;
	}

	public void setNombre(String string) {
		nombre = string;
	}

	public void setPin(int i) {
		pin = i;
	}

	public void setSexo(String string) {
		sexo = string;
	}

	public void setVigd(Date date) {
		vigd = date;
	}

	public void setVigh(Date date) {
		vigh = date;
	}




}