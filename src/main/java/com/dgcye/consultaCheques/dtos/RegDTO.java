package com.dgcye.consultaCheques.dtos;

public class RegDTO  {
    String reg;
    String descr;
	
	public RegDTO() {
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
	public String getReg() {
		return reg;
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
	public void setReg(String string) {
		reg = string;
	}

}