package com.steam.inventario.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steam.inventario.entidades.Inventario;

@Repository
public interface InventarioRepositorio   extends JpaRepository <Inventario,Integer>  {

}
