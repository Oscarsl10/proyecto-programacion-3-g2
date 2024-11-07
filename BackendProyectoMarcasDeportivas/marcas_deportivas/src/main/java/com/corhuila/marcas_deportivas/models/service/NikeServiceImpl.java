package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.dao.INikeDao;
import com.corhuila.marcas_deportivas.models.entity.Nike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class NikeServiceImpl implements INikeService{
    @Autowired
    private INikeDao nikeDao;
    @Override
    @Transactional(readOnly = true)
    public List<Nike> findall(){
        return (List<Nike>) nikeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Nike findById(Long id){
        return nikeDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Nike save(Nike nike) {
        return nikeDao.save(nike);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        nikeDao.deleteById(id);
    }
}
