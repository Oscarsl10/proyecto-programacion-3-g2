package com.corhuila.marcas_deportivas.models.dao;

import com.corhuila.marcas_deportivas.models.entity.Puma;
import org.springframework.data.repository.CrudRepository;

// Interfaz IPumaDao hereda el CRUD y recibe datos de Puma y Long (id)
public interface IPumaDao extends CrudRepository <Puma, Long> {
}
