package com.steam.inventario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steam.inventario.entidades.Compra;
import com.steam.inventario.entidades.Inventario;
import com.steam.inventario.entidades.Item;
import com.steam.inventario.entidades.ItemCompra;
import com.steam.inventario.repositorios.ItemCompraRepositorio;

import errorServicio.ErrorServicio;

@Service
public class ItemCompraServicio {
	
	@Autowired
	ItemCompraRepositorio itemCompraRepositorio;
	
	public boolean encontrar(Integer id) throws ErrorServicio {
		try {
		ItemCompra itemCompra = itemCompraRepositorio.findById(id).get();
		
		return true;
		
		} catch (Exception e) {
			return false;
			
		}
	}
	
	
	@Transactional
	public ItemCompra crearItemCompra(Item item,Integer cantida) throws ErrorServicio {
		try {
			
			
			if(encontrar(item.getIdItem())) {
				ItemCompra itemCompraAc = 	itemCompraRepositorio.findById(item.getIdItem()).get();		
				itemCompraAc.setCantidad(cantida + itemCompraAc.getCantidad());
				itemCompraRepositorio.save(itemCompraAc);
				return itemCompraAc;

			}else {
				ItemCompra itemCompra = new ItemCompra();
				itemCompra.setCantidad(cantida );
				itemCompra.setIdItemCompra(item.getIdItem());
				itemCompra.setItems(item);
				
				itemCompraRepositorio.save(itemCompra);
				
				return itemCompra;
			}
			
			
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

}
