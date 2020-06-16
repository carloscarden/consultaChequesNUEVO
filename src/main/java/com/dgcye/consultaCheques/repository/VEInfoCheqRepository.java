package com.dgcye.consultaCheques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.VEInfoCheq;

public interface VEInfoCheqRepository extends JpaRepository<VEInfoCheq, Long> {
	
	List<VEInfoCheq> findByDocuOrDocuAndPerOpagoAndSecuOrderByPerOpago(String docu, String docu2, int perOpago, int secu);
	List<VEInfoCheq> findByDocuOrDocuAndPerOpagoOrderByPerOpago(String docu, String docu2, int perOpago);
	List<VEInfoCheq> findByDocuAndPerOpagoAndSecuOrderByPerOpago(String docu, int perOpago, int secu);
	List<VEInfoCheq> findByDocuAndPerOpagoOrderByPerOpago(String docu, int perOpago);
	VEInfoCheq findByDocuAndSecuAndOpidAndPerOpagoAndNroCheqAndCargoAndItemAndApartAndNumeroAndCat(String documento, int secu, int opid, String fecha, 
			String nroCheq, String cat,String cargo, String item,String apart,String numero);

}
