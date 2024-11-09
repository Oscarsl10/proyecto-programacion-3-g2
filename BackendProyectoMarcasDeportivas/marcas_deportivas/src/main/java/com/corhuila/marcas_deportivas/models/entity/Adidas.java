package com.corhuila.marcas_deportivas.models.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Tabla para adidas
@Entity
@Table(name="adidas")
public class Adidas implements Serializable {
    // Anotación de tipo ID, id tipo Long y que se genere automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Anotación para definir una columna en la base de datos
    @Column(length = (100))
    private String nombre;
    @Column(length = (100))
    private String fecha_fundacion;

    // Temporal Date para que imprima la fecha en la que se insertó un dato
    @Column(name = "Fecha creación")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // PrePersist para que tome la fecha actual de tipo Date
    @PrePersist
    public void prePersist(){
        fecha = new Date();
    }
    private String origen;

    // Métodos Get y Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(String fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getIngresos_anuales() {
        return ingresos_anuales;
    }

    public void setIngresos_anuales(String ingresos_anuales) {
        this.ingresos_anuales = ingresos_anuales;
    }

    public String getEmpleados() {
        return empleados;
    }

    public void setEmpleados(String empleados) {
        this.empleados = empleados;
    }

    private String ingresos_anuales;
    private String empleados;

    //Identificador unico serializable
    private static final long serialVersionUID=1L;

}
