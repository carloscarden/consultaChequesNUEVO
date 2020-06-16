package com.dgcye.consultaCheques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgcye.consultaCheques.model.Org;

public interface OrgRepository extends JpaRepository<Org, Long>{
	Org findByOrg(String org);

}
