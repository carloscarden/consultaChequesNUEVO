package com.dgcye.consultaCheques.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgcye.consultaCheques.dtos.ChequesParaImprimirDTO;
import com.dgcye.consultaCheques.dtos.DetPeriodoDTO;
import com.dgcye.consultaCheques.services.ChequeService;

@RestController
public class ChequeController {
	
	@Autowired
	private ChequeService chequeService;
	
	
	
	@GetMapping("/cheques/obtenerCheque/documento/{documento}/secuencia/{secuencia}/desde/{desde}/checkCd/{checkCd}")
    public ResponseEntity<List<DetPeriodoDTO>> obtenerCheque(
    		@PathVariable(value = "documento") String documento,
    		@PathVariable(value = "secuencia") String secuencia,
    		@PathVariable(value = "desde") Integer desde,
    		@PathVariable(value = "checkCd") Boolean checkCd) {
		/**
		 * Cheques de la persona
		 */
		List<DetPeriodoDTO> cheques = chequeService.obtenerCheque(documento,secuencia,desde, checkCd);
		if (cheques == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(cheques);
		}
	}
	
	
	@PostMapping("/cheques/obtenerChequesParaImprimir")
    public ResponseEntity<List<ChequesParaImprimirDTO>> obtenerChequesParaImprimir(
    		@RequestBody List<DetPeriodoDTO> chequesParaImprimir) {
		/**
		 * Se imprimira la lista de cheques que quiera la persona
		 */
		List<ChequesParaImprimirDTO> detallesCheques = chequeService.obtenerDetallesChequesParaImprimir(chequesParaImprimir);
		if (detallesCheques == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(detallesCheques);
		}
	}

}