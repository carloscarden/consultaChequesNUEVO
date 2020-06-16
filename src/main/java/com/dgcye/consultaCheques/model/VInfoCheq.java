package com.dgcye.consultaCheques.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(VInfocheqId.class)
@Table (name="V_INFOCHEQ")
public class VInfoCheq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pin")
	private Integer pin;

	@Id
	@Column(name = "secu")
	private Integer secu;

	@Id
	@Column(name = "esDeno")
	private String esDeno;

	@Id
	@Column(name = "opid")
	private Integer opid;

	@Id
	@Column(name = "fecAfec")
	private Integer fecAfec;
	
	@Id
	@Column(name = "liqid")
	private Integer liqid;
	
	@Id
	@Column(name = "nrocheq")
	private Integer nroCheq;

	@Column(name = "vigdPers")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vigdPers;

	@Column(name = "vighPers")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vighPers;

	@Column(name = "docu")
	private String docu;

	@Column(name = "nombrePers")
	private String nombrePers;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "vigdCar")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vigdCar;

	@Column(name = "vighCar")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vighCar;

	@ManyToOne
	@JoinColumns({
	     @JoinColumn(name="cat", referencedColumnName="cat", insertable=false, updatable=false),
	     @JoinColumn(name="esDeno", referencedColumnName="esDeno", insertable=false, updatable=false)
	})
	private Cat cat;

	@ManyToOne
	@JoinColumn(name = "rev")
	private Rev rev;

	@ManyToOne
	@JoinColumn(name = "reg")
	private Reg reg;

	@ManyToOne
	@JoinColumn(name = "tipo_org", referencedColumnName = "org")
	private Org tipoOrg;

	@ManyToOne
	@JoinColumn(name = "dependencia", referencedColumnName = "dep")
	private Dep dependencia;

	@Column(name = "hs")
	private Double hs;

	@Column(name = "dobEscolCargo")
	private String dobEscolCargo;

	@Column(name = "sit")
	private String sit;

	@Column(name = "item")
	private Integer item;

	@Column(name = "apart")
	private Integer apart;

	@Column(name = "codMov")
	private String codMov;

	@Column(name = "fcion")
	private String fcion;

	@Column(name = "convenio")
	private String convenio;

	@Column(name = "garantia")
	private String garantia;

	@Column(name = "movilidad")
	private String movilidad;

	@Column(name = "presentismo")
	private String presentismo;

	@Column(name = "escuid")
	private Integer escuid;

	@Column(name = "vigdEstab")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vigdEstab;

	@Column(name = "vighEstab")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vighEstab;

	@Column(name = "distrito")
	private Integer distrito;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "nombreEstab")
	private String nombreEstab;

	@Column(name = "ccticas")
	private String ccticas;

	@Column(name = "rural")
	private Integer rural;

	@Column(name = "secciones")
	private Integer secciones;

	@Column(name = "turnos")
	private Integer turnos;

	@Column(name = "subvencion")
	private Integer subvencion;

	@Column(name = "dobEscolEstab")
	private Integer dobEscolEstab;

	@Column(name = "nombreDistrito")
	private String nombreDistrito;

	@Column(name = "inas")
	private Double inas;

	@Column(name = "periodo")
	private Integer periodo;

	

	@Column(name = "tipoCheque")
	private String tipoCheque;

	

	@Column(name = "antig")
	private String antig;

	@Column(name = "emitirCheq")
	private String emitirCheq;

	@Column(name = "liquido")
	double liquido;

	@Column(name = "observacionesCheque")
	private String observacionesCheque;

	@Column(name = "escuidCheque")
	private Integer escuidCheque;

	@Column(name = "nombreOpago")
	private String nombreOpago;

	@Column(name = "vencimiento")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vencimiento;

	@Column(name = "origen")
	private String origen;

	@Column(name = "tipoOpago")
	private String tipoOpago;

	@Column(name = "cajero")
	private Integer cajero;

	@Column(name = "vigOpago")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vigOpago;

	@Column(name = "moneda")
	private String moneda;

	@Column(name = "muestra")
	private String muestra;

	@Column(name = "caracRevOpago")
	private String caracRevOpago;

	@Column(name = "perOpago")
	private Integer perOpago;

	@Column(name = "opidIps")
	private Integer opidIps;

	@Column(name = "opidIoma")
	private Integer opidIoma;

	@Column(name = "vigdInt")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vigdInt;

	@Column(name = "vighInt")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vighInt;

	@Column(name = "escuidInt")
	private Integer escuidInt;

	@Column(name = "catInt")
	private String catInt;

	@Column(name = "dependenciaInt")
	private Integer dependenciaInt;

	@Column(name = "tipoOrgInt")
	private String tipoOrgInt;

	@Column(name = "hsInt")
	private Double hsInt;

	@Column(name = "dobEscolInt")
	private String dobEscolInt;

	@Column(name = "itemInt")
	private Integer itemInt;

	@Column(name = "apartInt")
	private Integer apartInt;

	@Column(name = "codMovInt")
	private String codMovInt;

	@Column(name = "movInt")
	private String movInt;

	@Column(name = "vigdEstabInt")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vigdEstabInt;

	@Column(name = "vighEstabInt")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date vighEstabInt;

	@Column(name = "distritoInt")
	private Integer distritoInt;

	@Column(name = "numeroInt")
	private Integer numeroInt;

	@Column(name = "nombreEstabInt")
	private String nombreEstabInt;

	@Column(name = "ccticasInt")
	private String ccticasInt;

	@Column(name = "ruralInt")
	private Integer ruralInt;

	@Column(name = "seccionesInt")
	private Integer seccionesInt;

	@Column(name = "turnosInt")
	private Integer turnosInt;

	@Column(name = "subvencionInt")
	private Integer subvencionInt;

	@Column(name = "dobEscolEstabInt")
	private Integer dobEscolEstabInt;

	@Column(name = "escuidEscart")
	private Integer escuidEscart;

	@Column(name = "nomDistInt")
	private String nomDistInt;

	@Column(name = "fpago")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date fpago;



	public VInfoCheq() {
		super();
	}



	public Integer getPin() {
		return pin;
	}



	public void setPin(Integer pin) {
		this.pin = pin;
	}



	public Integer getSecu() {
		return secu;
	}



	public void setSecu(Integer secu) {
		this.secu = secu;
	}



	public String getEsDeno() {
		return esDeno;
	}



	public void setEsDeno(String esDeno) {
		this.esDeno = esDeno;
	}



	public Integer getOpid() {
		return opid;
	}



	public void setOpid(Integer opid) {
		this.opid = opid;
	}



	public Integer getFecAfec() {
		return fecAfec;
	}



	public void setFecAfec(Integer fecAfec) {
		this.fecAfec = fecAfec;
	}



	public Integer getLiqid() {
		return liqid;
	}



	public void setLiqid(Integer liqid) {
		this.liqid = liqid;
	}



	public Integer getNroCheq() {
		return nroCheq;
	}



	public void setNroCheq(Integer nroCheq) {
		this.nroCheq = nroCheq;
	}



	public Date getVigdPers() {
		return vigdPers;
	}



	public void setVigdPers(Date vigdPers) {
		this.vigdPers = vigdPers;
	}



	public Date getVighPers() {
		return vighPers;
	}



	public void setVighPers(Date vighPers) {
		this.vighPers = vighPers;
	}



	public String getDocu() {
		return docu;
	}



	public void setDocu(String docu) {
		this.docu = docu;
	}



	public String getNombrePers() {
		return nombrePers;
	}



	public void setNombrePers(String nombrePers) {
		this.nombrePers = nombrePers;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Date getVigdCar() {
		return vigdCar;
	}



	public void setVigdCar(Date vigdCar) {
		this.vigdCar = vigdCar;
	}



	public Date getVighCar() {
		return vighCar;
	}



	public void setVighCar(Date vighCar) {
		this.vighCar = vighCar;
	}



	public Cat getCat() {
		return cat;
	}



	public void setCat(Cat cat) {
		this.cat = cat;
	}



	public Rev getRev() {
		return rev;
	}



	public void setRev(Rev rev) {
		this.rev = rev;
	}



	public Reg getReg() {
		return reg;
	}



	public void setReg(Reg reg) {
		this.reg = reg;
	}



	public Org getTipoOrg() {
		return tipoOrg;
	}



	public void setTipoOrg(Org tipoOrg) {
		this.tipoOrg = tipoOrg;
	}



	public Dep getDependencia() {
		return dependencia;
	}



	public void setDependencia(Dep dependencia) {
		this.dependencia = dependencia;
	}



	public Double getHs() {
		return hs;
	}



	public void setHs(Double hs) {
		this.hs = hs;
	}



	public String getDobEscolCargo() {
		return dobEscolCargo;
	}



	public void setDobEscolCargo(String dobEscolCargo) {
		this.dobEscolCargo = dobEscolCargo;
	}



	public String getSit() {
		return sit;
	}



	public void setSit(String sit) {
		this.sit = sit;
	}



	public Integer getItem() {
		return item;
	}



	public void setItem(Integer item) {
		this.item = item;
	}



	public Integer getApart() {
		return apart;
	}



	public void setApart(Integer apart) {
		this.apart = apart;
	}



	public String getCodMov() {
		return codMov;
	}



	public void setCodMov(String codMov) {
		this.codMov = codMov;
	}



	public String getFcion() {
		return fcion;
	}



	public void setFcion(String fcion) {
		this.fcion = fcion;
	}



	public String getConvenio() {
		return convenio;
	}



	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}



	public String getGarantia() {
		return garantia;
	}



	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}



	public String getMovilidad() {
		return movilidad;
	}



	public void setMovilidad(String movilidad) {
		this.movilidad = movilidad;
	}



	public String getPresentismo() {
		return presentismo;
	}



	public void setPresentismo(String presentismo) {
		this.presentismo = presentismo;
	}



	public Integer getEscuid() {
		return escuid;
	}



	public void setEscuid(Integer escuid) {
		this.escuid = escuid;
	}



	public Date getVigdEstab() {
		return vigdEstab;
	}



	public void setVigdEstab(Date vigdEstab) {
		this.vigdEstab = vigdEstab;
	}



	public Date getVighEstab() {
		return vighEstab;
	}



	public void setVighEstab(Date vighEstab) {
		this.vighEstab = vighEstab;
	}



	public Integer getDistrito() {
		return distrito;
	}



	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public String getNombreEstab() {
		return nombreEstab;
	}



	public void setNombreEstab(String nombreEstab) {
		this.nombreEstab = nombreEstab;
	}



	public String getCcticas() {
		return ccticas;
	}



	public void setCcticas(String ccticas) {
		this.ccticas = ccticas;
	}



	public Integer getRural() {
		return rural;
	}



	public void setRural(Integer rural) {
		this.rural = rural;
	}



	public Integer getSecciones() {
		return secciones;
	}



	public void setSecciones(Integer secciones) {
		this.secciones = secciones;
	}



	public Integer getTurnos() {
		return turnos;
	}



	public void setTurnos(Integer turnos) {
		this.turnos = turnos;
	}



	public Integer getSubvencion() {
		return subvencion;
	}



	public void setSubvencion(Integer subvencion) {
		this.subvencion = subvencion;
	}



	public Integer getDobEscolEstab() {
		return dobEscolEstab;
	}



	public void setDobEscolEstab(Integer dobEscolEstab) {
		this.dobEscolEstab = dobEscolEstab;
	}



	public String getNombreDistrito() {
		return nombreDistrito;
	}



	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}



	public Double getInas() {
		return inas;
	}



	public void setInas(Double inas) {
		this.inas = inas;
	}



	public Integer getPeriodo() {
		return periodo;
	}



	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}



	public String getTipoCheque() {
		return tipoCheque;
	}



	public void setTipoCheque(String tipoCheque) {
		this.tipoCheque = tipoCheque;
	}



	public String getAntig() {
		return antig;
	}



	public void setAntig(String antig) {
		this.antig = antig;
	}



	public String getEmitirCheq() {
		return emitirCheq;
	}



	public void setEmitirCheq(String emitirCheq) {
		this.emitirCheq = emitirCheq;
	}



	public double getLiquido() {
		return liquido;
	}



	public void setLiquido(double liquido) {
		this.liquido = liquido;
	}



	public String getObservacionesCheque() {
		return observacionesCheque;
	}



	public void setObservacionesCheque(String observacionesCheque) {
		this.observacionesCheque = observacionesCheque;
	}



	public Integer getEscuidCheque() {
		return escuidCheque;
	}



	public void setEscuidCheque(Integer escuidCheque) {
		this.escuidCheque = escuidCheque;
	}



	public String getNombreOpago() {
		return nombreOpago;
	}



	public void setNombreOpago(String nombreOpago) {
		this.nombreOpago = nombreOpago;
	}



	public Date getVencimiento() {
		return vencimiento;
	}



	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}



	public String getOrigen() {
		return origen;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public String getTipoOpago() {
		return tipoOpago;
	}



	public void setTipoOpago(String tipoOpago) {
		this.tipoOpago = tipoOpago;
	}



	public Integer getCajero() {
		return cajero;
	}



	public void setCajero(Integer cajero) {
		this.cajero = cajero;
	}



	public Date getVigOpago() {
		return vigOpago;
	}



	public void setVigOpago(Date vigOpago) {
		this.vigOpago = vigOpago;
	}



	public String getMoneda() {
		return moneda;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public String getMuestra() {
		return muestra;
	}



	public void setMuestra(String muestra) {
		this.muestra = muestra;
	}



	public String getCaracRevOpago() {
		return caracRevOpago;
	}



	public void setCaracRevOpago(String caracRevOpago) {
		this.caracRevOpago = caracRevOpago;
	}



	public Integer getPerOpago() {
		return perOpago;
	}



	public void setPerOpago(Integer perOpago) {
		this.perOpago = perOpago;
	}



	public Integer getOpidIps() {
		return opidIps;
	}



	public void setOpidIps(Integer opidIps) {
		this.opidIps = opidIps;
	}



	public Integer getOpidIoma() {
		return opidIoma;
	}



	public void setOpidIoma(Integer opidIoma) {
		this.opidIoma = opidIoma;
	}



	public Date getVigdInt() {
		return vigdInt;
	}



	public void setVigdInt(Date vigdInt) {
		this.vigdInt = vigdInt;
	}



	public Date getVighInt() {
		return vighInt;
	}



	public void setVighInt(Date vighInt) {
		this.vighInt = vighInt;
	}



	public Integer getEscuidInt() {
		return escuidInt;
	}



	public void setEscuidInt(Integer escuidInt) {
		this.escuidInt = escuidInt;
	}



	public String getCatInt() {
		return catInt;
	}



	public void setCatInt(String catInt) {
		this.catInt = catInt;
	}



	public Integer getDependenciaInt() {
		return dependenciaInt;
	}



	public void setDependenciaInt(Integer dependenciaInt) {
		this.dependenciaInt = dependenciaInt;
	}



	public String getTipoOrgInt() {
		return tipoOrgInt;
	}



	public void setTipoOrgInt(String tipoOrgInt) {
		this.tipoOrgInt = tipoOrgInt;
	}



	public Double getHsInt() {
		return hsInt;
	}



	public void setHsInt(Double hsInt) {
		this.hsInt = hsInt;
	}



	public String getDobEscolInt() {
		return dobEscolInt;
	}



	public void setDobEscolInt(String dobEscolInt) {
		this.dobEscolInt = dobEscolInt;
	}



	public Integer getItemInt() {
		return itemInt;
	}



	public void setItemInt(Integer itemInt) {
		this.itemInt = itemInt;
	}



	public Integer getApartInt() {
		return apartInt;
	}



	public void setApartInt(Integer apartInt) {
		this.apartInt = apartInt;
	}



	public String getCodMovInt() {
		return codMovInt;
	}



	public void setCodMovInt(String codMovInt) {
		this.codMovInt = codMovInt;
	}



	public String getMovInt() {
		return movInt;
	}



	public void setMovInt(String movInt) {
		this.movInt = movInt;
	}



	public Date getVigdEstabInt() {
		return vigdEstabInt;
	}



	public void setVigdEstabInt(Date vigdEstabInt) {
		this.vigdEstabInt = vigdEstabInt;
	}



	public Date getVighEstabInt() {
		return vighEstabInt;
	}



	public void setVighEstabInt(Date vighEstabInt) {
		this.vighEstabInt = vighEstabInt;
	}



	public Integer getDistritoInt() {
		return distritoInt;
	}



	public void setDistritoInt(Integer distritoInt) {
		this.distritoInt = distritoInt;
	}



	public Integer getNumeroInt() {
		return numeroInt;
	}



	public void setNumeroInt(Integer numeroInt) {
		this.numeroInt = numeroInt;
	}



	public String getNombreEstabInt() {
		return nombreEstabInt;
	}



	public void setNombreEstabInt(String nombreEstabInt) {
		this.nombreEstabInt = nombreEstabInt;
	}



	public String getCcticasInt() {
		return ccticasInt;
	}



	public void setCcticasInt(String ccticasInt) {
		this.ccticasInt = ccticasInt;
	}



	public Integer getRuralInt() {
		return ruralInt;
	}



	public void setRuralInt(Integer ruralInt) {
		this.ruralInt = ruralInt;
	}



	public Integer getSeccionesInt() {
		return seccionesInt;
	}



	public void setSeccionesInt(Integer seccionesInt) {
		this.seccionesInt = seccionesInt;
	}



	public Integer getTurnosInt() {
		return turnosInt;
	}



	public void setTurnosInt(Integer turnosInt) {
		this.turnosInt = turnosInt;
	}



	public Integer getSubvencionInt() {
		return subvencionInt;
	}



	public void setSubvencionInt(Integer subvencionInt) {
		this.subvencionInt = subvencionInt;
	}



	public Integer getDobEscolEstabInt() {
		return dobEscolEstabInt;
	}



	public void setDobEscolEstabInt(Integer dobEscolEstabInt) {
		this.dobEscolEstabInt = dobEscolEstabInt;
	}



	public Integer getEscuidEscart() {
		return escuidEscart;
	}



	public void setEscuidEscart(Integer escuidEscart) {
		this.escuidEscart = escuidEscart;
	}



	public String getNomDistInt() {
		return nomDistInt;
	}



	public void setNomDistInt(String nomDistInt) {
		this.nomDistInt = nomDistInt;
	}



	public Date getFpago() {
		return fpago;
	}



	public void setFpago(Date fpago) {
		this.fpago = fpago;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	



	




}