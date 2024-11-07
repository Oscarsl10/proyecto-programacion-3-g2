package com.corhuila.marcas_deportivas.controllers;

import com.corhuila.marcas_deportivas.models.entity.Nike;
import com.corhuila.marcas_deportivas.models.service.INikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class NikeRestController {
    @Autowired
    private INikeService nikeService;

    @GetMapping("/nike")
    public List<Nike> index(){
        return nikeService.findall();
    }

    @GetMapping("/nike/{id}")
    public Nike show(@PathVariable Long id){
        return nikeService.findById(id);
    }

    @PostMapping("/nike")
    @ResponseStatus(HttpStatus.CREATED)
    public Nike create(@RequestBody Nike nike){
        return nikeService.save(nike);
    }

    @PutMapping("/nike/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Nike update(@RequestBody Nike nike, @PathVariable Long id){
        Nike nikeActual = nikeService.findById(id);
        nikeActual.setNombre(nike.getNombre());
        nikeActual.setFecha_fundacion(nike.getFecha_fundacion());
        nikeActual.setOrigen(nike.getOrigen());
        nikeActual.setIngresos_anuales(nike.getIngresos_anuales());
        nikeActual.setEmpleados(nike.getEmpleados());
        return nikeService.save(nikeActual);
    }

    @DeleteMapping("/nike/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        nikeService.delete(id);
    }

}
