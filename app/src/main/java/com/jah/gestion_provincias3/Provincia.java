package com.jah.gestion_provincias3;

import java.io.Serializable;

public class Provincia implements Serializable {
    private String nombreProv;
    private String nombreCom;
    private int nHabitantes;
    private int foto;

    public Provincia(){}

    public Provincia(String nombreProv, String nombreCom, int nHabitantes, int foto) {
        this.nombreProv = nombreProv;
        this.nombreCom = nombreCom;
        this.nHabitantes = nHabitantes;
        this.foto = foto;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    public int getnHabitantes() {
        return nHabitantes;
    }

    public void setnHabitantes(int nHabitantes) {
        this.nHabitantes = nHabitantes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombreProv='" + nombreProv + '\'' +
                ", nombreCom='" + nombreCom + '\'' +
                ", nHabitantes=" + nHabitantes +
                ", foto=" + foto +
                '}';
    }
}
