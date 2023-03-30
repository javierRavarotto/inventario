package com.steam.inventario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.steam.inventario.entidades.Item;
import com.steam.inventario.repositorios.ItemRepositorio;



@Controller
@RequestMapping("/")
public class indexControlador {
	
	Boolean	altas=true; 
	
	@Autowired
	ItemRepositorio itemRepositorio;
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Item> listaItem = itemRepositorio.findAll();
		modelo.addAttribute("items", listaItem);
	}
	
	@GetMapping("/")
	public ModelAndView index(ModelMap model) {
		ModelAndView mav = new ModelAndView("index");
		model.put("altas",altas);
		return mav;
	}
}
