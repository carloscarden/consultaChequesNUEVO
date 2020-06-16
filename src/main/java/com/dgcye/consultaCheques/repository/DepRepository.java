package com.dgcye.consultaCheques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Dep;

public interface DepRepository extends JpaRepository<Dep, Long>{
	
	Dep findByDep(int dependencia);

}
