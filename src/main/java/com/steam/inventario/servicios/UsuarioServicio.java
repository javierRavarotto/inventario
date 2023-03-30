package com.steam.inventario.servicios;


import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steam.inventario.entidades.Usuario;
import com.steam.inventario.repositorios.UsuarioRepositorio;

import errorServicio.ErrorServicio;


@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public Usuario buscarId(Integer id) {
		Usuario usuario = usuarioRepositorio.findById(id).get();
		return usuario;
	}
	public Usuario buscarUltimo() {
		Usuario usuario =usuarioRepositorio.buscarUltima();
		return usuario;
	}
	@Transactional
	public void crearUsuario(String nombre,String contrasena,String steam,String foto) throws ErrorServicio,IOException {
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setContrasena(contrasena);
			usuario.setPerfilStema(steam);
			usuario.setAlta(true);
			usuario.setFechaCreacion(new Date()); 
			usuario.setImagen(foto);
			usuarioRepositorio.save(usuario);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
}
