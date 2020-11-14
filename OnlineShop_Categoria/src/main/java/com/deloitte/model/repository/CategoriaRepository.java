package com.deloitte.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.Categoria;

@Repository
	public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

		
	}

