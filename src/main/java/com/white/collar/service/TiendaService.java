package com.white.collar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.white.collar.DAO.ICuadroDAO;
import com.white.collar.DAO.ITiendaDAO;
import com.white.collar.model.Cuadro;
import com.white.collar.model.Tienda;

@Service
public class TiendaService implements IServiceTienda {
	
	@Autowired
	private ITiendaDAO tiendaDAO;
	
	@Autowired
	private ICuadroDAO cuadroDAO;
	

	@Override
	public List<Tienda> getTiendas() {
		
		return tiendaDAO.findAll();
	}

	@Override
	public Optional<Tienda> getTiendaId(int id) {
		
		return tiendaDAO.findById(id);
	}

	@Override
	public Tienda agregarTienda(Tienda tienda) {
		
		return tiendaDAO.save(tienda);
	}

	@Override
	public Tienda editar(Tienda tienda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarTienda(int id) {
		tiendaDAO.deleteById(id);
		
	}


	@Override
	public List<Cuadro> getCuadros() {
		
		return cuadroDAO.findAll();
	}

	
	@Override
	public Optional<Cuadro> getCuadroId(int id) {
		return cuadroDAO.findById(id);
	}

	@Override
	public Cuadro agregarCuadro(Cuadro cuadro) {
		// TODO Auto-generated method stub
		return cuadroDAO.save(cuadro);
	}

	@Override
	public Cuadro editar(Cuadro cuadro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCuadro(int id) {
		cuadroDAO.deleteById(id);
		
	}

}
