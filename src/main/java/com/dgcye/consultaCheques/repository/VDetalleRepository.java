package com.dgcye.consultaCheques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.VDetalle;

public interface VDetalleRepository  extends JpaRepository<VDetalle, Long> {
	
	List<VDetalle> findByLiqid(int liqid);

}
