package com.steam.inventario.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steam.inventario.entidades.Item;
import com.steam.inventario.repositorios.ItemRepositorio;

import errorServicio.ErrorServicio;

@Service
public class ItemServicio {
	
	@Autowired
	ItemRepositorio itemRepositorio;
	
	
	public Item buscarId(Integer id) {
		Item item = itemRepositorio.findById(id).get();
			return item;
		}
	
	@Transactional
	public void crearItem(String nombre,String calidad,String foto , Boolean startrack  ) throws ErrorServicio {
		try {
			Item item = new Item();
			item.setNombre(nombre);
			item.setCalidad(calidad);
			if(startrack != null) {
				item.setStartrack(startrack);
			}else {
			item.setStartrack(false);}
			item.setAlta(true);
			item.setFechaCreacion(new Date()); 
			item.setImagen(foto);
			itemRepositorio.save(item);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

}
