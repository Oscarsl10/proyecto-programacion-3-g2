package com.corhuila.marcas_deportivas.models.dao;

import com.corhuila.marcas_deportivas.models.entity.Nike;
import org.springframework.data.repository.CrudRepository;

// Interfaz INikeDao hereda el CRUD y recibe datos de Nike y Long (id)
public interface INikeDao extends CrudRepository <Nike, Long> {
}
