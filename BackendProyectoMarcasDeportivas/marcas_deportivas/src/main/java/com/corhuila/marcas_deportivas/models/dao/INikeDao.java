package com.corhuila.marcas_deportivas.models.dao;

import com.corhuila.marcas_deportivas.models.entity.Nike;
import org.springframework.data.repository.CrudRepository;

public interface INikeDao extends CrudRepository <Nike, Long> {
}
