package com.dgcye.consultaCheques.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;

import com.dgcye.consultaCheques.configReports.JasperReportSimpleConfig;
import com.dgcye.consultaCheques.configReports.ReportChequeDS;
import com.dgcye.consultaCheques.configReports.SimpleReportFiller;
import com.dgcye.consultaCheques.dtos.ChequesParaImprimirDTO;
import com.dgcye.consultaCheques.dtos.DetPeriodoDTO;
import com.dgcye.consultaCheques.services.ChequeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@RestController
public class ChequeController {
	
	@Autowired
	private ChequeService chequeService;
	
	
	
	@GetMapping("/cheques/obtenerCheque/documento/{documento}/secuencia/{secuencia}/desde/{desde}/checkCd/{checkCd}")
    public ResponseEntity<List<DetPeriodoDTO>> obtenerCheque(
    		@PathVariable(value = "documento") String documento,
    		@PathVariable(value = "secuencia") String secuencia,
    		@PathVariable(value = "desde") Integer desde,
    		@PathVariable(value = "checkCd") String checkCd) {
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
    public void obtenerChequesParaImprimir(
    		@RequestBody List<DetPeriodoDTO> chequesParaImprimir, HttpServletResponse response) throws IOException, JRException {
		/**
		 * Se imprimira la lista de cheques que quiera la persona
		 */
		List<ChequesParaImprimirDTO> detallesCheques = chequeService.obtenerDetallesChequesParaImprimir(chequesParaImprimir);
		if (detallesCheques != null) {
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	        ctx.register(JasperReportSimpleConfig.class);
	        ctx.refresh();
	        
	        SimpleReportFiller simpleReportFiller = ctx.getBean(SimpleReportFiller.class);
	        simpleReportFiller.setReportFileName("cheques.jrxml");
	        simpleReportFiller.compileReport();
	        
	        ReportChequeDS reportChequeDS = new ReportChequeDS(detallesCheques);
	        simpleReportFiller.fillReport(reportChequeDS);
	        
	        response.setContentType("application/x-download");
	        response.setHeader("Content-Disposition",  "inline; filename=App_report_en.pdf");
	        OutputStream out = response.getOutputStream();

	        JasperExportManager.exportReportToPdfStream(simpleReportFiller.getJasperPrint(), out);
	   
		}
	}

}
