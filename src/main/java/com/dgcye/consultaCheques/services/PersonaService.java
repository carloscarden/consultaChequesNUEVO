package com.dgcye.consultaCheques.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgcye.consultaCheques.dtos.DatosPersonaDTO;
import com.dgcye.consultaCheques.model.Cambdoc;
import com.dgcye.consultaCheques.model.DatosAdicionalesPers;
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
		LocalDate localDate = LocalDate.of(9999, 1, 1);
		java.util.Date date = java.sql.Date.valueOf(localDate);
		List<Cambdoc> cambiosEnElDoc = cambDocRepository.findByDocunewAndVigh(documento, date);
		if (cambiosEnElDoc.size() == 0) {
			
			List<Cambdoc> cambiosEnElDocIntermedios = cambDocRepository.findByDocunewAndVighNot(documento, date);
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
		LocalDate localDate = LocalDate.of(9999, 12, 1);
		java.util.Date date = java.sql.Date.valueOf(localDate);
		List<Cambdoc> cambiosEnElDoc = cambDocRepository.findByDocunewAndVigh(documento, date);
		if (cambiosEnElDoc.size() == 0) {
			List<Cambdoc> cambiosEnElDocIntermedios = cambDocRepository.findByDocunewAndVighNot(documento, date);
			for (int i = 0; i < cambiosEnElDocIntermedios.size(); i++) {
				Cambdoc cdoc = cambiosEnElDocIntermedios.get(i);
				int puntsig = cdoc.getIdcambdoc();

				while (puntsig != 0) {
					cdoc = cambDocRepository.findByIdcambdoc(puntsig);
					puntsig = cdoc.getIdsig();
				}
				if (cdoc != null) {
					Pers p = personaRepository.findByDocuAndVigh(cdoc.getDocunew(), date);
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
		List<Pers> personas = personaRepository.findByNombreLikeOrderByDocuAsc(apeYnom.toUpperCase()+"%");
		List<Ecargo> ecargos = ecargoRepository.findByApynomLikeOrderByDocuAsc(apeYnom.toUpperCase());
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
		/*
		 * "select  *  from (select distinct p.nombre,p.docu, e.dependencia, d.distrito,d.descripcion , e.tipo_org, e.numero, c.reg ,'v' prov"
		+ " from( ((dge.cargo c inner join dge.pers p on c.pin=p.pin)"
		+ " inner join dge.estab e on e.escuid = c.escuid) inner join dge.distrito d on d.distrito = e.distrito)"
		+ " where p.docu = ? and p.vigh = '01/12/9999'  and c.vigh = '01/12/9999'  and e.vigh = '01/12/9999'"
		+ " union "
		+ " select distinct apynom nombre,docu,0 dependencia, dist distrito, d1.descripcion, ' '  tipo_org, escue numero,' ' reg ,   'e' prov"
		+ " from dge.ecargo e1 inner join dge.distrito d1 on d1.distrito = e1.dist where e1.docu = ? ) as tt order by prov desc fetch first 1 rows only";
		 * */
		
		DatosAdicionalesPers datosAdicionalesPers = new DatosAdicionalesPers();
		for(DatosPersonaDTO pers : datosPersona) {
		  // ejecutar query para consultar datos adicionales de la persona
			// pasarle los datos a la persona
		}
		
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
