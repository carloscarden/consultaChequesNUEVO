package com.dgcye.consultaCheques.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dgcye.consultaCheques.dtos.DatosPersonaDTO;
import com.dgcye.consultaCheques.services.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	
	@GetMapping("/persona/huboCambios/{documento}")
    public ResponseEntity<Boolean> verSiHuboCambios(
    		@PathVariable(value = "documento") String documento) {
		/**
		 * Para saber si la persona tuvo cambios en su documento
		 */
		Boolean huboCambios = personaService.verSiHuboCambios(documento);
		return ResponseEntity.ok().body(huboCambios);
	}
	
	
	@GetMapping("/persona/mostrarDatosCambiados/{documento}")
    public ResponseEntity<List<DatosPersonaDTO>> mostrarDatosCambiados(
    		@PathVariable(value = "documento") String documento) {
		/**
		 * Muestra todas las veces que la persona tuvo un 
		 * cambio de documento
		 */
		List<DatosPersonaDTO> datosPersona = personaService.mostrarDatosCambiados(documento);
		if (datosPersona == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(datosPersona);
		}
	}
	
	
	@GetMapping("/persona/obtenerPersonas/{apeYnom}")
    public ResponseEntity<List<DatosPersonaDTO>> obtenerPersonas(
    		@PathVariable(value = "apeYnom") String apeYnom) {
		/**
		 * Muestra todas las personas buscadas por apeYnom
		 * con sus datos del establecimiento
		 */
		List<DatosPersonaDTO> datosPersona = personaService.obtenerPersonas(apeYnom);
		if (datosPersona == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(datosPersona);
		}
	}

}
