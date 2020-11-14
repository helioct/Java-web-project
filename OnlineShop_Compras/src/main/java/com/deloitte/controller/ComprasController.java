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

import com.deloitte.controller.logic.CompraManager;
import com.deloitte.controller.logic.UsuarioManager;
import com.deloitte.exception.ResourceNotFoundException;
import com.deloitte.model.Compra;
import com.deloitte.model.repository.CompraRepository;



@RestController
@RequestMapping("api/v1")
public class ComprasController {

	@Autowired
	private CompraRepository comprasRespository;
	/**
	 * Regresa todas las compras la ocupa el manager
	 * @return
	 */
	
	@GetMapping("/Compras")
	public List < CompraManager> getAllComprass() {
		List<Compra> compras = comprasRespository.findAll();
		List<CompraManager> comprasManager = new LinkedList<CompraManager>();
		
		for(Compra compra : compras) {
			CompraManager compraManager = new CompraManager();
			compraManager.setId_compras(compra.getId_compras());
			compraManager.setUsuarioMail(compra.getUsuario().getMail());
			compraManager.setId_usuario(compra.getUsuario().getId_usuario());
			comprasManager.add(compraManager);
		}
        
		return comprasManager;
    }
	
	/**
	 * Regresa compras por ID, LO USA EL MANAGER
	 * @Param ComprasId
	 * @return compra por ID
	 */
	
	@GetMapping("/Compras/{idCompra}")
	public ResponseEntity<CompraManager> getComprasById(@PathVariable(value = "idCompra") Integer ComprasId) throws ResourceNotFoundException {
		
		
		Compra compra = comprasRespository.findById(ComprasId)
				.orElseThrow(() -> new ResourceNotFoundException("Compras "+ ComprasId + " does not exists!!!!"));
		
		CompraManager compraManager = new CompraManager();
		compraManager.setId_compras(compra.getId_compras());
		compraManager.setUsuarioMail(compra.getUsuario().getMail());
		compraManager.setId_usuario(compra.getUsuario().getId_usuario());
		
		return ResponseEntity.ok().body(compraManager);
	}
	
	/**
	 * Regresa compras por ID del Usuario, LO USA EL MANAGER
	 * @Param ComprasId
	 * @return compra por ID
	 */
	
	@GetMapping("/ComprasIDUser/{idUsuario}")
	public List < CompraManager> getComprasByIdUsuario(@PathVariable(value = "idUsuario") Integer idUsuario) throws ResourceNotFoundException {
		
		List<Compra> compras = comprasRespository.findAll();
		List<CompraManager> comprasManager = new LinkedList<CompraManager>();
		
		for(Compra compra : compras) {
			if(compra.getUsuario().getId_usuario() == idUsuario) {
				CompraManager compraManager = new CompraManager();
				compraManager.setId_compras(compra.getId_compras());
				compraManager.setUsuarioMail(compra.getUsuario().getMail());
				compraManager.setId_usuario(compra.getUsuario().getId_usuario());
				comprasManager.add(compraManager);
			}

		}
        
		return comprasManager;
	}
	
	
	/**
	 * Crear una Compra, la pagina lo usa recibe JSON
	 * @Param Compra
	 * regregresa la compra
	 */
	
	@PostMapping("/Compras")
    public Compra createCompras(@Valid @RequestBody Compra Compras) {
        return comprasRespository.save(Compras);
    }
	
	/**
	 * Actualiza Pagina
	 * 
	 */
	
	
	@PutMapping("/Compras/{idUsers}")
    public ResponseEntity < Compra > updateCompras(@PathVariable(value = "idUsers") Integer ComprasId,
        @Valid @RequestBody Compra ComprasDetails) throws ResourceNotFoundException {
        Compra Compras = comprasRespository.findById(ComprasId)
            .orElseThrow(() -> new ResourceNotFoundException("Compras not found for this id :: " + ComprasId));
        
        Compras.setUsuario(ComprasDetails.getUsuario());
        
        final Compra updatedCompras = comprasRespository.save(Compras);
        return ResponseEntity.ok(updatedCompras);
    }
	
	
	/**
	 * Borra Compra
	 * 
	 */
	@DeleteMapping("/Compras/{idUsers}")
    public Map < String, Boolean > deleteCompras(@PathVariable(value = "idUsers") Integer ComprasId)
    throws ResourceNotFoundException {
        Compra Compras = comprasRespository.findById(ComprasId)
            .orElseThrow(() -> new ResourceNotFoundException("Compras not found for this id :: " + ComprasId));

        comprasRespository.delete(Compras);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
}