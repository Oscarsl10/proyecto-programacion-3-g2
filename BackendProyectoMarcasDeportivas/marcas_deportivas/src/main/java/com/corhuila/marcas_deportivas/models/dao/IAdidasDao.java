package com.corhuila.marcas_deportivas.models.dao;

import com.corhuila.marcas_deportivas.models.entity.Adidas;
import org.springframework.data.repository.CrudRepository;

// Interfaz IAdidasDao hereda el CRUD y recibe datos de Adidas y Long (id)
public interface IAdidasDao extends CrudRepository <Adidas, Long> {
}
