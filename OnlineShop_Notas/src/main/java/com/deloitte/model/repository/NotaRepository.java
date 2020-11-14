package com.deloitte.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.deloitte.model.Nota;


    @Repository
	public interface NotaRepository extends JpaRepository<Nota, Integer>{



		
	}

