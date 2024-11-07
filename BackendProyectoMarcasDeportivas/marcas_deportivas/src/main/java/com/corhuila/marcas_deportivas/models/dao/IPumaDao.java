package com.corhuila.marcas_deportivas.models.dao;

import com.corhuila.marcas_deportivas.models.entity.Puma;
import org.springframework.data.repository.CrudRepository;

public interface IPumaDao extends CrudRepository <Puma, Long> {
}
