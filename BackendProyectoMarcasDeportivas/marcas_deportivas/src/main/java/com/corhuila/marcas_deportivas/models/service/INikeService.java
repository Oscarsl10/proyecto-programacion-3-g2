package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.entity.Nike;

import java.util.List;

public interface INikeService {
    public List<Nike> findall();

    public Nike findById(Long id);
    public Nike save(Nike nike);
    public void delete(Long id);
}
