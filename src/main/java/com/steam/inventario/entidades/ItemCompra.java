package com.steam.inventario.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCompra {
	
	@Id
	private Integer idItemCompra;
	@ManyToOne
	private Item items;
	private Integer cantidad;
	public ItemCompra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemCompra(Integer idItemCompra, Item items, Integer cantidad) {
		super();
		this.idItemCompra = idItemCompra;
		this.items = items;
		this.cantidad = cantidad;
	}
	public Integer getIdItemCompra() {
		return idItemCompra;
	}
	public void setIdItemCompra(Integer idItemCompra) {
		this.idItemCompra = idItemCompra;
	}
	public Item getItems() {
		return items;
	}
	public void setItems(Item items) {
		this.items = items;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ItemCompra [idItemCompra=" + idItemCompra + ", items=" + items + ", cantidad=" + cantidad + "]";
	}

}
