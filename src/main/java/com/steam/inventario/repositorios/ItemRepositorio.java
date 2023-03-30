package com.steam.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steam.inventario.entidades.Item;

@Repository
public interface ItemRepositorio  extends JpaRepository <Item,Integer>  {

}
