package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.entity.Puma;

import java.util.List;

public interface IPumaService {
    public List<Puma> findall();

    public Puma findById(Long id);
    public Puma save(Puma puma);
    public void delete(Long id);
}
