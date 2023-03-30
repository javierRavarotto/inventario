package com.steam.inventario.controladores;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.steam.inventario.entidades.Inventario;
import com.steam.inventario.entidades.ItemCompra;
import com.steam.inventario.entidades.Usuario;
import com.steam.inventario.repositorios.UsuarioRepositorio;
import com.steam.inventario.servicios.InventarioServicio;
import com.steam.inventario.servicios.UsuarioServicio;

import errorServicio.ErrorServicio;



@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	InventarioServicio inventarioServicio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Usuario> listaUsuario = usuarioRepositorio.findAll();
		modelo.addAttribute("usuarios", listaUsuario);
	}

	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("usuario/listaUsuario");
		
		return mav;
	}
	
	@GetMapping("/crear")
	public ModelAndView crear(ModelMap model) {
		ModelAndView mav = new ModelAndView("usuario/crearUsuario");
		return mav;
	}
	
	@PostMapping("/crearUsuario")
	public RedirectView crearAlumnoMetodoPost(Model modelo,RedirectAttributes mensaje, @RequestParam String nombre,
			@RequestParam String contrasena, @RequestParam String foto,String perfilStema) 
			throws ErrorServicio, IOException{
		RedirectView rv = new RedirectView();
		try {
			
			usuarioServicio.crearUsuario(nombre,contrasena,perfilStema,foto);
			
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
		}
		Usuario usuario =usuarioServicio.buscarUltimo();
		Integer id= usuario.getIdUsuario();
		mensaje.addFlashAttribute("mensaje", "Correcto");
		rv.setUrl("/usuario/perfil/"+ id);
		return rv;
	}
	
	
	@GetMapping("/perfil/{id}")
	public ModelAndView perfil(ModelMap model,@PathVariable Integer id) throws ErrorServicio {
		ModelAndView mav = new ModelAndView("usuario/perfilUsuario");
		
		Usuario usuario = usuarioRepositorio.findById(id).get();
		
		model.addAttribute("usuario",usuario);
		
		
		if(usuario.getInventario() != null) {
			Inventario inventario = usuario.getInventario();
			Set<ItemCompra> itemCompra = inventario.getItemsCompra();
			model.addAttribute("itemCompra",itemCompra);
		}else{
			Inventario inventario = inventarioServicio.crearInventario(id);
			model.addAttribute("inventario",inventario);
		}
	
		return mav;
	}	
	
}

