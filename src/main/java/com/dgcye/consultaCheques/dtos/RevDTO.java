package com.dgcye.consultaCheques.dtos;

public class RevDTO {
    String rev;
    String descr;
	
	public RevDTO() {
		super();
	}


	
	
	/**
	 * @return
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @return
	 */
	public String getRev() {
		return rev;
	}

	/**
	 * @param string
	 */
	public void setDescr(String string) {
		descr = string;
	}

	/**
	 * @param string
	 */
	public void setRev(String string) {
		rev = string;
	}

}