package com.example.apiprueba.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document
public class MusicaModel {
    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String genero;
    @Field
    private String autor;
    @Field
    private String duracion;

    //public MusicModel() {}

    public MusicaModel(String nombre, String genero, String autor, String duracion) {
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return String.format("MusicModel[id='%s', nombre='%s', genero='%s', autor='%s', duracion='%s']");
    }
}
