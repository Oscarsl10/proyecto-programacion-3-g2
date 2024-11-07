package com.corhuila.marcas_deportivas.models.dao;

import com.corhuila.marcas_deportivas.models.entity.Adidas;
import org.springframework.data.repository.CrudRepository;

public interface IAdidasDao extends CrudRepository <Adidas, Long> {
}
