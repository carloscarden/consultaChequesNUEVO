package com.dgcye.consultaCheques.dtos;

import java.text.SimpleDateFormat;

import com.dgcye.consultaCheques.model.Dep;
import com.dgcye.consultaCheques.model.Org;
import com.dgcye.consultaCheques.model.VEInfoCheq;
import com.dgcye.consultaCheques.model.VInfoCheq;

public class DetPeriodoDTO {
	private String periodo = null;
	private String documento = null;
	private String secuencia = null;
	private String fechaafec = null;
	private String apellido = null;
	private String foja = null;
	private String cargo = null;
	private String dep = null;
	private String dis = null;
	private String tor = null;
	private String escu = null;
	private String opag = null;
	private String dopag = null;
	private String cdoc = null;
	private String liquido = null;
	private String fecafec = null;
	private String nrocheq = null;
	private String fpago = null;
	private String cat = null;
	private String apart = null;
	private String item = null;
	
	public DetPeriodoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * cargo establecimiento designado
	 */
	public DetPeriodoDTO(VInfoCheq cheq) {
		// TODO Auto-generated constructor stub
		
		String fecha = String.valueOf(cheq.getPerOpago())
				.substring(0, 4)
				+ "/"
				+ String.valueOf(cheq.getPerOpago())
						.substring(4, 6);
		this.setPeriodo(fecha);
		this.setDocumento(cheq.getDocu());
		this.setSecuencia(String.valueOf(cheq.getSecu()));
		fecha = String.valueOf(cheq.getFecAfec()).substring(0, 4)
				+ "/"
				+ String.valueOf(cheq.getFecAfec()).substring(4, 6);

		this.setFechaafec(fecha);
		this.setApellido(cheq.getNombrePers());
		this.setFoja("0");
		this.setCargo("0");
		this.setDep(cheq.getDependencia().getDescr());
		this.setDis(cheq.getNombreDistrito());
		this.setTor(cheq.getTipoOrg().getDescr());
		this.setEscu(String.valueOf(cheq.getNumero()));
		this.setDep(cheq.getDependencia().getDescr());
		this.setDis(cheq.getNombreDistrito());
		this.setTor(cheq.getTipoOrg().getDescr());
		this.setEscu(String.valueOf(cheq.getNumero()));
		
		/*
		 * cargo establecimiento designado
		 */
		if ((cheq.getEscuidEscart() != null)
				&& (cheq.getEscuidEscart().intValue() == cheq
						.getEscuid())) {
			this.setDep(cheq.getDependencia().getDescr());
			this.setDis(cheq.getNombreDistrito());
			this.setTor(cheq.getTipoOrg().getDescr());
			this.setEscu(String.valueOf(cheq.getNumero()));
			
		}
		this.setOpag(String.valueOf(cheq.getOpid()));
		this.setDopag(String.valueOf(cheq.getOpid()) + " - "
				+ cheq.getNombreOpago());
		this.setNrocheq(String.valueOf(cheq.getNroCheq()));
		this.setLiquido(String.valueOf(cheq.getLiquido()));
		this.setFecafec(String.valueOf(cheq.getFecAfec()));
		this.setCat(cheq.getCat().getCat());
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		if (cheq.getFpago() != null)
			this.setFpago(sd.format(((cheq.getFpago()))));
	}
	
	
	public DetPeriodoDTO(VInfoCheq cheq, Org org, Dep dep) {
		// TODO Auto-generated constructor stub
		
		String fecha = String.valueOf(cheq.getPerOpago())
				.substring(0, 4)
				+ "/"
				+ String.valueOf(cheq.getPerOpago())
						.substring(4, 6);
		this.setPeriodo(fecha);
		this.setDocumento(cheq.getDocu());
		this.setSecuencia(String.valueOf(cheq.getSecu()));
		fecha = String.valueOf(cheq.getFecAfec()).substring(0, 4)
				+ "/"
				+ String.valueOf(cheq.getFecAfec()).substring(4, 6);

		this.setFechaafec(fecha);
		this.setApellido(cheq.getNombrePers());
		this.setFoja("0");
		this.setCargo("0");
		this.setEscu(String.valueOf(cheq.getNumero()));
		/*
		 * cargo establecimiento designado
		 */
		if ((cheq.getEscuidEscart() != null)
				&& (cheq.getEscuidEscart().intValue() == cheq
						.getEscuid())) {
			this.setDep(cheq.getDependencia().getDescr());
			this.setDis(cheq.getNombreDistrito());
			this.setTor(cheq.getTipoOrg().getDescr());
			this.setEscu(String.valueOf(cheq.getNumero()));
			
		}
		this.setOpag(String.valueOf(cheq.getOpid()));
		this.setDopag(String.valueOf(cheq.getOpid()) + " - "
				+ cheq.getNombreOpago());
		this.setNrocheq(String.valueOf(cheq.getNroCheq()));
		this.setLiquido(String.valueOf(cheq.getLiquido()));
		this.setFecafec(String.valueOf(cheq.getFecAfec()));
		this.setCat(cheq.getCat().getCat());
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		if (cheq.getFpago() != null)
			this.setFpago(sd.format(((cheq.getFpago()))));
		

	}
	
	public DetPeriodoDTO(VEInfoCheq cheq) {
		String fecha = String.valueOf(cheq.getPerOpago()).substring(0,
				4)
				+ "/"
				+ String.valueOf(cheq.getPerOpago()).substring(4, 6);
		this.setPeriodo(fecha);
		this.setDocumento(cheq.getDocu());
		this.setSecuencia(String.valueOf(cheq.getSecu()));
		this.setFechaafec(" ");
		this.setApellido(cheq.getNombrePers());
		this.setFoja(String.valueOf(cheq.getFoja()));
		this.setCargo(String.valueOf(cheq.getCargo()));

		this.setDep("OFICIAL");
		this.setDis(cheq.getNombreDistrito());
		this.setTor(" ");
		this.setEscu(String.valueOf(cheq.getNumero()));

		this.setOpag(String.valueOf(cheq.getOpid()));
		this.setDopag(String.valueOf(cheq.getOpid()) + " - "
				+ cheq.getNombreOpago());
		this.setNrocheq(String.valueOf(cheq.getNroCheq()));
		this.setLiquido(String.valueOf(cheq.getLiquido()));
		this.setCat(cheq.getCat());
		this.setApart(String.valueOf(cheq.getApart()));
		this.setItem(String.valueOf(cheq.getItem()));
		
	}

	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}
	public String getFechaafec() {
		return fechaafec;
	}
	public void setFechaafec(String fechaafec) {
		this.fechaafec = fechaafec;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFoja() {
		return foja;
	}
	public void setFoja(String foja) {
		this.foja = foja;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String getTor() {
		return tor;
	}
	public void setTor(String tor) {
		this.tor = tor;
	}
	public String getEscu() {
		return escu;
	}
	public void setEscu(String escu) {
		this.escu = escu;
	}
	public String getOpag() {
		return opag;
	}
	public void setOpag(String opag) {
		this.opag = opag;
	}
	public String getDopag() {
		return dopag;
	}
	public void setDopag(String dopag) {
		this.dopag = dopag;
	}
	public String getCdoc() {
		return cdoc;
	}
	public void setCdoc(String cdoc) {
		this.cdoc = cdoc;
	}
	public String getLiquido() {
		return liquido;
	}
	public void setLiquido(String liquido) {
		this.liquido = liquido;
	}
	public String getFecafec() {
		return fecafec;
	}
	public void setFecafec(String fecafec) {
		this.fecafec = fecafec;
	}
	public String getNrocheq() {
		return nrocheq;
	}
	public void setNrocheq(String nrocheq) {
		this.nrocheq = nrocheq;
	}
	public String getFpago() {
		return fpago;
	}
	public void setFpago(String fpago) {
		this.fpago = fpago;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getApart() {
		return apart;
	}
	public void setApart(String apart) {
		this.apart = apart;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
	
	

}
