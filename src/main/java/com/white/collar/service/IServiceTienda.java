package com.white.collar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.white.collar.model.Cuadro;
import com.white.collar.model.Tienda;


public interface IServiceTienda {
	
	public List<Tienda> getTiendas();
	public Optional<Tienda> getTiendaId(int id);
	public Tienda agregarTienda(Tienda tienda);
	public Tienda editar(Tienda tienda);
	public void eliminarTienda(int id);

	public List<Cuadro> getCuadros();
	public Optional<Cuadro> getCuadroId(int id);
	public Cuadro agregarCuadro(Cuadro cuadro);
	public Cuadro editar(Cuadro cuadro);
	public void eliminarCuadro(int id);
	
}
