package com.deloitte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "detalles")
public class Detalles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="id_detalles", nullable =false )
	private int id_detalles;
	
	
	@ManyToOne()
    @JoinColumn(name="id_compras", referencedColumnName = "id_compras")
	private Compra compra;
	
	@ManyToOne()
    @JoinColumn(name="id_productos", referencedColumnName = "id_productos")
	private Producto producto;
	
	@Column( name="cantidad", nullable =false )
	private int cantidad;
	
	
	
	
	
	public Detalles() {
		
	}
	
	public Detalles(int id_detalles, Compra compra, Producto producto, int cantidad) {
		super();
		this.id_detalles = id_detalles;
		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	
	
	public int getId_detalles() {
		return id_detalles;
	}
	public void setId_detalles(int id_detalles) {
		this.id_detalles = id_detalles;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
