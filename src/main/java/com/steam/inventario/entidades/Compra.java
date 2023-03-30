package com.steam.inventario.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;
	private Integer cantidad;
	private Float precio;
	private Float totalCompra;
	private Float ganacia;
	private String pagina;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Item item;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compra(Integer idCompra, Integer cantidad, Float precio, Float totalCompra, Float ganacia, String pagina,
			Usuario usuario, Item item, Integer sticker, Boolean alta, Date fechaCreacion, Date fechaEdit) {
		super();
		this.idCompra = idCompra;
		this.cantidad = cantidad;
		this.precio = precio;
		this.totalCompra = totalCompra;
		this.ganacia = ganacia;
		this.pagina = pagina;
		this.usuario = usuario;
		this.item = item;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
	}
	public Integer getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
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
	public Float getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(Float totalCompra) {
		this.totalCompra = totalCompra;
	}
	public Float getGanacia() {
		return ganacia;
	}
	public void setGanacia(Float ganacia) {
		this.ganacia = ganacia;
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
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cantidad=" + cantidad + ", precio=" + precio + ", totalCompra="
				+ totalCompra + ", ganacia=" + ganacia + ", pagina=" + pagina + ", usuario=" + usuario + ", item="
				+ item + ", sticker="  + ", alta=" + alta + ", fechaCreacion=" + fechaCreacion + ", fechaEdit="
				+ fechaEdit + "]";
	}
	
	
	
}
