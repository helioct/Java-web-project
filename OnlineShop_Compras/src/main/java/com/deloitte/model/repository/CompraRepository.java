package com.deloitte.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.Compra;

@Repository
	public interface CompraRepository extends JpaRepository<Compra, Integer>{

		
	}

