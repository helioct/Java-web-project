package com.deloitte.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.deloitte.exception.ResourceNotFoundException;


import com.deloitte.logica.NotaManager;
import com.deloitte.model.Compra;
import com.deloitte.model.Detalles;
import com.deloitte.model.Nota;

import com.deloitte.model.repository.NotaRepository;



@RestController
@RequestMapping("api/v1")
public class NotaController {

	@Autowired
	private NotaRepository notaRespository;

	/**
	 * 
	 * @param CompraID
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/Ticket/{id_compras}")
	public ResponseEntity<NotaManager> getByID(@PathVariable(value = "id_compras") Integer id_compras) throws ResourceNotFoundException {
		
		
		List < Nota >  Notas = notaRespository.findAll();
		
		
		if(Notas.isEmpty()) {
			throw new ResourceNotFoundException("Ticket with "+ id_compras + " does not exists!!!!");
		}else {
		NotaManager notaManager = new NotaManager();
		for(Nota nota : Notas) {
			if(nota.getId_compras().getId_compras() == id_compras) {
				
				notaManager.setId_ticket(nota.getId_ticket());
				notaManager.setId_compras(nota.getId_compras().getId_compras());
				notaManager.setSubtotal(nota.getSubtotal());
				notaManager.setPromocion1(nota.getPromocion1());
				notaManager.setPromocion2(nota.getPromocion2());
				notaManager.setTotal(nota.getTotal());
			}
		}


		
		
		
		return ResponseEntity.ok().body(notaManager);
		}
	}

	
	
	@PostMapping("/Ticket")
    public Nota createNota(@Valid @RequestBody Nota nota) {
        return notaRespository.save(nota);
    }
	
	
}