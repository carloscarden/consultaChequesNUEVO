package com.dgcye.consultaCheques.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgcye.consultaCheques.dtos.CambDocPerDTO;
import com.dgcye.consultaCheques.dtos.ChequesParaImprimirDTO;
import com.dgcye.consultaCheques.dtos.DetChequeDTO;
import com.dgcye.consultaCheques.dtos.DetCodigoDTO;
import com.dgcye.consultaCheques.dtos.DetPeriodoDTO;
import com.dgcye.consultaCheques.model.Cambdoc;
import com.dgcye.consultaCheques.model.Dep;
import com.dgcye.consultaCheques.model.Estab;
import com.dgcye.consultaCheques.model.Org;
import com.dgcye.consultaCheques.model.Rev;
import com.dgcye.consultaCheques.model.VDetalle;
import com.dgcye.consultaCheques.model.VEDetalle;
import com.dgcye.consultaCheques.model.VEInfoCheq;
import com.dgcye.consultaCheques.model.VInfoCheq;
import com.dgcye.consultaCheques.repository.CambDocRepository;
import com.dgcye.consultaCheques.repository.DepRepository;
import com.dgcye.consultaCheques.repository.EstabRepository;
import com.dgcye.consultaCheques.repository.OrgRepository;
import com.dgcye.consultaCheques.repository.RevRepository;
import com.dgcye.consultaCheques.repository.VDetalleRepository;
import com.dgcye.consultaCheques.repository.VEDetalleRepository;
import com.dgcye.consultaCheques.repository.VEInfoCheqRepository;
import com.dgcye.consultaCheques.repository.VInfoCheqRepository;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

@Service
public class ChequeService {
	@Autowired
	private DepRepository depRepository;

	@Autowired
	private VInfoCheqRepository vInfoCheqRepository;

	@Autowired
	private OrgRepository orgRepository;

	@Autowired
	private VEInfoCheqRepository vEInfoCheqRepository;

	@Autowired
	private CambDocRepository cambDocRepository;

	@Autowired
	private EstabRepository estabRepository;

	@Autowired
	private VDetalleRepository vDetalleRepository;

	@Autowired
	private RevRepository revRepository;

	@Autowired
	private VEDetalleRepository vEDetalleRepository;

	public List<DetPeriodoDTO> obtenerCheque(String documento, String secuencia, Integer desde, Boolean checkCd) {
		// TODO Auto-generated method stub
		List<CambDocPerDTO> vcdoc = new ArrayList<CambDocPerDTO>();
		generarCambDocPer13(documento, desde, checkCd, vcdoc);
		return getCheques(vcdoc, documento, secuencia, desde);

	}

	private List<DetPeriodoDTO> getCheques(List<CambDocPerDTO> vcdoc, String documento, String secuencia, Integer anio) {
		// TODO Auto-generated method stub
		List<VInfoCheq> conjCheques = new ArrayList<VInfoCheq>();
		List<DetPeriodoDTO> detallesCheque = new ArrayList<DetPeriodoDTO>();
		if (anio > 1999) {
			for (CambDocPerDTO cdp : vcdoc) {
				if (!secuencia.equals("")) {
					conjCheques = vInfoCheqRepository.findByDocuAndSecuAndPerOpagoAndMuestra(
							cdp.getDocumento().toUpperCase(), Integer.parseInt(secuencia),
							Integer.parseInt(cdp.getPeriodo()), "S");
				} else {
					conjCheques = vInfoCheqRepository.findByDocuAndPerOpagoAndMuestra(cdp.getDocumento().toUpperCase(),
							Integer.parseInt(cdp.getPeriodo()), "S");
				}

				DetPeriodoDTO dp = null;
				for (VInfoCheq cheq : conjCheques) {

					/*
					 * cargo establecimiento interino
					 */
					if (cheq.getEscuidInt() != null) {
						if (cheq.getEscuidCheque() == cheq.getEscuidInt().intValue()) {
							Dep dep = depRepository.findByDep(cheq.getDependenciaInt().intValue());
							Org org = orgRepository.findByOrg(cheq.getTipoOrgInt().toUpperCase());
							dp = new DetPeriodoDTO(cheq, org, dep);
						}
					} else {
						dp = new DetPeriodoDTO(cheq);
					}

					detallesCheque.add(dp);
				}
			}
		} else {
			List<VEInfoCheq> conjECheques = new ArrayList<VEInfoCheq>();
			if ((documento.substring(0, 1).toUpperCase().equals("F"))
					|| (documento.substring(0, 1).toUpperCase().equals("M")))
				if (!secuencia.equals("")) {
					/* order by peropago and secu */
					conjECheques = vEInfoCheqRepository.findByDocuOrDocuAndPerOpagoAndSecuOrderByPerOpago(
							documento.toUpperCase(), "0" + documento.substring(1, 8), anio,
							Integer.parseInt(secuencia));
				} else {
					/* order by peropago and secu */
					conjECheques = vEInfoCheqRepository.findByDocuOrDocuAndPerOpagoOrderByPerOpago(
							documento.toUpperCase(), "0" + documento.substring(1, 8), anio);
				}
			else {
				if (!secuencia.equals("")) {
					/* order by peropago orderby secu */
					conjECheques = vEInfoCheqRepository.findByDocuAndPerOpagoAndSecuOrderByPerOpago(
							documento.toUpperCase(), anio, Integer.parseInt(secuencia));
				} else {
					/* order by peropago orderby secu */
					conjECheques = vEInfoCheqRepository.findByDocuAndPerOpagoOrderByPerOpago(documento.toUpperCase(),
anio);
				}
			}

			for (VEInfoCheq cheq : conjECheques) {
				DetPeriodoDTO dp = new DetPeriodoDTO(cheq);
				detallesCheque.add(dp);
			}

		}
		return detallesCheque;

	}

	private void generarCambDocPer13(String documento, Integer desde, Boolean checkCd, List<CambDocPerDTO> vcdoc) {
		// TODO Auto-generated method stub
		List<Cambdoc> cdocfinal = cambDocRepository.findByDocunewAndVigh(documento, new Date());
		if (checkCd) {
			for (int i = 1; i < 13; i++) {
				CambDocPerDTO cdocper = new CambDocPerDTO();
				cdocper.setDocumento(documento);
				NumberFormat nf = NumberFormat.getIntegerInstance();
				nf.setMinimumIntegerDigits(2);
				nf.setMaximumIntegerDigits(2);
				cdocper.setPeriodo(desde + nf.format(new Integer(i)));
				vcdoc.add(cdocper);
			}

		} else {
			/*
			 * caso 1 : encontro el docu. ingresado como fin de la tabla en cambdoc
			 */
			for (int i = 0; i < cdocfinal.size(); i++) {
				Cambdoc cdoc = (Cambdoc) cdocfinal.get(i);
				int puntant = cdoc.getIdcambdoc();
				do {

					for (int j = 1; j < 13; j++) {
						NumberFormat nf = NumberFormat.getIntegerInstance();
						nf.setMinimumIntegerDigits(2);
						nf.setMaximumIntegerDigits(2);

						int fecha = Integer.parseInt(desde + nf.format(new Integer(j)) + "01");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
						int vigd = Integer.parseInt(sdf.format(cdoc.getVigd()));
						int vigh = Integer.parseInt(sdf.format(cdoc.getVigh()));

						// Este IF estaba comentado, es decir siempre trataba de
						// insertarlo en resul
						// a partir de 06/07/2007 lo descomente por un reclamo
						// (24040932) DPP

						// Nueva modificacion a partir de 01/01/2008 para q si o
						// si inserte el documento
						// ingresado , por reclamo (16862324)

						if (documento.equals(cdoc.getDocunew())) {
							CambDocPerDTO cdocper = new CambDocPerDTO();
							cdocper.setDocumento(cdoc.getDocunew());
							cdocper.setPeriodo(String.valueOf(fecha).substring(0, 6));
							if (!vcdoc.contains(cdocper)) {
								vcdoc.add(cdocper);
							}

						} else if ((fecha >= vigd) && (fecha <= vigh)) {
							CambDocPerDTO cdocper = new CambDocPerDTO();
							cdocper.setDocumento(cdoc.getDocunew());
							cdocper.setPeriodo(String.valueOf(fecha).substring(0, 6));
							if (!vcdoc.contains(cdocper)) {
								vcdoc.add(cdocper);
							}
						}
					}
					puntant = cdoc.getIdant();
					cdoc = cambDocRepository.findByIdcambdoc(puntant);

				} while (puntant != 0);
			}

		}

	}

	public List<ChequesParaImprimirDTO> obtenerDetallesChequesParaImprimir(List<DetPeriodoDTO> chequesParaImprimir) {
		// TODO Auto-generated method stub
		List<ChequesParaImprimirDTO> detallesCheques = new ArrayList<ChequesParaImprimirDTO>();
		for (DetPeriodoDTO detPeriodoDTO : chequesParaImprimir) {
			String fecha = detPeriodoDTO.getPeriodo().substring(0, 4) + detPeriodoDTO.getPeriodo().substring(5, 7);
			obtenerDetalleCheque(detPeriodoDTO.getDocumento(), detPeriodoDTO.getSecuencia(), fecha,
					detPeriodoDTO.getFecafec(), detPeriodoDTO.getOpag(), detPeriodoDTO.getNrocheq(),
					detPeriodoDTO.getCat(), detPeriodoDTO.getCargo(), detPeriodoDTO.getItem(), detPeriodoDTO.getApart(),
					detPeriodoDTO.getEscu(), detallesCheques);
		}
		return detallesCheques;
	}

	private void obtenerDetalleCheque(String documento, String secuencia, String fecha, String fecAfec, String opid,
			String nroCheq, String cat, String cargo, String item, String apart, String numero,
			List<ChequesParaImprimirDTO> detallesCheques) {
		// TODO Auto-generated method stub
		DetChequeDTO detalleChequeDTO;
		String anio = fecha.substring(0, 4);
		int fechaAfec;
		if (fecAfec != null)
			fechaAfec = Integer.parseInt(fecAfec);
		else
			fechaAfec = 0;
		int numeroCheque;
		if (nroCheq != null)
			numeroCheque = Integer.parseInt(nroCheq);
		else
			numeroCheque = 0;

		int ordenPago = Integer.parseInt(opid);
		int secu = Integer.parseInt(secuencia);

		if (Integer.parseInt(anio) > 1999) {
			/* order by peropago, secu, fecafec */
			VInfoCheq cheq = vInfoCheqRepository.findByDocuAndSecuAndPerOpagoAndFecAfecAndOpidAndNroCheqOrderByPerOpago(
					documento, secu, fecha, fechaAfec, ordenPago, numeroCheque);

			if ((cheq.getEscuidInt() != null) && (cheq.getEscuidEscart() != null)) {
				Dep dep = depRepository.findByDep(cheq.getDependenciaInt().intValue());
				Org org = orgRepository.findByOrg(cheq.getTipoOrgInt());
				Estab estab = estabRepository.findByEscuid(cheq.getEscuidEscart().intValue());
				detalleChequeDTO = new DetChequeDTO(cheq, dep, org, estab);
			} else if (cheq.getEscuidInt() != null) {
				Dep dep = depRepository.findByDep(cheq.getDependenciaInt().intValue());
				Org org = orgRepository.findByOrg(cheq.getTipoOrgInt());
				detalleChequeDTO = new DetChequeDTO(cheq, dep, org);
			} else if (cheq.getEscuidEscart() != null) {
				Estab estab = estabRepository.findByEscuid(cheq.getEscuidEscart().intValue());
				detalleChequeDTO = new DetChequeDTO(cheq, estab);
			} else {
				detalleChequeDTO = new DetChequeDTO(cheq);
			}

			List<VDetalle> dets = vDetalleRepository.findByLiqid(cheq.getLiqid());
			if (dets.size() == 0) {
				ChequesParaImprimirDTO cpi = new ChequesParaImprimirDTO();
				cpi.setCodigosCheque(null);
				cpi.setDetalleCheque(detalleChequeDTO);
				detallesCheques.add(cpi);
			}
			for (VDetalle edet : dets) {
				if (Integer.parseInt(edet.getCodigo()) < 3000) {
					DetCodigoDTO dcod = new DetCodigoDTO();
					dcod.setCodigo(edet.getBod() + edet.getCodigo());
					dcod.setDescripcion(edet.getDescripcioncodigo());
					dcod.setImporte(String.valueOf(edet.getPesos()));
					ChequesParaImprimirDTO cpi = new ChequesParaImprimirDTO();
					cpi.setCodigosCheque(dcod);
					cpi.setDetalleCheque(detalleChequeDTO);
					detallesCheques.add(cpi);
				}
			}

		} else {
			VEInfoCheq cheq = vEInfoCheqRepository
					.findByDocuAndSecuAndOpidAndPerOpagoAndNroCheqAndCargoAndItemAndApartAndNumeroAndCat(documento,
							secu, ordenPago, fecha, nroCheq, cat, cargo, item, apart, numero);

			Rev rev = revRepository.findByRev(cheq.getCaracRevOpago().toString().toUpperCase());
			detalleChequeDTO = new DetChequeDTO(cheq, rev);
			/*
			 * cargo codigos e importes del cheque
			 */

			List<VEDetalle> det = vEDetalleRepository.findByEliqidAndPeriodo(cheq.getLiqid(), cheq.getPerOpago());
			if (det.size() == 0) {
				ChequesParaImprimirDTO cpi = new ChequesParaImprimirDTO();
				cpi.setCodigosCheque(null);
				cpi.setDetalleCheque(detalleChequeDTO);
				detallesCheques.add(cpi);
			}

			for (int i = 0; i < det.size(); i++) {
				VEDetalle edet = (VEDetalle) det.get(i);
				if (Integer.parseInt(edet.getCodigo()) < 3000) {
					DetCodigoDTO dcod = new DetCodigoDTO();
					dcod.setCodigo(edet.getBod() + edet.getCodigo());
					dcod.setDescripcion(edet.getDescripcioncodigo());
					dcod.setImporte(String.valueOf(edet.getPesos()));
					ChequesParaImprimirDTO cpi = new ChequesParaImprimirDTO();
					cpi.setCodigosCheque(dcod);
					cpi.setDetalleCheque(detalleChequeDTO);
					detallesCheques.add(cpi);

				}
			}
		}

	}

}
