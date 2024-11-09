package com.corhuila.marcas_deportivas.controllers;

import com.corhuila.marcas_deportivas.models.entity.Puma;
import com.corhuila.marcas_deportivas.models.service.IPumaService;
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
public class PumaRestController {

    // Inyecta automáticamente la instancia del servicio IPumaService en este controlador
    // para acceder a los métodos que gestionan las operaciones de la entidad Puma.
    @Autowired
    private IPumaService pumaService;

    // Maneja las solicitudes GET en la ruta /api/puma.
    // Este método devuelve la lista de todos los registros de la entidad Puma llamando al servicio findall().
    @GetMapping("/puma")
    // index(): El método devuelve una lista de todos los objetos Puma.
    public List<Puma> index(){
        return pumaService.findall();
    }

    // Maneja las solicitudes GET para obtener un registro Puma específico a través de su id.
    // La parte {id} se vincula al parámetro id del método.
    @GetMapping("/puma/{id}")
    // @PathVariable Long id: Vincula el valor del id de la URL al parámetro id del método.
    //show(): Devuelve el objeto Puma correspondiente al id especificado.
    public Puma show(@PathVariable Long id){
        return pumaService.findById(id);
    }

    // Maneja las solicitudes POST en la ruta /api/puma, usadas para crear un nuevo registro Puma.
    @PostMapping("/puma")
    // Establece el código de estado HTTP como 201 Created para indicar que el recurso fue creado exitosamente.
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody Puma puma: Indica que el cuerpo de la solicitud contiene un objeto Puma en formato JSON,
    // que será convertido automáticamente a una instancia de la clase Puma.
    // create(): Guarda el objeto Puma recibido y devuelve el objeto guardado.
    public Puma create(@RequestBody Puma puma){
        return pumaService.save(puma);
    }

    // Maneja las solicitudes PUT para actualizar un registro existente de Puma en la ruta /api/puma/{id},
    // donde {id} es el identificador del recurso a actualizar.
    @PutMapping("/puma/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody Puma puma: Recibe el objeto puma con los datos actualizados en formato JSON.
    // @PathVariable Long id: Recibe el id del objeto Puma a actualizar.
    // update(): Busca el objeto Puma existente por id, actualiza sus campos con los datos recibidos,
    // y luego lo guarda de nuevo en la base de datos.
    public Puma update(@RequestBody Puma puma, @PathVariable Long id){
        Puma pumaActual = pumaService.findById(id);
        pumaActual.setNombre(puma.getNombre());
        pumaActual.setFecha_fundacion(puma.getFecha_fundacion());
        pumaActual.setOrigen(puma.getOrigen());
        pumaActual.setIngresos_anuales(puma.getIngresos_anuales());
        pumaActual.setEmpleados(puma.getEmpleados());
        return pumaService.save(pumaActual);
    }

    // Maneja las solicitudes DELETE en la ruta /api/puma/{id}, eliminando el recurso identificado por id.
    @DeleteMapping("/puma/{id}")
    // Establece el código de estado HTTP como 204 No Content para indicar que la operación de eliminación fue exitosa,
    // pero no hay contenido en la respuesta.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // @PathVariable Long id: Recibe el id del objeto Puma a eliminar.
    // delete(): Llama al método delete(id) del servicio PumaService para eliminar el registro Puma con el id proporcionado.
    public void delete(@PathVariable Long id){
        pumaService.delete(id);
    }

}
