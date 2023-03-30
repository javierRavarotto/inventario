package com.steam.inventario.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	private String nombre;
	private String calidad;
	private String imagen;
	private boolean startrack;
	private Integer sticker;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Integer idItem, String nombre, String calidad, String imagen, boolean startrack, Integer sticker,
			Boolean alta, Date fechaCreacion, Date fechaEdit) {
		super();
		this.idItem = idItem;
		this.nombre = nombre;
		this.calidad = calidad;
		this.imagen = imagen;
		this.startrack = startrack;
		this.sticker = sticker;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
	}




	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isStartrack() {
		return startrack;
	}

	public void setStartrack(boolean startrack) {
		this.startrack = startrack;
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

	public Integer getSticker() {
		return sticker;
	}

	public void setSticker(Integer sticker) {
		this.sticker = sticker;
	}

	
	
	
}
