package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.dao.IPumaDao;
import com.corhuila.marcas_deportivas.models.entity.Puma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PumaServiceImpl implements IPumaService{
    @Autowired
    private IPumaDao pumaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Puma> findall(){
        return (List<Puma>) pumaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Puma findById(Long id){
        return pumaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Puma save(Puma puma) {
        return pumaDao.save(puma);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pumaDao.deleteById(id);
    }
}
