package com.steam.inventario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.steam.inventario.entidades.Item;
import com.steam.inventario.repositorios.ItemRepositorio;
import com.steam.inventario.servicios.ItemServicio;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/item")
public class ItemControlador {
	
	@Autowired
	ItemServicio itemServicio;
	
	@Autowired
	ItemRepositorio itemRepositorio;
	
	Boolean	altas=true; 
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Item> listaItem = itemRepositorio.findAll();
		modelo.addAttribute("items", listaItem);
	}
	
	@GetMapping("/crear")
	public ModelAndView crear(ModelMap model) {
		ModelAndView mav = new ModelAndView("item/crearItem");
		return mav;
	}
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("item/listaItem");
		model.put("altas",altas);
		return mav;
	}
	
	
	@PostMapping("/crearItem")
	public RedirectView crearItemMetodoPost(Model modelo,RedirectAttributes mensaje, @RequestParam String nombre,
			@RequestParam String calidad, @RequestParam String foto,@RequestParam(required=false) Boolean startrack) 
			throws ErrorServicio{
		RedirectView rv = new RedirectView();
		try {
			
			itemServicio.crearItem( nombre,calidad,foto,startrack);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
		}
		mensaje.addFlashAttribute("mensaje", "Correcto");
		rv.setUrl("/item/lista");
		return rv;
	}

}
