package com.steam.inventario.entidades;

import java.io.File;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nombre;
	private String contrasena;
	@OneToMany(mappedBy = "usuario")
	private Set<Compra> compras;
	@OneToMany(mappedBy = "usuario")
	private Set<Venta> ventas;
	@OneToOne(mappedBy = "usuario")
	private Inventario inventario;
	private String  imagen;
	private String perfilStema;
	private Boolean alta;
	private Date fechaCreacion;
	private Date fechaEdit;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Usuario(Integer idUsuario, String nombre, String contrasena, Set<Compra> compras, Set<Venta> ventas,
			Inventario inventario, String  imagen, String perfilStema, Boolean alta, Date fechaCreacion, Date fechaEdit) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.compras = compras;
		this.ventas = ventas;
		this.inventario = inventario;
		this.imagen = imagen;
		this.perfilStema = perfilStema;
		this.alta = alta;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
	}
	public String  getImagen() {
		return imagen;
	}
	public void setImagen(String  imagen) {
		this.imagen = imagen;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public String getPerfilStema() {
		return perfilStema;
	}

	public void setPerfilStema(String perfilStema) {
		this.perfilStema = perfilStema;
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
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrasena=" + contrasena + ", compras="
				+ compras + ", ventas=" + ventas + ", inventario=" + inventario + ", imagen=" + imagen
				+ ", perfilStema=" + perfilStema + ", alta=" + alta + ", fechaCreacion=" + fechaCreacion
				+ ", fechaEdit=" + fechaEdit + "]";
	}
	
	
}
