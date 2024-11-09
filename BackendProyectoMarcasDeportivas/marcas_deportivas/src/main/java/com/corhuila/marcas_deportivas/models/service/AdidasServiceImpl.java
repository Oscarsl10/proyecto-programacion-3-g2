package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.dao.IAdidasDao;
import com.corhuila.marcas_deportivas.models.entity.Adidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

// Implmentación del servicio de Adidas con anotación de tipo SERVICE
@Service
public class AdidasServiceImpl implements IAdidasService {
    // Inyecta la instancia de IAdidasDao, permite interactuar con la base de datos
    // sin tener que crear una isntancia manualmente
    @Autowired
    private IAdidasDao adidasDao;

    // Indica que es un método que es una implementación de un método definido
    // en la interfaz IAdidasService
    @Override
    // Define que es una transacción de solo lectura
    @Transactional(readOnly = true)
    // Llama al método findAll() de IAdidasDao para obtener y devolver una lista completa de registros Adidas.
    public List<Adidas> findall(){
        return (List<Adidas>) adidasDao.findAll();
    }

    // findById(Long id): Busca un registro Adidas por su id.
    // Utiliza findById() de IAdidasDao y devuelve el objeto Adidas encontrado o null si no existe.
    @Override
    @Transactional(readOnly = true)
    public Adidas findById(Long id){
        return adidasDao.findById(id).orElse(null);
    }

    @Override
    // Marca el método como transaccional para asegurar que las operaciones de escritura (guardar) se completen correctamente.
    @Transactional
    // Guarda un nuevo registro Adidas o actualiza uno existente en la base de datos usando el método save() de IAdidasDao.
    public Adidas save(Adidas adidas) {
        return adidasDao.save(adidas);
    }

    @Override
    @Transactional
    // Elimina un registro Adidas de la base de datos según su id utilizando deleteById() de IAdidasDao.
    // La anotación @Transactional asegura que esta operación de eliminación esté protegida en una transacción.
    public void delete(Long id) {
        adidasDao.deleteById(id);
    }
}
