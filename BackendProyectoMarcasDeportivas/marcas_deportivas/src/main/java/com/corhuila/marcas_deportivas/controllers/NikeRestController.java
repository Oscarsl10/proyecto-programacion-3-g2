package com.corhuila.marcas_deportivas.controllers;

import com.corhuila.marcas_deportivas.models.entity.Nike;
import com.corhuila.marcas_deportivas.models.service.INikeService;
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
public class NikeRestController {

    // Inyecta automáticamente la instancia del servicio INikeService en este controlador
    // para acceder a los métodos que gestionan las operaciones de la entidad Nike.
    @Autowired
    private INikeService nikeService;

    // Maneja las solicitudes GET en la ruta /api/nike.
    // Este método devuelve la lista de todos los registros de la entidad Nike llamando al servicio findall().
    @GetMapping("/nike")
    // index(): El método devuelve una lista de todos los objetos Nike.
    public List<Nike> index(){
        return nikeService.findall();
    }

    // Maneja las solicitudes GET para obtener un registro Nike específico a través de su id.
    // La parte {id} se vincula al parámetro id del método.
    @GetMapping("/nike/{id}")
    // @PathVariable Long id: Vincula el valor del id de la URL al parámetro id del método.
    //show(): Devuelve el objeto Nike correspondiente al id especificado.
    public Nike show(@PathVariable Long id){
        return nikeService.findById(id);
    }

    // Maneja las solicitudes POST en la ruta /api/adidas, usadas para crear un nuevo registro Adidas.
    @PostMapping("/nike")
    // Establece el código de estado HTTP como 201 Created para indicar que el recurso fue creado exitosamente.
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody Nike nike: Indica que el cuerpo de la solicitud contiene un objeto Nike en formato JSON,
    // que será convertido automáticamente a una instancia de la clase Nike.
    // create(): Guarda el objeto Nike recibido y devuelve el objeto guardado.
    public Nike create(@RequestBody Nike nike){
        return nikeService.save(nike);
    }

    // Maneja las solicitudes PUT para actualizar un registro existente de Nike en la ruta /api/nike/{id},
    // donde {id} es el identificador del recurso a actualizar.
    @PutMapping("/nike/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody Nike nike: Recibe el objeto Nike con los datos actualizados en formato JSON.
    // @PathVariable Long id: Recibe el id del objeto Nike a actualizar.
    // update(): Busca el objeto Nike existente por id, actualiza sus campos con los datos recibidos,
    // y luego lo guarda de nuevo en la base de datos.
    public Nike update(@RequestBody Nike nike, @PathVariable Long id){
        Nike nikeActual = nikeService.findById(id);
        nikeActual.setNombre(nike.getNombre());
        nikeActual.setFecha_fundacion(nike.getFecha_fundacion());
        nikeActual.setOrigen(nike.getOrigen());
        nikeActual.setIngresos_anuales(nike.getIngresos_anuales());
        nikeActual.setEmpleados(nike.getEmpleados());
        return nikeService.save(nikeActual);
    }

    // Maneja las solicitudes DELETE en la ruta /api/nike/{id}, eliminando el recurso identificado por id.
    @DeleteMapping("/nike/{id}")
    // Establece el código de estado HTTP como 204 No Content para indicar que la operación de eliminación fue exitosa,
    // pero no hay contenido en la respuesta.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // @PathVariable Long id: Recibe el id del objeto Nike a eliminar.
    // delete(): Llama al método delete(id) del servicio NikeService para eliminar el registro Nike con el id proporcionado.
    public void delete(@PathVariable Long id){
        nikeService.delete(id);
    }

}
