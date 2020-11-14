package com.deloitte.logic;

public class InfoUsuarioManager {
	private int id_usuarios;
	private String name;
	private String lastname;
	private String mail;
	private double monedero;
	private int usuario_tipo;
	
	
	public InfoUsuarioManager() {
		
	}
	
	
	
	public int getId_usuarios() {
		return id_usuarios;
	}



	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public int getUsuario_tipo() {
		return usuario_tipo;
	}

	public void setUsuario_tipo(int usuario_tipo) {
		this.usuario_tipo = usuario_tipo;
	}
	
	
	

}
