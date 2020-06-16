package com.dgcye.consultaCheques.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Cambdoc;


public interface CambDocRepository extends JpaRepository<Cambdoc, Long>{
	
	List<Cambdoc> findByDocunewAndVigh(String docunew, Date vigh);
	
	List<Cambdoc> findByDocunewAndVighNot(String docunew, Date vigh);
	
	Cambdoc findByIdcambdoc(int idcambdoc);

}
