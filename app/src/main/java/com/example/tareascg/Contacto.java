package com.example.tareascg;

public class Contacto {
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;

    // Constructor sin ID (para nuevos contactos)
    public Contacto(String nombre, String apellido, String correo, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
    }

    // Constructor con ID (para contactos existentes desde BD)
    public Contacto(long id, String nombre, String apellido, String correo, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}