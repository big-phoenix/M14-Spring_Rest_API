package com.white.collar.model;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cuadro")
public class Cuadro {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String autor;
	private float precio;
	
	@OneToOne
	@JoinColumn(name = "tienda_id", unique = true)
	private Tienda tienda;
	
	
	public Cuadro() {
		
	}


	public Cuadro(int id, String nombre, String autor, float precio, Tienda tienda) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
		this.tienda = tienda;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public Tienda getTienda() {
		return tienda;
	}


	public void setTienda(Tienda tienda) {
		this.tienda =  tienda;
	}
	
	
	
	

}
