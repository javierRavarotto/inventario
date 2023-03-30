package com.steam.inventario.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.steam.inventario.entidades.Compra;
import com.steam.inventario.entidades.Item;
import com.steam.inventario.entidades.ItemCompra;
import com.steam.inventario.entidades.Venta;
import com.steam.inventario.repositorios.CompraRepositorio;
import com.steam.inventario.repositorios.ItemCompraRepositorio;
import com.steam.inventario.repositorios.UsuarioRepositorio;
import com.steam.inventario.repositorios.VentaRepositorio;

import errorServicio.ErrorServicio;

@Service
public class VentaServicio {
	
	@Autowired
	VentaRepositorio ventaRepositorio;
	
	@Autowired
	CompraRepositorio compraRepositorio;
	
	@Autowired
	ItemCompraRepositorio itemCompraRepositorio;
	
	@Autowired
	CompraServicio compraServicio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	public Venta buscarId(Integer id) {
	 
		Venta venta = ventaRepositorio.findById(id).get();
		return venta;
	}
	
	@Transactional
	public String crearVenta(Integer cantidad,Float precio,String pagina,Integer idCompra) throws ErrorServicio {
		try {
			String mensaje= "";
			Compra compra= compraServicio.buscarId(idCompra);
			Item item = compra.getItem();	
			ItemCompra itemCompra= itemCompraRepositorio.findById(item.getIdItem()).get();
			Venta venta = new Venta();
			venta.setCantidad(cantidad);
			venta.setPrecio(precio);
			venta.setPagina(pagina);
			venta.setTotalVenta(precio*cantidad);
			venta.setItem(item);
			venta.setUsuario(usuarioRepositorio.findById(compra.getUsuario().getIdUsuario()).get());
			venta.setAlta(true);
			venta.setFechaCreacion(new Date()); 
						
			if(compra.getCantidad()-cantidad == 0) {
				compra.setAlta(false);
				compra.setCantidad(compra.getCantidad()-cantidad);
				mensaje= "Se ventidio todo correctamente";
			}
			if(compra.getCantidad()-cantidad < 0) {
				compra.setAlta(false);
				cantidad=compra.getCantidad();
				compra.setCantidad(compra.getCantidad()-cantidad);
				mensaje= "Se ventidio "+ cantidad +" correctamente";
			}
			if(compra.getCantidad()-cantidad > 0) {
				
				compra.setCantidad(compra.getCantidad()-cantidad);
				mensaje= "Se ventidio "+ cantidad +" correctamente";
			}
			
			
			compra.setGanacia(compra.getGanacia()+((precio-compra.getPrecio())*cantidad));
			itemCompra.setCantidad(itemCompra.getCantidad()- cantidad);
	
			
				compraRepositorio.save(compra);
				ventaRepositorio.save(venta);
				itemCompraRepositorio.save(itemCompra);
		
			return mensaje;
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}

}
