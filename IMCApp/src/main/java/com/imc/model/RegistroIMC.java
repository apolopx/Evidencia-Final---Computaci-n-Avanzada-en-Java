package com.imc.model;

import java.util.Date;

public class RegistroIMC {

    private double peso;
    private double imc;
    private String clasificacion;
    private int idUsuario;
    private Date fecha;

    public RegistroIMC() {
    }

    public RegistroIMC(double peso, double imc, String clasificacion, int idUsuario) {
        this.peso = peso;
        this.imc = imc;
        this.clasificacion = clasificacion;
        this.idUsuario = idUsuario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
