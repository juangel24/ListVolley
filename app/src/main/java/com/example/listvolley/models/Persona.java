package com.example.listvolley.models;

public class Persona {
    private Integer id;
    private String Nombre;
    private String Apellido;
    private Integer Edad;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        this.Edad = edad;
    }

    public String nombreCompleto(){
        return Nombre + " " + Apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
