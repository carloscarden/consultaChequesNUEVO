package com.dgcye.consultaCheques.configReports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JasperReportSimpleConfig {
	
	
	@Bean
	public SimpleReportFiller reportFiller() {
		return new SimpleReportFiller();
	}

}
