package com.white.collar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import com.white.collar.DAO.ITiendaDAO;
import com.white.collar.model.Cuadro;
import com.white.collar.model.Tienda;
import com.white.collar.service.IServiceTienda;

@org.springframework.stereotype.Controller
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	private IServiceTienda serviceTienda;
	
	
	
	@GetMapping(value = "shops") // Ver todas las tiendas*
	public ResponseEntity<List<Tienda>> allTienda(){
		
		List<Tienda> tiendas = serviceTienda.getTiendas();
		
		return ResponseEntity.ok(tiendas);
	}
	
	
	@GetMapping(value = "shops/{ID}/pictures") // Ver cuadros de una tienda*
	public ResponseEntity<List<Cuadro>> getTiendaCuadrosId(@PathVariable("ID") Integer ID){
		Optional<Tienda> optionalTienda = serviceTienda.getTiendaId(ID);
		
		List<Cuadro> cuadros = serviceTienda.getCuadros();
		List<Cuadro> respuesta = new ArrayList<Cuadro>();
		
		for(Cuadro c: cuadros) {
			
			if(c.getTienda().equals(optionalTienda.get())) { //Comparamos la tienda asociada al cuadro con la tienda 
															//que pasamos por parametro y lo guardamos para listarla 
				respuesta.add(c);
			}
		}
		
		return ResponseEntity.ok(respuesta);
		
	}
	
	
	@PostMapping(value = "shops") // Añadir Tienda*
	public ResponseEntity<Tienda> crearTienda(@RequestBody Tienda tienda){
		
		Tienda newTienda = serviceTienda.agregarTienda(tienda);
		
		return ResponseEntity.ok(newTienda);
	}
	
	@PostMapping(value = "shops/{ID}/pictures") // Añadir cuadro a una tienda*
	public ResponseEntity<Cuadro> crearCuadro(@PathVariable("ID") Integer ID,@RequestBody Cuadro cuadro){
		
		Optional<Tienda> optionalTienda = serviceTienda.getTiendaId(ID);
		
		cuadro.setTienda(optionalTienda.get());
		
		Cuadro newCuadro = serviceTienda.agregarCuadro(cuadro);
		
		return ResponseEntity.ok(newCuadro);
	}

	@DeleteMapping(value = "shops/{ID}/pictures") // Eliminar cuadros de una tienda*
	public ResponseEntity<Void> deleteCuadrosTiendaId(@PathVariable("ID") Integer ID){
		
		Optional<Tienda> optionalTienda = serviceTienda.getTiendaId(ID);
		
		List<Cuadro> cuadros = serviceTienda.getCuadros();
		//List<Cuadro> respuesta = new ArrayList<Cuadro>();
		
		for(Cuadro c: cuadros) {
			
			if(c.getTienda().equals(optionalTienda.get())) { //Comparamos la tienda asociada al cuadro con la tienda que pasamos por parametro y eliminamos los cuadros de esa tienda
				
				System.out.println(c);
				System.out.println(c.getId());
				
				serviceTienda.eliminarCuadro(c.getId());
			}
		}
		
		
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Tienda> updateTienda(@RequestBody Tienda tienda){
		
		Optional<Tienda> optionalTienda = serviceTienda.getTiendaId(tienda.getId());
		
		if(optionalTienda.isPresent()) {
			
			Tienda updateTienda = optionalTienda.get();
			updateTienda.setNombre(tienda.getNombre());
			updateTienda.setCapacidad(tienda.getCapacidad());
			serviceTienda.agregarTienda(updateTienda);
			return ResponseEntity.ok(updateTienda);
		}else {
			return ResponseEntity.noContent().build();
		}
		
		
	}

	
	/*@GetMapping(value = "numero/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tienda> getTiendaId(@PathVariable("id") Integer id){
		
		Optional<Tienda> optionalTienda = serviceTienda.geTiendaId(id);
		
		if(optionalTienda.isPresent()) {
			return ResponseEntity.ok(optionalTienda.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	
	}*/
	
}
