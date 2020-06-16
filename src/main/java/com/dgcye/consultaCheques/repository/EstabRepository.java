package com.dgcye.consultaCheques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Estab;

public interface EstabRepository extends JpaRepository<Estab, Long>{
	
	Estab findByEscuid(int escuid);

}
