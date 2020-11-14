package com.deloitte.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.Detalles;



@Repository
	public interface DetallesRepository extends JpaRepository<Detalles, Integer>{
	   

//	   
//		 public List<Detalles> findByIDCompras(@Param("id_compras")  Integer id_compras);
	   
	}

