package com.dgcye.consultaCheques.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class SimpleReportFiller {

	private String reportFileName;

	private JasperReport jasperReport;

	private JasperPrint jasperPrint;



	private Map<String, Object> parameters;

	public SimpleReportFiller() {
		parameters = new HashMap<>();
	}

	public void prepareReport(DataSource dataSource) {
		compileReport();
		fillReport(dataSource);
	}

	public void compileReport() {
		try {
			InputStream reportStream = getClass().getResourceAsStream("/".concat(reportFileName));
			jasperReport = JasperCompileManager.compileReport(reportStream);
			JRSaver.saveObject(jasperReport, reportFileName.replace(".jrxml", ".jasper"));
		} catch (JRException ex) {
			Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void fillReport(DataSource dataSource) {
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
		} catch (JRException | SQLException ex) {
			Logger.getLogger(SimpleReportFiller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public String getReportFileName() {
		return reportFileName;
	}

	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}

	public JasperPrint getJasperPrint() {
		return jasperPrint;
	}

}
