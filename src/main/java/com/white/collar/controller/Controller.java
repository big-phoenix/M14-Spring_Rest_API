package com.white.collar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.white.collar.service.IServiceTienda;

@org.springframework.stereotype.Controller
@RequestMapping(value = {"","shops"})
public class Controller {

	/*@Autowired
	private IServiceTienda serviceTienda;
	
	@GetMapping("/")
	public String index(ModelMap modelMap) {
		modelMap.put("tiendas", serviceTienda.getTiendas());
		return "index";
	}
	
	/*@PostMapping("/crear")
	public String create() {
		
	}*/
	
}
