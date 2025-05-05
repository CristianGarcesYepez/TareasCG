package com.example.tareascg;

public class Contacto {
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;

    public Contacto(String nombre, String apellido, String correo, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
    }

    // Getters
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