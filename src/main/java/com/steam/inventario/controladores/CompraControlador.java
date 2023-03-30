package com.steam.inventario.controladores;

import java.text.DecimalFormat;
import java.util.List;

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

import com.steam.inventario.entidades.Compra;
import com.steam.inventario.entidades.Item;
import com.steam.inventario.entidades.Usuario;
import com.steam.inventario.repositorios.CompraRepositorio;
import com.steam.inventario.repositorios.ItemRepositorio;
import com.steam.inventario.repositorios.UsuarioRepositorio;
import com.steam.inventario.servicios.CompraServicio;
import com.steam.inventario.servicios.ItemServicio;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/compra")
public class CompraControlador {

	@Autowired
	ItemRepositorio itemRepositorio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	CompraRepositorio compraRepositorio;
	
	@Autowired
	ItemServicio itemServicio;
	
	@Autowired
	CompraServicio compraServicio;
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Compra> listaCompra = compraRepositorio.findAll();
		Float total=(float) 0;
		for(Compra compra :listaCompra) {
		    total = compra.getGanacia() + total;
		    }
		String totalDecimal = String.format("%.2f", total);
		modelo.addAttribute("total", totalDecimal);
		modelo.addAttribute("compras", listaCompra);
	}
	
	@GetMapping("/{id}")
	public ModelAndView crear(ModelMap model,@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("compra/compra");
		
			Item item = itemServicio.buscarId(id);
			List<Usuario> usuarios = usuarioRepositorio.findAll(); 
		model.put("item",item);
		model.put("usuarios",usuarios);
		return mav;
	}
	@PostMapping("/crearCompra")
	public RedirectView crearcompraMetodoPost(Model modelo,RedirectAttributes mensaje, @RequestParam Integer cantidad,
			@RequestParam Float precio, @RequestParam String pagina, Integer idItem, Integer idUsuario) 
			throws ErrorServicio{
		RedirectView rv = new RedirectView();
		try {
			
		
			compraServicio.crearCompra( cantidad,precio,pagina,idItem,idUsuario);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
		}
		mensaje.addFlashAttribute("mensaje", "Correcto");
		rv.setUrl("/item/lista");
		return rv;
	}
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("compra/listaCompra");
		return mav;
	}
}
