package com.steam.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steam.inventario.entidades.Compra;

@Repository
public interface CompraRepositorio extends JpaRepository <Compra,Integer>  {

}
