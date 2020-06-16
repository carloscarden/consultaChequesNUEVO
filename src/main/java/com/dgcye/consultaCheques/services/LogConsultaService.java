package com.dgcye.consultaCheques.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgcye.consultaCheques.dtos.LogConsultaChequesDTO;
import com.dgcye.consultaCheques.model.Logconsultacheques;
import com.dgcye.consultaCheques.repository.LogConsultaChequesRepository;


@Service
public class LogConsultaService {
	
	@Autowired
	private LogConsultaChequesRepository logRepository;

	public LogConsultaChequesDTO save(LogConsultaChequesDTO log) {
		// TODO Auto-generated method stub
		Logconsultacheques logNuevo = new Logconsultacheques();
		logNuevo.setDocuConsulta(log.getDocuConsulta());
		logNuevo.setEjercicioConsulta(log.getEjercicioConsulta());
		logNuevo.setSecuConsulta(log.getSecuConsulta());
		logNuevo.setFechaConsulta(new Date());
		logNuevo.setUsuario(log.getUsuario());
		logRepository.save(logNuevo);
		return log;
	}

}
