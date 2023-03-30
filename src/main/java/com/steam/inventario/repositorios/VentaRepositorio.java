package com.steam.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steam.inventario.entidades.Venta;

@Repository
public interface VentaRepositorio extends JpaRepository <Venta,Integer>  {

}
