package Logica;

import java.util.ArrayList;
import java.util.HashMap;

class Genero {

    private String nombre;
    private HashMap<String, Genero> subgeneros;
    private HashMap<String, Album> albumes;
    private HashMap<String, ListaDefecto> listasDefecto;

    public Genero(String nombre, HashMap<String, Genero> subgeneros, HashMap<String, Album> albumes, HashMap<String, ListaDefecto> listasDefecto) {
        this.nombre = nombre;
        this.subgeneros = subgeneros;
        this.albumes = albumes;
        this.listasDefecto = listasDefecto;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }

    public void setListasDefecto(HashMap<String, ListaDefecto> listasDefecto) {
        this.listasDefecto = listasDefecto;
    }

    public HashMap<String, Album> getAlbumes() {
        return albumes;
    }

    public HashMap<String, ListaDefecto> getListasDefecto() {
        return listasDefecto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSubgeneros(HashMap<String, Genero> subgeneros) {
        this.subgeneros = subgeneros;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Genero> getSubgeneros() {
        return subgeneros;
    }

    public DtGenero getData() {
        return null;
    }

    public Genero obtener(String nombre) {
        return null;
    }

    public ArrayList<DtAlbum> obtenerAlbumes() {
        return null;
    }

}
