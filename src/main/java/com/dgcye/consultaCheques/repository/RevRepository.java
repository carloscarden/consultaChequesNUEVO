package com.dgcye.consultaCheques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Rev;

public interface RevRepository  extends JpaRepository<Rev, Long> {
	
	Rev findByRev(String crev);

}
