package com.steam.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.steam.inventario.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario,Integer>  {

	@Query(value="SELECT max(u) FROM Usuario u  ")
	public Usuario buscarUltima();
}
