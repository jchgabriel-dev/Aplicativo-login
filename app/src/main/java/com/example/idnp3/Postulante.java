package com.example.idnp3;

import java.io.Serializable;

class Postulante implements Serializable {
    private String dni;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String fecha;
    private String colegio;
    private String carrera;

    public Postulante(String d, String nom, String apeP, String apeM, String fec, String col, String car){
        dni = d;
        nombres = nom;
        apePaterno = apeP;
        apeMaterno = apeM;
        fecha = fec;
        colegio = col;
        carrera = car;
    }
    public String getDNI() {
        return dni;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApePaterno() {
        return apePaterno;
    }
    public String getApeMaterno() {
        return apeMaterno;
    }
    public String getFecha() {
        return fecha;
    }
    public String getColegio() {
        return colegio;
    }
    public String getCarrera() {
        return carrera;
    }

}

