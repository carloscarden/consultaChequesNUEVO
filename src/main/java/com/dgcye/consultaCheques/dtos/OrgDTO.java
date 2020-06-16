package com.dgcye.consultaCheques.dtos;

public class OrgDTO {
    String org;
    String descr;
 	
	public OrgDTO() {
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
	public String getOrg() {
		return org;
	}

	/**
	 * @param string
	 */
	public void setDescr(String string) {
		descr = string;
	}

	/**
	 * @param i
	 */
	public void setOrg(String string) {
		org = string;
	}

}