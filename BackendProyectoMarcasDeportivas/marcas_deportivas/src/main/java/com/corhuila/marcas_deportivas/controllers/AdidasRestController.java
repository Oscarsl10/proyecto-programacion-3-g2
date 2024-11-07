package com.corhuila.marcas_deportivas.controllers;

import com.corhuila.marcas_deportivas.models.entity.Adidas;
import com.corhuila.marcas_deportivas.models.service.IAdidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AdidasRestController {
    @Autowired
    private IAdidasService adidasService;

    @GetMapping("/adidas")
    public List<Adidas> index(){
        return adidasService.findall();
    }

    @GetMapping("/adidas/{id}")
    public Adidas show(@PathVariable Long id){
        return adidasService.findById(id);
    }

    @PostMapping("/adidas")
    @ResponseStatus(HttpStatus.CREATED)
    public Adidas create(@RequestBody Adidas adidas){
        return adidasService.save(adidas);
    }

    @PutMapping("/adidas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Adidas update(@RequestBody Adidas adidas, @PathVariable Long id){
        Adidas adidasActual = adidasService.findById(id);
        adidasActual.setNombre(adidas.getNombre());
        adidasActual.setFecha_fundacion(adidas.getFecha_fundacion());
        adidasActual.setOrigen(adidas.getOrigen());
        adidasActual.setIngresos_anuales(adidas.getIngresos_anuales());
        adidasActual.setEmpleados(adidas.getEmpleados());
        return adidasService.save(adidasActual);
    }

    @DeleteMapping("/adidas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        adidasService.delete(id);
    }

}
