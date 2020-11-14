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
@Table(name = "ticket")
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="id_ticket", nullable =false )
	private int id_ticket;
	
	@ManyToOne()
    @JoinColumn(name="id_compras", referencedColumnName = "id_compras")
	private Compra id_compras;
	
	@Column( name="subtotal", nullable =false )
	private double subtotal;
	
	
	@Column( name="promocion1", nullable =false )
	private double promocion1;
	
	@Column( name="promocion2", nullable =false )
	private double promocion2;
	
	@Column( name="total", nullable =false )
	private double total;
	
	
	public Nota() {
		
	}
	public int getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}
	public Compra getId_compras() {
		return id_compras;
	}
	public void setId_compras(Compra id_compra) {
		this.id_compras = id_compra;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getPromocion1() {
		return promocion1;
	}
	public void setPromocion1(double promocion1) {
		this.promocion1 = promocion1;
	}
	public double getPromocion2() {
		return promocion2;
	}
	public void setPromocion2(double promocion2) {
		this.promocion2 = promocion2;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
