package com.deloitte.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.exception.ResourceNotFoundException;
import com.deloitte.model.Categoria;
import com.deloitte.model.repository.CategoriaRepository;


@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRespository;
	

	
	@GetMapping("/Categorias")
	public List < Categoria > getAllCategorias() {
        return categoriaRespository.findAll();
    }
	
	
	@GetMapping("/Categorias/{idUsers}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value = "idUsers") Integer CategoriaId) throws ResourceNotFoundException {
		
		
		Categoria Categoria = categoriaRespository.findById(CategoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria "+ CategoriaId + " does not exists!!!!"));
		
		return ResponseEntity.ok().body(Categoria);
	}
	
	@PostMapping("/Categorias")
    public Categoria createCategoria(@Valid @RequestBody Categoria Categoria) {
        return categoriaRespository.save(Categoria);
    }
	
	@PutMapping("/Categorias/{idUsers}")
    public ResponseEntity < Categoria > updateCategoria(@PathVariable(value = "idUsers") Integer CategoriaId,
        @Valid @RequestBody Categoria CategoriaDetails) throws ResourceNotFoundException {
        Categoria Categoria = categoriaRespository.findById(CategoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + CategoriaId));

        Categoria.setDescripcion(CategoriaDetails.getDescripcion());
        
        final Categoria updatedCategoria = categoriaRespository.save(Categoria);
        return ResponseEntity.ok(updatedCategoria);
    }
	
	@DeleteMapping("/Categorias/{idUsers}")
    public Map < String, Boolean > deleteCategoria(@PathVariable(value = "idUsers") Integer CategoriaId)
    throws ResourceNotFoundException {
        Categoria Categoria = categoriaRespository.findById(CategoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + CategoriaId));

        categoriaRespository.delete(Categoria);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
}