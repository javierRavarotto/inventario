package com.steam.inventario.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;
	private Integer cantidad;
	private Float precio;
	private Float totalVenta;
	private String pagina;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Item item;
	private Integer sticker;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venta(Integer idVenta, Integer cantidad, Float precio, Float totalVenta, String pagina, Usuario usuario,
			Item item, Integer sticker, Boolean alta, Date fechaCreacion, Date fechaEdit) {
		super();
		this.idVenta = idVenta;
		this.cantidad = cantidad;
		this.precio = precio;
		this.totalVenta = totalVenta;
		this.pagina = pagina;
		this.usuario = usuario;
		this.item = item;
		this.sticker = sticker;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
	}
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Float getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(Float totalVenta) {
		this.totalVenta = totalVenta;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getSticker() {
		return sticker;
	}
	public void setSticker(Integer sticker) {
		this.sticker = sticker;
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
