package com.dgcye.consultaCheques.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Pers;

public interface PersRepository  extends JpaRepository<Pers, Long>{
	
	Pers findByDocuAndVigh(String documento, Date vigh);
	
	List<Pers> findByNombreLikeOrderByDocuAsc(String nombre);

}
