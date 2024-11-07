package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.entity.Adidas;

import java.util.List;

public interface IAdidasService {
    public List<Adidas> findall();

    public Adidas findById(Long id);
    public Adidas save(Adidas adidas);
    public void delete(Long id);
}
