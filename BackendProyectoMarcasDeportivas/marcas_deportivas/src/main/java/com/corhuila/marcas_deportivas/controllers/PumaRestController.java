package com.corhuila.marcas_deportivas.controllers;

import com.corhuila.marcas_deportivas.models.entity.Puma;
import com.corhuila.marcas_deportivas.models.service.IPumaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PumaRestController {
    @Autowired
    private IPumaService pumaService;

    @GetMapping("/puma")
    public List<Puma> index(){
        return pumaService.findall();
    }

    @GetMapping("/puma/{id}")
    public Puma show(@PathVariable Long id){
        return pumaService.findById(id);
    }

    @PostMapping("/puma")
    @ResponseStatus(HttpStatus.CREATED)
    public Puma create(@RequestBody Puma puma){
        return pumaService.save(puma);
    }

    @PutMapping("/puma/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Puma update(@RequestBody Puma puma, @PathVariable Long id){
        Puma pumaActual = pumaService.findById(id);
        pumaActual.setNombre(puma.getNombre());
        pumaActual.setFecha_fundacion(puma.getFecha_fundacion());
        pumaActual.setOrigen(puma.getOrigen());
        pumaActual.setIngresos_anuales(puma.getIngresos_anuales());
        pumaActual.setEmpleados(puma.getEmpleados());
        return pumaService.save(pumaActual);
    }

    @DeleteMapping("/puma/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        pumaService.delete(id);
    }

}
