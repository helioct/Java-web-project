package com.deloitte.controller;


import java.util.LinkedList;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.exception.ResourceNotFoundException;
import com.deloitte.logica.DetalleManager;
import com.deloitte.logica.DetalleUsuario;

import com.deloitte.model.Detalles;

import com.deloitte.model.repository.DetallesRepository;

@RestController
@RequestMapping("api/v1")
public class DetallesController {

	@Autowired
	private DetallesRepository detallesRespository;
	

	
//	@GetMapping("/Detalles")
//	public List < Detalles> getAllDetallesss() {
//		
//        return detallesRespository.findAll();
//    }
	
	/**
	 * 
	 * @param CompraID
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/DetallesUsuario/{idCompra}")
	public List < DetalleUsuario >getDetallessById(@PathVariable(value = "idCompra") Integer CompraID) throws ResourceNotFoundException {
		
		
		List < Detalles >  Detalles = detallesRespository.findAll();
		List < DetalleUsuario >  Res = new LinkedList< DetalleUsuario >();
		
		for( Detalles det:Detalles) {
			
			if(det.getCompra().getId_compras() == CompraID) {
				DetalleUsuario detUsuario =  new DetalleUsuario();
				detUsuario.setId_compra(det.getCompra().getId_compras());
				detUsuario.setProducto(det.getProducto().getDescripccion());
				detUsuario.setCantidad(det.getCantidad());
				detUsuario.setPrecioIndividual(det.getProducto().getPrecio());
				detUsuario.setSubTotal();
				
				
				Res.add(detUsuario);
			}
		}
				
		
		return Res;
	}
	/**
	 * 
	 * @param CompraID
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/DetallesManager/{idCompra}")
	public List < DetalleManager >getDetallessByIdManager(@PathVariable(value = "idCompra") Integer CompraID) throws ResourceNotFoundException {
		
		
		List < Detalles >  Detalles = detallesRespository.findAll();
		List < DetalleManager >  Res = new LinkedList< DetalleManager >();
		for( Detalles det:Detalles) {
			
			if(det.getCompra().getId_compras() == CompraID) {
				DetalleManager detManager =  new DetalleManager();
				detManager.setId_detalle(det.getId_detalles());
				detManager.setId_compra(det.getCompra().getId_compras());
				detManager.setId_producto(det.getProducto().getId_producto());
				detManager.setId_categoria(det.getProducto().getCategoria().getId_categorias());
				detManager.setCantidad(det.getCantidad());
				Res.add(detManager);
			}
		}
		return Res;
	}
	
//	/**
//	 * 
//	 * CALCULO DEL TOTAL RECIBO
//	 * @param CompraID
//	 * @return
//	 * @throws ResourceNotFoundException
//	 */
//	@GetMapping("/Recibo/{idCompra}")
//	public List < Recibo >getRecibo(@PathVariable(value = "idCompra") Integer CompraID) throws ResourceNotFoundException {
//		
//		
//		List < Detalles >  Detalles = detallesRespository.findAll();
//		List < DetalleManager >  Res = new LinkedList< DetalleManager >();
//		
//		
//		
//		
//		for( Detalles det:Detalles) {
//			
//			if(det.getCompra().getId_compras() == CompraID) {
//				DetalleManager detManager =  new DetalleManager();
//				detManager.setId_detalle(det.getId_detalles());
//				detManager.setId_compra(det.getCompra().getId_compras());
//				detManager.setId_producto(det.getProducto().getId_producto());
//				detManager.setId_categoria(det.getProducto().getCategoria().getId_categorias());
//				detManager.setCantidad(det.getCantidad());
//				Res.add(detManager);
//			}
//		}
//		return null;
//	}	
	
	
	@PostMapping("/Detalles")
    public Detalles createDetalless(@Valid @RequestBody Detalles Detalless) {
        return detallesRespository.save(Detalless);
    }
	


	
	
	
}