package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.entity.Nike;

import java.util.List;

// Interfaz de Adidas que contiene los métodos que se van a usar en la implementación
public interface INikeService {
    // Método que devuelve una lista de todos los registros de la entidad Nike.
    // Es el equivalente a un "select all" en SQL. El método debe ser implementado
    // por la clase que implemente esta interfaz.
    public List<Nike> findall();

    // Método que recibe un identificador id de tipo Long y devuelve un objeto Nike
    // correspondiente a ese id, o null si no se encuentra.
    public Nike findById(Long id);

    // Método que recibe un objeto Nike y guarda o actualiza dicho objeto en la base de datos.
    // El resultado será el objeto Adidas guardado con los datos actualizados.
    public Nike save(Nike nike);

    // Método que elimina un registro Nike de la base de datos basado en su id.
    // No devuelve nada, ya que su propósito es realizar una operación de eliminación.
    public void delete(Long id);
}
