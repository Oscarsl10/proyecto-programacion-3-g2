package com.corhuila.marcas_deportivas.models.service;
import com.corhuila.marcas_deportivas.models.entity.Adidas;
import java.util.List;

// Interfaz de Adidas que contiene los métodos que se van a usar en la implementación
public interface IAdidasService {
    // Método que devuelve una lista de todos los registros de la entidad Adidas.
    // Es el equivalente a un "select all" en SQL. El método debe ser implementado
    // por la clase que implemente esta interfaz.
    public List<Adidas> findall();

    // Método que recibe un identificador id de tipo Long y devuelve un objeto Adidas
    // correspondiente a ese id, o null si no se encuentra.
    public Adidas findById(Long id);

    // Método que recibe un objeto Adidas y guarda o actualiza dicho objeto en la base de datos.
    // El resultado será el objeto Adidas guardado con los datos actualizados.
    public Adidas save(Adidas adidas);

    // Método que elimina un registro Adidas de la base de datos basado en su id.
    // No devuelve nada, ya que su propósito es realizar una operación de eliminación.
    public void delete(Long id);
}
