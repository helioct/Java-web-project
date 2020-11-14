package com.deloitte.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.Producto;

@Repository
	public interface ProductoRepository extends JpaRepository<Producto, Integer>{
		public Producto getByDescripcion(String descripcion);
	}

