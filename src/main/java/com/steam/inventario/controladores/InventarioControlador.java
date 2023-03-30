package com.steam.inventario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.steam.inventario.entidades.Inventario;
import com.steam.inventario.servicios.InventarioServicio;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/inventario")
public class InventarioControlador {

	
	
	@Autowired
	InventarioServicio inventarioServicio;
	

	@PostMapping("/crearInventario")
	public RedirectView crearcompraMetodoPost(ModelMap model,RedirectAttributes mensaje,Integer id) 
			throws ErrorServicio{
		RedirectView rv = new RedirectView();
		try {
			Inventario inventario=inventarioServicio.crearInventario(id);
			
		} catch (ErrorServicio e) {
			model.addAttribute("error", e.getMessage());
			
		}
		mensaje.addFlashAttribute("mensaje", "Correcto");
		rv.setUrl("/usuario/perfil/"+ id);
		return rv;
	}
	
}
