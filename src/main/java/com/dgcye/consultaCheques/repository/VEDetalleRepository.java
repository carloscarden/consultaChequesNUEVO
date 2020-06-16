package com.dgcye.consultaCheques.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.VEDetalle;

public interface VEDetalleRepository extends JpaRepository<VEDetalle, Long> {
	
	List<VEDetalle> findByEliqidAndPeriodo(int liqid, int periodo);
	

}
