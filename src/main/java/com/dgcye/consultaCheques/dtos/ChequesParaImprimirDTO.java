package com.dgcye.consultaCheques.dtos;

public class ChequesParaImprimirDTO {
	public  DetCodigoDTO codigosCheque;
	public DetChequeDTO detalleCheque;
	
	
	
	
	public ChequesParaImprimirDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetCodigoDTO getCodigosCheque() {
		return codigosCheque;
	}
	public void setCodigosCheque(DetCodigoDTO codigosCheque) {
		this.codigosCheque = codigosCheque;
	}
	public DetChequeDTO getDetalleCheque() {
		return detalleCheque;
	}
	public void setDetalleCheque(DetChequeDTO detalleCheque) {
		this.detalleCheque = detalleCheque;
	}
	
	
	
	

}
