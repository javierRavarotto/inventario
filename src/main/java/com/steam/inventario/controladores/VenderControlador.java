package com.steam.inventario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.steam.inventario.entidades.Compra;
import com.steam.inventario.entidades.Item;
import com.steam.inventario.entidades.Usuario;
import com.steam.inventario.repositorios.CompraRepositorio;
import com.steam.inventario.repositorios.ItemRepositorio;
import com.steam.inventario.repositorios.UsuarioRepositorio;
import com.steam.inventario.repositorios.VentaRepositorio;
import com.steam.inventario.servicios.CompraServicio;
import com.steam.inventario.servicios.ItemServicio;
import com.steam.inventario.servicios.UsuarioServicio;
import com.steam.inventario.servicios.VentaServicio;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/vender")
public class VenderControlador {
	
	@Autowired
	ItemRepositorio itemRepositorio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	CompraRepositorio compraRepositorio;
	
	@Autowired
	VentaRepositorio ventaRepositorio;
	
	@Autowired
	ItemServicio itemServicio;
	
	@Autowired
	VentaServicio ventaServicio;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	CompraServicio compraServicio;
	
	@GetMapping("/{id}")
	public ModelAndView crear(ModelMap model,@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("venta/venta");
			Compra compra = compraServicio.buscarId(id);
			Item item = compra.getItem();
			Usuario usuarios = compra.getUsuario();
			model.put("compra",compra);
			model.put("item",item);
		model.put("usuarios",usuarios);
		return mav;
	}
	
	@PostMapping("/crearVenta")
	public RedirectView crearVentaMetodoPost(Model modelo,RedirectAttributes mensaje, @RequestParam Integer cantidad,
			@RequestParam Float precio, @RequestParam String pagina, Integer idCompra) 
			throws ErrorServicio{
		RedirectView rv = new RedirectView();
		try {
			
			
			String msn = ventaServicio.crearVenta( cantidad,precio,pagina,idCompra);
		
			mensaje.addFlashAttribute("mensaje", msn);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
		}
		
		rv.setUrl("/");
		return rv;
	}
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("compra/listaCompra");
		return mav;
	}
	

}
