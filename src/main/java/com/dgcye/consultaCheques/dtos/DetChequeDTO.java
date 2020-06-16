package com.dgcye.consultaCheques.dtos;

import com.dgcye.consultaCheques.model.Dep;
import com.dgcye.consultaCheques.model.Estab;
import com.dgcye.consultaCheques.model.Org;
import com.dgcye.consultaCheques.model.Rev;
import com.dgcye.consultaCheques.model.VEInfoCheq;
import com.dgcye.consultaCheques.model.VInfoCheq;

public class DetChequeDTO {

	/*
	 * no dependen de real o interino
	 */
	String periodo = null;
	String documento = null;
	String secuencia = null;
	String dopag = null;
	String apellidoNombre = null;
	String antiguedad = null;

	String reg = null;
	String rev = null;
	String nrocheq = null;
	String movilidad = null;
	String presentismo = null;
	String inasistencias = null;
	String foja = null;
	String cargo = null;
	String fechaAfec = null;
	String cuitCuil = null;
	String sexo = null;
	String opid = null;
	String item = null;
	String apartado = null;
	String nopagado = null;

	/*
	 * datos reales
	 */

	String dep_r = null;
	String disNombre_r = null;
	String disNro_r = null;
	String tor_r = null;
	String escu_r = null;
	String rural_r = null;
	String caracteristicas_r = null;
	String secciones_r = null;
	String turnos_r = null;
	String hs_r = null;
	String dobleEscolaridadEstab_r = null;
	String subvencion_r = null;
	String categoria_r = null;
	String codMov_r = null;
	String dobleEscolaridadCargo_r = null;

	/*
	 * datos interinos
	 */
	String dep_i = null;
	String disNombre_i = null;
	String disNro_i = null;
	String tor_i = null;
	String escu_i = null;
	String rural_i = null;
	String secciones_i = null;
	String turnos_i = null;
	String hs_i = null;
	String caracteristicas_i = null;
	String dobleEscolaridadEstab_i = null;
	String subvencion_i = null;
	String categoria_i = null;
	String codMov_i = null;
	String dobleEscolaridadCargo_i = null;

	/*
	 * datos estab articulados
	 */
	String dep_a = null;
	String disNombre_a = null;
	String disNro_a = null;
	String tor_a = null;
	String escu_a = null;
	String caracteristicas_a = null;
	String dobleEscolaridadEstab_a = null;
	String rural_a = null;
	String subvencion_a = null;

	String liquido = null;
	String fpago = null;

	public DetChequeDTO(VInfoCheq cheq) {
		/*
		 * cargo parte comun
		 */

		String str = String.valueOf(cheq.getPerOpago()).substring(0, 4) + "/"
				+ String.valueOf(cheq.getPerOpago()).substring(4, 6);
		this.setPeriodo(str);
		this.setFechaAfec(String.valueOf(fechaAfec));
		this.setDocumento(cheq.getDocu());
		this.setSecuencia(String.valueOf(cheq.getSecu()));
		this.setApellidoNombre(cheq.getNombrePers());
		this.setFoja("0");
		this.setCargo("0");
		this.setOpid(String.valueOf(cheq.getOpid()));
		this.setDopag(cheq.getNombreOpago());
		this.setAntiguedad(cheq.getAntig());
		this.setReg(cheq.getReg().getDescr());
		this.setRev(cheq.getRev().getDescr());
		this.setNrocheq(String.valueOf(cheq.getNroCheq()));
		this.setMovilidad(cheq.getMovilidad());
		this.setPresentismo(cheq.getPresentismo());
		this.setInasistencias(String.valueOf(cheq.getInas()));
		this.setLiquido(String.valueOf(cheq.getLiquido()));
		this.setFpago(String.valueOf(cheq.getFpago()));
		this.setSexo(cheq.getSexo());
		if (cheq.getPerOpago() < 200501) {
			if (cheq.getTipoCheque().equals("N") || cheq.getTipoCheque().equals("D")
					|| cheq.getTipoCheque().equals("O")) {
				this.setNopagado("NO");
			} else {
				this.setNopagado("SI");
			}
		} else
			this.setNopagado("  ");

		/*
		 * cargo parte real
		 */

		this.setItem(String.valueOf(cheq.getItem()));
		this.setApartado(String.valueOf(cheq.getApart()));

		this.setRural_r(String.valueOf(cheq.getRural()));
		this.setCategoria_r(cheq.getCat().getCat());

		this.setSecciones_r(String.valueOf(cheq.getSecciones()));
		this.setTurnos_r(String.valueOf(cheq.getTurnos()));
		this.setHs_r(String.valueOf(cheq.getHs()));

		/*
		 * cargo establecimiento designado
		 */
		this.setDep_r(String.valueOf(cheq.getDependencia().getDep()));
		this.setDisNro_r(String.valueOf(cheq.getDistrito()));
		this.setDisNombre_r(cheq.getNombreDistrito());
		this.setTor_r(cheq.getTipoOrg().getOrg());
		this.setEscu_r(String.valueOf(cheq.getNumero()));
		this.setCaracteristicas_r(cheq.getCcticas());
		this.setCodMov_r(cheq.getCodMov());
		this.setDobleEscolaridadCargo_r("N");
		if (cheq.getDobEscolCargo().equals("1"))
			this.setDobleEscolaridadCargo_r("S");

		this.setDobleEscolaridadEstab_r("N");
		for (int i = 0; i < cheq.getCcticas().length(); i++) {
			if (cheq.getCcticas().substring(i, i + 1).equals("C") || cheq.getCcticas().substring(i, i + 1).equals("U")
					|| cheq.getCcticas().substring(i, i + 1).equals("O")
					|| cheq.getCcticas().substring(i, i + 1).equals("K")
					|| cheq.getCcticas().substring(i, i + 1).equals("J")
					|| cheq.getCcticas().substring(i, i + 1).equals("I")
					|| cheq.getCcticas().substring(i, i + 1).equals("L")
					|| cheq.getCcticas().substring(i, i + 1).equals("M")
					|| cheq.getCcticas().substring(i, i + 1).equals("N")
					|| cheq.getCcticas().substring(i, i + 1).equals("9"))
				this.setDobleEscolaridadEstab_r("S");
		}
		this.setSubvencion_r(String.valueOf(cheq.getSubvencion()));

	}

	public DetChequeDTO(VInfoCheq cheq, Dep dep, Org org) {
		this(cheq);
		this.setRural_i(String.valueOf(cheq.getRuralInt()));
		this.setCategoria_i(cheq.getCatInt());
		this.setSecciones_i(String.valueOf(cheq.getSeccionesInt()));
		this.setTurnos_i(String.valueOf(cheq.getTurnosInt()));
		this.setHs_i(String.valueOf(cheq.getHsInt()));

		/*
		 * cargo establecimiento interino
		 */

		this.setDep_i(String.valueOf(dep.getDep()));
		this.setDisNro_i(String.valueOf(cheq.getDistritoInt()));
		this.setDisNombre_i(cheq.getNomDistInt());
		this.setTor_i(org.getOrg());
		this.setEscu_i(String.valueOf(cheq.getNumeroInt()));
		this.setCaracteristicas_i(cheq.getCcticasInt());
		this.setCodMov_i(cheq.getCodMovInt());
		this.setDobleEscolaridadCargo_i("N");
		if (cheq.getDobEscolInt().equals("1"))
			this.setDobleEscolaridadCargo_i("S");

		this.setDobleEscolaridadEstab_i("N");
		for (int i = 0; i < cheq.getCcticasInt().length(); i++) {
			if (cheq.getCcticasInt().substring(i, i + 1).equals("C")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("U")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("O")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("K")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("J")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("I")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("L")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("M")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("N")
					|| cheq.getCcticasInt().substring(i, i + 1).equals("9"))
				this.setDobleEscolaridadEstab_i("S");
		}

		this.setSubvencion_i(String.valueOf(cheq.getSubvencionInt()));
	}

	public DetChequeDTO(VInfoCheq cheq, Dep dep, Org org, Estab estab) {
		this(cheq, dep, org);
		/*
		 * cargo establecimiento articulado
		 */
		this.setDep_a(String.valueOf(estab.getDependencia().getDep()));
		this.setDisNombre_a(estab.getDistrito().getDescripcion());
		this.setDisNro_a(String.valueOf(estab.getDistrito().getDistrito()));
		this.setTor_a(estab.getTipo_org().getOrg());
		this.setEscu_a(String.valueOf(estab.getNumero()));
		this.setRural_a(String.valueOf(estab.getRural()));
		this.setDobleEscolaridadCargo_i("N");
		this.setDobleEscolaridadEstab_a(this.getDobleEscolaridadEstab_r());
		this.setSubvencion_a(String.valueOf(estab.getSubvencion()));

	}

	public DetChequeDTO(VInfoCheq cheq, Estab estab) {
		this(cheq);
		/*
		 * cargo establecimiento articulado
		 */
		this.setDep_a(String.valueOf(estab.getDependencia().getDep()));
		this.setDisNombre_a(estab.getDistrito().getDescripcion());
		this.setDisNro_a(String.valueOf(estab.getDistrito().getDistrito()));
		this.setTor_a(estab.getTipo_org().getOrg());
		this.setEscu_a(String.valueOf(estab.getNumero()));
		this.setRural_a(String.valueOf(estab.getRural()));
		this.setDobleEscolaridadCargo_i("N");
		this.setDobleEscolaridadEstab_a(this.getDobleEscolaridadEstab_r());
		this.setSubvencion_a(String.valueOf(estab.getSubvencion()));

	}

	public DetChequeDTO(VEInfoCheq cheq, Rev revista) {
		super();
		// TODO Auto-generated constructor stub
		String str = String.valueOf(cheq.getPerOpago()).substring(0, 4) + "/"
				+ String.valueOf(cheq.getPerOpago()).substring(4, 6);
		this.setPeriodo(str);
		this.setDocumento(cheq.getDocu());
		this.setSecuencia(String.valueOf(cheq.getSecu()));
		this.setApellidoNombre(cheq.getNombrePers());
		this.setFoja(String.valueOf(cheq.getFoja()));
		this.setCategoria_r(cheq.getCat());

		// Agregado por reclamo de MM docu 10078295, solo cuando la
		// secuencia sea 0-- DPP
		if (((cheq.getApart() >= 6) && (cheq.getApart() <= 9))
				|| ((cheq.getApart() >= 20) && (cheq.getApart() <= 24))) {
			if (cheq.getSecu() == 0) {
				try {
					if (Integer.parseInt(cheq.getCat()) > 0) {
						this.setCategoria_r("PF");
						this.setHs_r(cheq.getCat());
					}
				} catch (Exception e) {
					this.setCategoria_r(cheq.getCat());
				}
			} else
				this.setCategoria_r(cheq.getCat());
		}

		this.setCargo(String.valueOf(cheq.getCargo()));

		this.setAntiguedad(cheq.getAntig());
		
		this.setDopag(cheq.getNombreOpago());
		this.setOpid(String.valueOf(cheq.getOpid()));
		this.setNrocheq(String.valueOf(cheq.getNroCheq()));
		this.setLiquido(String.valueOf(cheq.getLiquido()));
		this.setFpago(String.valueOf(cheq.getFpago()));

		if (cheq.getEmitirCheq().equals("N")
				|| cheq.getEmitirCheq().equals("D")
				|| cheq.getEmitirCheq().equals("O")) {
			this.setNopagado("NO");
		} else {
			this.setNopagado("SI");
		}
		
		
		this.setDep_r("0");
		this.setDisNombre_r(cheq.getNombreDistrito());
		this.setTor_r(" ");
		this.setEscu_r(String.valueOf(cheq.getNumero()));
		this.setDisNro_r(String.valueOf(cheq.getDistrito()));
		this.setItem(String.valueOf(cheq.getItem()));
		this.setApartado(String.valueOf(cheq.getApart()));
		if (revista == null)
			this.setRev(cheq.getCaracRevOpago());
		else
			this.setRev(revista.getDescr());
	}

	public DetChequeDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDopag() {
		return dopag;
	}

	public void setDopag(String dopag) {
		this.dopag = dopag;
	}

	public String getApellidoNombre() {
		return apellidoNombre;
	}

	public void setApellidoNombre(String apellidoNombre) {
		this.apellidoNombre = apellidoNombre;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getNrocheq() {
		return nrocheq;
	}

	public void setNrocheq(String nrocheq) {
		this.nrocheq = nrocheq;
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

	public String getInasistencias() {
		return inasistencias;
	}

	public void setInasistencias(String inasistencias) {
		this.inasistencias = inasistencias;
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

	public String getFechaAfec() {
		return fechaAfec;
	}

	public void setFechaAfec(String fechaAfec) {
		this.fechaAfec = fechaAfec;
	}

	public String getCuitCuil() {
		return cuitCuil;
	}

	public void setCuitCuil(String cuitCuil) {
		this.cuitCuil = cuitCuil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getOpid() {
		return opid;
	}

	public void setOpid(String opid) {
		this.opid = opid;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getApartado() {
		return apartado;
	}

	public void setApartado(String apartado) {
		this.apartado = apartado;
	}

	public String getNopagado() {
		return nopagado;
	}

	public void setNopagado(String nopagado) {
		this.nopagado = nopagado;
	}

	public String getDep_r() {
		return dep_r;
	}

	public void setDep_r(String dep_r) {
		this.dep_r = dep_r;
	}

	public String getDisNombre_r() {
		return disNombre_r;
	}

	public void setDisNombre_r(String disNombre_r) {
		this.disNombre_r = disNombre_r;
	}

	public String getDisNro_r() {
		return disNro_r;
	}

	public void setDisNro_r(String disNro_r) {
		this.disNro_r = disNro_r;
	}

	public String getTor_r() {
		return tor_r;
	}

	public void setTor_r(String tor_r) {
		this.tor_r = tor_r;
	}

	public String getEscu_r() {
		return escu_r;
	}

	public void setEscu_r(String escu_r) {
		this.escu_r = escu_r;
	}

	public String getRural_r() {
		return rural_r;
	}

	public void setRural_r(String rural_r) {
		this.rural_r = rural_r;
	}

	public String getCaracteristicas_r() {
		return caracteristicas_r;
	}

	public void setCaracteristicas_r(String caracteristicas_r) {
		this.caracteristicas_r = caracteristicas_r;
	}

	public String getSecciones_r() {
		return secciones_r;
	}

	public void setSecciones_r(String secciones_r) {
		this.secciones_r = secciones_r;
	}

	public String getTurnos_r() {
		return turnos_r;
	}

	public void setTurnos_r(String turnos_r) {
		this.turnos_r = turnos_r;
	}

	public String getHs_r() {
		return hs_r;
	}

	public void setHs_r(String hs_r) {
		this.hs_r = hs_r;
	}

	public String getDobleEscolaridadEstab_r() {
		return dobleEscolaridadEstab_r;
	}

	public void setDobleEscolaridadEstab_r(String dobleEscolaridadEstab_r) {
		this.dobleEscolaridadEstab_r = dobleEscolaridadEstab_r;
	}

	public String getSubvencion_r() {
		return subvencion_r;
	}

	public void setSubvencion_r(String subvencion_r) {
		this.subvencion_r = subvencion_r;
	}

	public String getCategoria_r() {
		return categoria_r;
	}

	public void setCategoria_r(String categoria_r) {
		this.categoria_r = categoria_r;
	}

	public String getCodMov_r() {
		return codMov_r;
	}

	public void setCodMov_r(String codMov_r) {
		this.codMov_r = codMov_r;
	}

	public String getDobleEscolaridadCargo_r() {
		return dobleEscolaridadCargo_r;
	}

	public void setDobleEscolaridadCargo_r(String dobleEscolaridadCargo_r) {
		this.dobleEscolaridadCargo_r = dobleEscolaridadCargo_r;
	}

	public String getDep_i() {
		return dep_i;
	}

	public void setDep_i(String dep_i) {
		this.dep_i = dep_i;
	}

	public String getDisNombre_i() {
		return disNombre_i;
	}

	public void setDisNombre_i(String disNombre_i) {
		this.disNombre_i = disNombre_i;
	}

	public String getDisNro_i() {
		return disNro_i;
	}

	public void setDisNro_i(String disNro_i) {
		this.disNro_i = disNro_i;
	}

	public String getTor_i() {
		return tor_i;
	}

	public void setTor_i(String tor_i) {
		this.tor_i = tor_i;
	}

	public String getEscu_i() {
		return escu_i;
	}

	public void setEscu_i(String escu_i) {
		this.escu_i = escu_i;
	}

	public String getRural_i() {
		return rural_i;
	}

	public void setRural_i(String rural_i) {
		this.rural_i = rural_i;
	}

	public String getSecciones_i() {
		return secciones_i;
	}

	public void setSecciones_i(String secciones_i) {
		this.secciones_i = secciones_i;
	}

	public String getTurnos_i() {
		return turnos_i;
	}

	public void setTurnos_i(String turnos_i) {
		this.turnos_i = turnos_i;
	}

	public String getHs_i() {
		return hs_i;
	}

	public void setHs_i(String hs_i) {
		this.hs_i = hs_i;
	}

	public String getCaracteristicas_i() {
		return caracteristicas_i;
	}

	public void setCaracteristicas_i(String caracteristicas_i) {
		this.caracteristicas_i = caracteristicas_i;
	}

	public String getDobleEscolaridadEstab_i() {
		return dobleEscolaridadEstab_i;
	}

	public void setDobleEscolaridadEstab_i(String dobleEscolaridadEstab_i) {
		this.dobleEscolaridadEstab_i = dobleEscolaridadEstab_i;
	}

	public String getSubvencion_i() {
		return subvencion_i;
	}

	public void setSubvencion_i(String subvencion_i) {
		this.subvencion_i = subvencion_i;
	}

	public String getCategoria_i() {
		return categoria_i;
	}

	public void setCategoria_i(String categoria_i) {
		this.categoria_i = categoria_i;
	}

	public String getCodMov_i() {
		return codMov_i;
	}

	public void setCodMov_i(String codMov_i) {
		this.codMov_i = codMov_i;
	}

	public String getDobleEscolaridadCargo_i() {
		return dobleEscolaridadCargo_i;
	}

	public void setDobleEscolaridadCargo_i(String dobleEscolaridadCargo_i) {
		this.dobleEscolaridadCargo_i = dobleEscolaridadCargo_i;
	}

	public String getDep_a() {
		return dep_a;
	}

	public void setDep_a(String dep_a) {
		this.dep_a = dep_a;
	}

	public String getDisNombre_a() {
		return disNombre_a;
	}

	public void setDisNombre_a(String disNombre_a) {
		this.disNombre_a = disNombre_a;
	}

	public String getDisNro_a() {
		return disNro_a;
	}

	public void setDisNro_a(String disNro_a) {
		this.disNro_a = disNro_a;
	}

	public String getTor_a() {
		return tor_a;
	}

	public void setTor_a(String tor_a) {
		this.tor_a = tor_a;
	}

	public String getEscu_a() {
		return escu_a;
	}

	public void setEscu_a(String escu_a) {
		this.escu_a = escu_a;
	}

	public String getCaracteristicas_a() {
		return caracteristicas_a;
	}

	public void setCaracteristicas_a(String caracteristicas_a) {
		this.caracteristicas_a = caracteristicas_a;
	}

	public String getDobleEscolaridadEstab_a() {
		return dobleEscolaridadEstab_a;
	}

	public void setDobleEscolaridadEstab_a(String dobleEscolaridadEstab_a) {
		this.dobleEscolaridadEstab_a = dobleEscolaridadEstab_a;
	}

	public String getRural_a() {
		return rural_a;
	}

	public void setRural_a(String rural_a) {
		this.rural_a = rural_a;
	}

	public String getSubvencion_a() {
		return subvencion_a;
	}

	public void setSubvencion_a(String subvencion_a) {
		this.subvencion_a = subvencion_a;
	}

	public String getLiquido() {
		return liquido;
	}

	public void setLiquido(String liquido) {
		this.liquido = liquido;
	}

	public String getFpago() {
		return fpago;
	}

	public void setFpago(String fpago) {
		this.fpago = fpago;
	}

}
