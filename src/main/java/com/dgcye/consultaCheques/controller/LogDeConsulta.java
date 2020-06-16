package com.dgcye.consultaCheques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgcye.consultaCheques.dtos.LogConsultaChequesDTO;
import com.dgcye.consultaCheques.services.LogConsultaService;


@RestController
public class LogDeConsulta {
	@Autowired
	private LogConsultaService logService;
	
	@PostMapping("/log/crearConsulta")
    public ResponseEntity<LogConsultaChequesDTO> nuevaConsulta(@RequestBody LogConsultaChequesDTO log) {
		/**
		 * Para cada consulta de cheques
		 */
		LogConsultaChequesDTO nuevoLog= logService.save(log);
    	if(nuevoLog!=null) {
    		return ResponseEntity.ok().body(nuevoLog);
    	}else {
    		return ResponseEntity.badRequest().build();
    	}
    }

}
