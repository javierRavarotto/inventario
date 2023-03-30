package com.steam.inventario.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steam.inventario.entidades.Compra;
import com.steam.inventario.entidades.Inventario;
import com.steam.inventario.entidades.Item;
import com.steam.inventario.entidades.ItemCompra;
import com.steam.inventario.entidades.Usuario;
import com.steam.inventario.repositorios.CompraRepositorio;
import com.steam.inventario.repositorios.InventarioRepositorio;
import com.steam.inventario.repositorios.ItemRepositorio;
import com.steam.inventario.repositorios.UsuarioRepositorio;

import errorServicio.ErrorServicio;

@Service
public class CompraServicio {
	
	@Autowired
	CompraRepositorio compraRepositorio;

	@Autowired
	ItemRepositorio itemRepositorio;
	
	@Autowired
	InventarioRepositorio inventarioRepositorio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	InventarioServicio inventarioServicio;
	
	@Autowired
	ItemCompraServicio itemCompraServicio;
	
	public Compra buscarId(Integer id) {
		Compra compra = compraRepositorio.findById(id).get();
		return compra;
	}
	
	@Transactional
	public void crearCompra(Integer cantidad,Float precio,String pagina,Integer idItem, Integer idUsuario) throws ErrorServicio {
		try {
			Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
			Inventario inventario= inventarioRepositorio.findById(idUsuario).get();
			Item item = itemRepositorio.findById(idItem).get();
			float ganaciaTotal= (float) 0;
			Compra compra = new Compra();
			compra.setCantidad(cantidad);
			compra.setPrecio(precio);
			compra.setPagina(pagina);
			compra.setTotalCompra(precio*cantidad);
			compra.setItem(item);
			compra.setUsuario(usuario);
			compra.setGanacia(ganaciaTotal);
			compra.setAlta(true);
			compra.setFechaCreacion(new Date());
			compraRepositorio.save(compra);		
		
			ItemCompra itemCompra = itemCompraServicio.crearItemCompra(item,cantidad);
			inventario.getItemsCompra().add(itemCompra);
			inventarioRepositorio.save(inventario);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

}
