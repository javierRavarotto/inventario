package com.steam.inventario.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steam.inventario.entidades.Inventario;
import com.steam.inventario.entidades.Usuario;
import com.steam.inventario.repositorios.InventarioRepositorio;

import errorServicio.ErrorServicio;

@Service
public class InventarioServicio {

	@Autowired
	InventarioRepositorio inventarioRepositorio;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	public Inventario buscarId(Integer id) {
		Inventario inventario = inventarioRepositorio.findById(id).get();
		return inventario;
	}
	
	@Transactional
	public Inventario crearInventario(Integer id) throws ErrorServicio {
		try {
			
			Inventario inventario = new Inventario();
			Usuario usuario = usuarioServicio.buscarId(id);
			
			inventario.setUsuario(usuario);
			inventario.setAlta(true);
			inventario.setFechaCreacion(new Date()); 
			inventarioRepositorio.save(inventario);
			return inventario;
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
}
