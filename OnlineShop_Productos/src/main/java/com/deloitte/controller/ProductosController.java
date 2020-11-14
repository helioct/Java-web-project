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
import com.deloitte.logic.ProductoUser;
import com.deloitte.model.Producto;
import com.deloitte.model.repository.ProductoRepository;


@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class ProductosController {

	@Autowired
	private ProductoRepository ProductoRespository;
	

	
	@GetMapping("/Productos")
	public List < Producto > getAllProductos() {
        return ProductoRespository.findAll();
    }
	
	
	@GetMapping("/Productos/{idProducto}")
	public ResponseEntity<Producto> getProductoById(@PathVariable(value = "idProducto") Integer idProducto) throws ResourceNotFoundException {
		
		
		Producto Producto = ProductoRespository.findById(idProducto)
				.orElseThrow(() -> new ResourceNotFoundException("Producto "+ idProducto + " does not exists!!!!"));
		
		return ResponseEntity.ok().body(Producto);
	}
	
	
	
	
	
	@GetMapping("/ProductosUser/{descripcion}")
	public ResponseEntity<ProductoUser> getByDescripcion(@PathVariable(value = "descripcion") String descripcion) throws ResourceNotFoundException {
		
		
		Producto Producto = ProductoRespository.getByDescripcion(descripcion);
		if(Producto == null) {
			throw new ResourceNotFoundException("Producto "+ descripcion + " does not exists!!!!");
		}
		ProductoUser userProducto = new ProductoUser();
		userProducto.setDescripcion(Producto.getDescripccion());
		userProducto.setCategoria(Producto.getCategoria().getDescripcion());
		userProducto.setPrecio(Producto.getPrecio());
		
		
		
		return ResponseEntity.ok().body(userProducto);
	}
	
	
	@PostMapping("/Productos")
    public Producto createProducto(@Valid @RequestBody Producto Producto) {
        return ProductoRespository.save(Producto);
    }
	
	
	
	@PutMapping("/Productos/{idUsers}")
    public ResponseEntity < Producto > updateProducto(@PathVariable(value = "idUsers") Integer ProductoId,
        @Valid @RequestBody Producto ProductoDetails) throws ResourceNotFoundException {
        Producto Producto = ProductoRespository.findById(ProductoId)
            .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + ProductoId));

        Producto.setDescripcion(ProductoDetails.getDescripccion());
        Producto.setPrecio(ProductoDetails.getPrecio());
        Producto.setCategoria(ProductoDetails.getCategoria());
        Producto.setExistencia(ProductoDetails.getExistencia());
        Producto.setImage_url(ProductoDetails.getImage_url());
        
        final Producto updatedProducto = ProductoRespository.save(Producto);
        return ResponseEntity.ok(updatedProducto);
    }
	
	
	
	@DeleteMapping("/Productos/{idUsers}")
    public Map < String, Boolean > deleteProducto(@PathVariable(value = "idUsers") Integer ProductoId)
    throws ResourceNotFoundException {
        Producto Producto = ProductoRespository.findById(ProductoId)
            .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + ProductoId));

        ProductoRespository.delete(Producto);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
}