package com.deloitte.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registros_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuarios", nullable = false)
	private int id_usuarios;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "mail", nullable = false)
	private String mail;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "monedero", nullable = false)
	private double monedero;
	
	@Column(name = "usuario_tipo", nullable = false)
	private int usuario_tipo;
	
	public Usuario() {}
	
	public Usuario(int id_usuario, String name, String lastName, String mail, String password, double monedero,
			int tipo) {
		this.name = name;
		this.lastname = lastName;
		this.mail = mail;
		this.password = password;
		this.monedero = monedero;
		this.usuario_tipo = tipo;
	}


	public int getId_usuario() {
		return id_usuarios;
	}


	public void setId_usuario(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastname;
	}


	public void setLastName(String lastName) {
		this.lastname = lastName;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getMonedero() {
		return monedero;
	}


	public void setMonedero(double monedero) {
		this.monedero = monedero;
	}


	public int getTipo() {
		return usuario_tipo;
	}


	public void setTipo(int tipo) {
		this.usuario_tipo = tipo;
	}
	
}