package com.jah.gestion_provincias3;

import java.util.ArrayList;
import java.util.List;

public class GestionProvincia {

    private static List<Provincia> arrProvincias;

    public static List<Provincia> getArrProvincias() {
        return arrProvincias;
    }

    public static void setArrProvincias(List<Provincia> arrProvincias) {
        GestionProvincia.arrProvincias = arrProvincias;
    }

    public static void anhadirProvincia(Provincia p){
        arrProvincias.add(p);
    }

    public static void ordenarPorProv(){
        arrProvincias.sort((p1, p2) -> p1.getNombreProv().compareToIgnoreCase(p2.getNombreProv()));
    }

    public static void ordenarPorCom(){
        arrProvincias.sort((p1, p2) -> p1.getNombreCom().compareToIgnoreCase(p2.getNombreCom()));
    }

    public static void cargarDatos(){
        arrProvincias = new ArrayList<>();
        Provincia p = new Provincia("Sevilla", "Andalucia", 600000, R.drawable.ciudad);
        arrProvincias.add(p);
        p = new Provincia("Cadiz", "Andalucia", 300000, R.drawable.ciudad);
        arrProvincias.add(p);
        p = new Provincia("Barcelona", "Cataluña", 700000, R.drawable.ciudad);
        arrProvincias.add(p);
        p = new Provincia("Pontevedra", "Galicia", 100000, R.drawable.ciudad);
        arrProvincias.add(p);
        p = new Provincia("Murcia", "Murcia", 50000, R.drawable.ciudad);
        arrProvincias.add(p);
        p = new Provincia("Madrid", "Madrid", 800000, R.drawable.ciudad);
        arrProvincias.add(p);
    }
}
