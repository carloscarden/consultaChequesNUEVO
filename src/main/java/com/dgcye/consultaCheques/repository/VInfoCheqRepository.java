package com.dgcye.consultaCheques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.VInfoCheq;

public interface VInfoCheqRepository extends JpaRepository<VInfoCheq, Long>{
	
	List<VInfoCheq> findByDocuAndSecuAndPerOpagoAndMuestra(String documento, Integer secuencia, Integer perOpago, String muestra);
	List<VInfoCheq> findByDocuAndPerOpagoAndMuestra(String documento, Integer perOpago, String muestra);
	VInfoCheq findByDocuAndSecuAndPerOpagoAndFecAfecAndOpidAndNroCheqOrderByPerOpago(String documento, Integer secu, String fecha, Integer fecAfec, Integer opid, Integer nrocheq);

}
