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
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="id_productos", nullable =false )
	private int id_productos;
	
	@Column( name="descripcion", nullable =false )
	private String descripcion;
	
	@Column( name="precio", nullable =false )
	private double precio;
	
	@ManyToOne()
    @JoinColumn(name="id_categorias", referencedColumnName = "id_categorias")
	private Categoria categoria;
	
	@Column( name="existencia", nullable =false )
	private int existencia;
	
	@Column( name="image_url", nullable =false )
	private String image_url;
	
	public Producto() {
		
	}
	
	
	public Producto(int id_producto, String descripcion, double precio, Categoria categoria, int existencia) {
		super();
		this.id_productos = id_producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.existencia = existencia;
	}
	public int getId_producto() {
		return id_productos;
	}
	public void setId_producto(int id_producto) {
		this.id_productos = id_producto;
	}
	public String getDescripccion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	@Override
	public String toString() {
		return "Producto [id_producto=" + id_productos + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", categoria=" + categoria.toString() + ", existencia=" + existencia + "]";
	}
	
	
	
}
