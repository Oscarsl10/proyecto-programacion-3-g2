package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.dao.INikeDao;
import com.corhuila.marcas_deportivas.models.entity.Nike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// Implmentación del servicio de Nike con anotación de tipo SERVICE
@Service
public class NikeServiceImpl implements INikeService{
    // Inyecta la instancia de INikeDao, permite interactuar con la base de datos
    // sin tener que crear una isntancia manualmente
    @Autowired
    private INikeDao nikeDao;

    // Indica que es un método que es una implementación de un método definido
    // en la interfaz INikeService
    @Override
    // Define que es una transacción de solo lectura
    @Transactional(readOnly = true)
    // Llama al método findAll() de INikeDao para obtener y devolver una lista completa de registros Nike.
    public List<Nike> findall(){
        return (List<Nike>) nikeDao.findAll();
    }

    // findById(Long id): Busca un registro Nike por su id.
    // Utiliza findById() de INikeDao y devuelve el objeto Nike encontrado o null si no existe.
    @Override
    @Transactional(readOnly = true)
    public Nike findById(Long id){
        return nikeDao.findById(id).orElse(null);
    }

    @Override
    // Marca el método como transaccional para asegurar que las operaciones de escritura (guardar) se completen correctamente.
    @Transactional
    // Guarda un nuevo registro Nike o actualiza uno existente en la base de datos usando el método save() de INikeDao.
    public Nike save(Nike nike) {
        return nikeDao.save(nike);
    }

    @Override
    @Transactional
    // Elimina un registro Adidas de la base de datos según su id utilizando deleteById() de IAdidasDao.
    // La anotación @Transactional asegura que esta operación de eliminación esté protegida en una transacción.
    public void delete(Long id) {
        nikeDao.deleteById(id);
    }
}
