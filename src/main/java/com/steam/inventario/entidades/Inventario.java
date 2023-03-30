package com.steam.inventario.entidades;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInventario;
	@OneToMany
	private Set<ItemCompra> itemsCompra; //cambiar a compra
	@OneToOne
	private Usuario usuario;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	
	public Inventario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventario(Integer idInventario, Set<ItemCompra> itemsCompra, Usuario usuario, Boolean alta,
			Date fechaCreacion, Date fechaEdit) {
		super();
		this.idInventario = idInventario;
		this.itemsCompra = itemsCompra;
		this.usuario = usuario;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
	}

	public Integer getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Set<ItemCompra> getItemsCompra() {
		return itemsCompra;
	}

	public void setItemsCompra(Set<ItemCompra> itemsCompra) {
		this.itemsCompra = itemsCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEdit() {
		return fechaEdit;
	}

	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}

	

}
