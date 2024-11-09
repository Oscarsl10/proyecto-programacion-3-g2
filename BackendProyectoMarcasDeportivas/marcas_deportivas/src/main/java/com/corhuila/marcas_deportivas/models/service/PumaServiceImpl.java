package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.dao.IPumaDao;
import com.corhuila.marcas_deportivas.models.entity.Puma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// Implmentación del servicio de Puma con anotación de tipo SERVICE
@Service
public class PumaServiceImpl implements IPumaService{
    // Inyecta la instancia de IPumaDao, permite interactuar con la base de datos
    // sin tener que crear una isntancia manualmente
    @Autowired
    private IPumaDao pumaDao;

    // Indica que es un método que es una implementación de un método definido
    // en la interfaz IPumaService
    @Override
    // Define que es una transacción de solo lectura
    @Transactional(readOnly = true)
    // Llama al método findAll() de IPumaDao para obtener y devolver una lista completa de registros Puma.
    public List<Puma> findall(){
        return (List<Puma>) pumaDao.findAll();
    }

    // findById(Long id): Busca un registro Nike por su id.
    // Utiliza findById() de IPumaDao y devuelve el objeto Puma encontrado o null si no existe.
    @Override
    @Transactional(readOnly = true)
    public Puma findById(Long id){
        return pumaDao.findById(id).orElse(null);
    }

    @Override
    // Marca el método como transaccional para asegurar que las operaciones de escritura (guardar) se completen correctamente.
    @Transactional
    // Guarda un nuevo registro Puma o actualiza uno existente en la base de datos usando el método save() de IPumaDao.
    public Puma save(Puma puma) {
        return pumaDao.save(puma);
    }

    @Override
    @Transactional
    // Elimina un registro Puma de la base de datos según su id utilizando deleteById() de IPumaDao.
    // La anotación @Transactional asegura que esta operación de eliminación esté protegida en una transacción.
    public void delete(Long id) {
        pumaDao.deleteById(id);
    }
}
