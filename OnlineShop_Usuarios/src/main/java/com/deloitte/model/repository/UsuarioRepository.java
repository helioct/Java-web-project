package com.deloitte.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.model.Usuario;

@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
		public Usuario findByMail(String mail);
		
	}

