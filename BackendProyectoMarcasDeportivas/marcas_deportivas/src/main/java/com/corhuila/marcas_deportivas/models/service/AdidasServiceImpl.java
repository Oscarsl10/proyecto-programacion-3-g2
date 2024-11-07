package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.dao.IAdidasDao;
import com.corhuila.marcas_deportivas.models.entity.Adidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AdidasServiceImpl implements IAdidasService {
    @Autowired
    private IAdidasDao adidasDao;
    @Override
    @Transactional(readOnly = true)
    public List<Adidas> findall(){
        return (List<Adidas>) adidasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Adidas findById(Long id){
        return adidasDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Adidas save(Adidas adidas) {
        return adidasDao.save(adidas);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        adidasDao.deleteById(id);
    }
}
