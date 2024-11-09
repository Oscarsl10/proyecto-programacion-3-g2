package com.corhuila.marcas_deportivas.models.service;

import com.corhuila.marcas_deportivas.models.entity.Puma;

import java.util.List;

public interface IPumaService {
    // Método que devuelve una lista de todos los registros de la entidad Puma.
    // Es el equivalente a un "select all" en SQL. El método debe ser implementado
    // por la clase que implemente esta interfaz.
    public List<Puma> findall();

    // Método que recibe un identificador id de tipo Long y devuelve un objeto Puma
    // correspondiente a ese id, o null si no se encuentra.
    public Puma findById(Long id);

    // Método que recibe un objeto Puma y guarda o actualiza dicho objeto en la base de datos.
    // El resultado será el objeto Adidas guardado con los datos actualizados.
    public Puma save(Puma puma);

    // Método que elimina un registro Puma de la base de datos basado en su id.
    // No devuelve nada, ya que su propósito es realizar una operación de eliminación.
    public void delete(Long id);
}
