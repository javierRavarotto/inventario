package com.steam.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.steam.inventario.entidades.ItemCompra;
import com.steam.inventario.entidades.Usuario;

@Repository
public interface ItemCompraRepositorio  extends JpaRepository <ItemCompra,Integer>  {
	


}
