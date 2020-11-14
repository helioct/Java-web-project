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
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="id_compras", nullable =false )
	private int id_compras;
	
	
	@ManyToOne()
    @JoinColumn(name="id_usuarios", referencedColumnName = "id_usuarios")
	private Usuario id_usuarios;
	
	
	public Compra() {
		
	}
	
	
	public Compra(int id_compras, Usuario usuario) {
		super();
		this.id_compras = id_compras;
		this.id_usuarios = usuario;
	}
	public int getId_compras() {
		return id_compras;
	}
	public void setId_compras(int id_compras) {
		this.id_compras = id_compras;
	}

	public Usuario getUsuario() {
		return id_usuarios;
	}
	public void setUsuario(Usuario usuario) {
		this.id_usuarios = usuario;
	}

	

}
