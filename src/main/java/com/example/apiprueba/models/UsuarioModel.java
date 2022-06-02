package com.example.apiprueba.models;

import javax.persistence.*;

// Declaramos que este modelo sera una entidad de nuestra base de datos y le asignamos el nombre
@Entity
@Table(name = "usuario")
public class UsuarioModel {
    // Le indacamos a JPA que este campo sera un id, se le crea un index y las propiedades de la columna
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;

    // Getters y Setters de las variables
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
