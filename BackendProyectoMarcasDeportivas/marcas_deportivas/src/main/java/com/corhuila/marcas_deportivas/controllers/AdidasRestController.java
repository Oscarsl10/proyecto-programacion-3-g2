package com.corhuila.marcas_deportivas.controllers;

import com.corhuila.marcas_deportivas.models.entity.Adidas;
import com.corhuila.marcas_deportivas.models.service.IAdidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Esta anotación permite que las solicitudes de un origen específico, puedan interactuar con este controlador.
// Es útil para habilitar la comunicación entre el frontend y el backend cuando están ejecutándose en dominios diferentes.
@CrossOrigin(origins = {"http://localhost:4200"})

// Marca la clase como un controlador REST, lo que significa que maneja solicitudes HTTP
// y responde con datos en formato JSON o XML, dependiendo de la configuración de la aplicación.
@RestController

// Define la ruta base para todas las solicitudes manejadas por este controlador.
// En este caso, todas las rutas comenzarán con /api.
@RequestMapping("/api")
public class AdidasRestController {

    // Inyecta automáticamente la instancia del servicio IAdidasService en este controlador
    // para acceder a los métodos que gestionan las operaciones de la entidad Adidas.
    @Autowired
    private IAdidasService adidasService;

    // Maneja las solicitudes GET en la ruta /api/adidas.
    // Este método devuelve la lista de todos los registros de la entidad Adidas llamando al servicio findall().
    @GetMapping("/adidas")
    // index(): El método devuelve una lista de todos los objetos Adidas.
    public List<Adidas> index(){
        return adidasService.findall();
    }

    // Maneja las solicitudes GET para obtener un registro Adidas específico a través de su id.
    // La parte {id} se vincula al parámetro id del método.
    @GetMapping("/adidas/{id}")
    // @PathVariable Long id: Vincula el valor del id de la URL al parámetro id del método.
    //show(): Devuelve el objeto Adidas correspondiente al id especificado.
    public Adidas show(@PathVariable Long id){
        return adidasService.findById(id);
    }

    // Maneja las solicitudes POST en la ruta /api/adidas, usadas para crear un nuevo registro Adidas.
    @PostMapping("/adidas")
    // Establece el código de estado HTTP como 201 Created para indicar que el recurso fue creado exitosamente.
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody Adidas adidas: Indica que el cuerpo de la solicitud contiene un objeto Adidas en formato JSON,
    // que será convertido automáticamente a una instancia de la clase Adidas.
    // create(): Guarda el objeto Adidas recibido y devuelve el objeto guardado.
    public Adidas create(@RequestBody Adidas adidas){
        return adidasService.save(adidas);
    }

    // Maneja las solicitudes PUT para actualizar un registro existente de Adidas en la ruta /api/adidas/{id},
    // donde {id} es el identificador del recurso a actualizar.
    @PutMapping("/adidas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody Adidas adidas: Recibe el objeto Adidas con los datos actualizados en formato JSON.
    // @PathVariable Long id: Recibe el id del objeto Adidas a actualizar.
    // update(): Busca el objeto Adidas existente por id, actualiza sus campos con los datos recibidos,
    // y luego lo guarda de nuevo en la base de datos.
    public Adidas update(@RequestBody Adidas adidas, @PathVariable Long id){
        Adidas adidasActual = adidasService.findById(id);
        adidasActual.setNombre(adidas.getNombre());
        adidasActual.setFecha_fundacion(adidas.getFecha_fundacion());
        adidasActual.setOrigen(adidas.getOrigen());
        adidasActual.setIngresos_anuales(adidas.getIngresos_anuales());
        adidasActual.setEmpleados(adidas.getEmpleados());
        return adidasService.save(adidasActual);
    }

    // Maneja las solicitudes DELETE en la ruta /api/adidas/{id}, eliminando el recurso identificado por id.
    @DeleteMapping("/adidas/{id}")
    // Establece el código de estado HTTP como 204 No Content para indicar que la operación de eliminación fue exitosa,
    // pero no hay contenido en la respuesta.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // @PathVariable Long id: Recibe el id del objeto Adidas a eliminar.
    // delete(): Llama al método delete(id) del servicio AdidasService para eliminar el registro Adidas con el id proporcionado.
    public void delete(@PathVariable Long id){
        adidasService.delete(id);
    }

}
