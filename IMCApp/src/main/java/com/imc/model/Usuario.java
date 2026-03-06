package com.imc.model;

public class Usuario {

    private int id;
    private String nombre;
    private int edad;
    private String genero;
    private double estatura;
    private String username;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre, int edad, String genero, double estatura, String username, String password) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.estatura = estatura;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
