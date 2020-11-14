package com.deloitte.controller.logic;



public class UsuarioManager {
	

	private int id_usuarios;
	private String name;
	private String lastname;
	private String mail;
	private double monedero;
	private int usuario_tipo;
	
	public UsuarioManager() {}
	



	public UsuarioManager(int id_usuarios, String name, String lastname, String mail, double monedero,
			int usuario_tipo) {
		super();
		this.id_usuarios = id_usuarios;
		this.name = name;
		this.lastname = lastname;
		this.mail = mail;
		this.monedero = monedero;
		this.usuario_tipo = usuario_tipo;
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