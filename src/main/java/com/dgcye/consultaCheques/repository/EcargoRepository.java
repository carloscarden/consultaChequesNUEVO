package com.dgcye.consultaCheques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Ecargo;

public interface EcargoRepository extends JpaRepository<Ecargo, Long>{
	
	List<Ecargo> findByApynomLikeOrderByDocuAsc(String nombre);

}
