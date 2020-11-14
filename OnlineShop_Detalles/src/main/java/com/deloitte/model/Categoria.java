package com.deloitte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="id_categorias", nullable =false )
	private int id_categorias;
	@Column( name="descripcion", nullable =false )
	private String descripcion;
	
	
	public Categoria() {
		
	}
	public Categoria(int id_categoria, String descripcion) {
		super();
		this.id_categorias = id_categoria;
		this.descripcion = descripcion;
	}
	
	
	public int getId_categorias() {
		return id_categorias;
	}
	
	public void setId_categorias(int id_categoria) {
		this.id_categorias = id_categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Categoria [id_categorias=" + id_categorias + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
