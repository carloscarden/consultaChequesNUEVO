package com.dgcye.consultaCheques.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgcye.consultaCheques.dtos.DatosPersonaDTO;
import com.dgcye.consultaCheques.model.Cambdoc;
import com.dgcye.consultaCheques.model.Ecargo;
import com.dgcye.consultaCheques.model.Pers;
import com.dgcye.consultaCheques.repository.CambDocRepository;
import com.dgcye.consultaCheques.repository.EcargoRepository;
import com.dgcye.consultaCheques.repository.PersRepository;


@Service
public class PersonaService {
	@Autowired
	private PersRepository personaRepository;
	
	@Autowired
	private CambDocRepository cambDocRepository;
	
	@Autowired
	private EcargoRepository ecargoRepository;

	public Boolean verSiHuboCambios(String documento) {
		// TODO Auto-generated method stub
		List<Cambdoc> cambiosEnElDoc = cambDocRepository.findByDocunewAndVigh(documento, new Date());
		if (cambiosEnElDoc.size() == 0) {
			List<Cambdoc> cambiosEnElDocIntermedios = cambDocRepository.findByDocunewAndVighNot(documento, new Date());
			for (int i = 0; i < cambiosEnElDocIntermedios.size(); i++) {
				Cambdoc cdoc = cambiosEnElDocIntermedios.get(i);
				int puntsig = cdoc.getIdcambdoc();

				while (puntsig != 0) {
					cdoc = cambDocRepository.findByIdcambdoc(puntsig);
					puntsig = cdoc.getIdsig();
				}
				if (cdoc != null) {
					return true;
				}
			}

		}
		return false;
	}

	public List<DatosPersonaDTO> mostrarDatosCambiados(String documento) {
		// TODO Auto-generated method stub
		List<DatosPersonaDTO> datosDocusIntermedios = new ArrayList<DatosPersonaDTO>();
		List<Cambdoc> cambiosEnElDoc = cambDocRepository.findByDocunewAndVigh(documento, new Date());
		if (cambiosEnElDoc.size() == 0) {
			List<Cambdoc> cambiosEnElDocIntermedios = cambDocRepository.findByDocunewAndVighNot(documento, new Date());
			for (int i = 0; i < cambiosEnElDocIntermedios.size(); i++) {
				Cambdoc cdoc = cambiosEnElDocIntermedios.get(i);
				int puntsig = cdoc.getIdcambdoc();

				while (puntsig != 0) {
					cdoc = cambDocRepository.findByIdcambdoc(puntsig);
					puntsig = cdoc.getIdsig();
				}
				if (cdoc != null) {
					Pers p = personaRepository.findByDocuAndVigh(cdoc.getDocunew(), new Date());
					DatosPersonaDTO dDto = new DatosPersonaDTO(p);
					datosDocusIntermedios.add(dDto);
				}
			}

		}
		return datosDocusIntermedios;
	}

	public List<DatosPersonaDTO> obtenerPersonas(String apeYnom) {
		// TODO Auto-generated method stub
		List<DatosPersonaDTO> datosPersona = new ArrayList<DatosPersonaDTO>();
		List<Pers> personas = personaRepository.findByNombreLikeOrderByDocuAsc(apeYnom);
		List<Ecargo> ecargos = ecargoRepository.findByApynomLikeOrderByDocuAsc(apeYnom);
		Integer cantidadPersonas = personas.size() ;
		Integer cantidadEcargos = ecargos.size();
		if( (cantidadEcargos+cantidadPersonas) > 100) {
			return null;
		} else {
			cargaDocuYnombrePersonas(datosPersona, personas, ecargos);
			cargarEstabPorDocumento(datosPersona);
		}
		
		return datosPersona;
	}

	private void cargarEstabPorDocumento(List<DatosPersonaDTO> datosPersona) {
		// TODO Auto-generated method stub
		
	}

	private void cargaDocuYnombrePersonas(List<DatosPersonaDTO> datosPersona, List<Pers> personas,
			List<Ecargo> ecargos) {
		// TODO Auto-generated method stub
		Vector vdocumento = new Vector();
		for (Pers p : personas) {
			DatosPersonaDTO dp = new DatosPersonaDTO(p);
			vdocumento.addElement(p.getDocu());
			datosPersona.add(dp);
		}

		for (Ecargo e: ecargos) {
			String documento = e.getDocu();
			DatosPersonaDTO dp = new DatosPersonaDTO();
			dp.setApellido(e.getApynom());
			dp.setDocumento(documento);
			if (documento.startsWith("0")) {
				String documentof = "F";
				documentof = documentof + e.getDocu().substring(1, 8);

				String documentom = "M";
				documentom = documentom + e.getDocu().substring(1, 8);

				if (!vdocumento.contains(documentof)
						&& !vdocumento.contains(documentom))
					datosPersona.add(dp);
			} else {
				if (!vdocumento.contains(documento))
					datosPersona.add(dp);
			}
		}
		
	}

}
