package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Album {

    public String nickArtista;
    public String nombre;
    public int anio;
    public Imagen imagen;
    public ArrayList<Tema> temas;
    public HashMap<String, Genero> generos;
    public Artista artista;

    public Album(String nickArtista, String nombre, int anio, Imagen imagen, ArrayList<Tema> temas, HashMap<String, Genero> generos) {
        this.nickArtista = nickArtista;
        this.nombre = nombre;
        this.anio = anio;
        this.imagen = imagen;
        this.temas = temas;
        this.generos = generos;
    }

    public String getNickArtista() {
        return nickArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public HashMap<String, Genero> getGeneros() {
        return generos;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    public void setGeneros(HashMap<String, Genero> generos) {
        this.generos = generos;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public DtAlbum getData() {
        return new DtAlbum(nickArtista, nombre, anio);
    }

    public DtAlbumContenido obtenerAlbumContenido() {
        ArrayList<String> nomGeneros = new ArrayList<>();
        ArrayList<DtTema> dtTemas = new ArrayList<>();

        Iterator it = generos.entrySet().iterator();
        while (it.hasNext()) {
            Genero genero = (Genero) ((Map.Entry) it.next()).getValue();
            nomGeneros.add(genero.getNombre());
        }

        Iterator it1 = temas.iterator();
        while (it1.hasNext()) {
            Tema tema = (Tema) ((Map.Entry) it1.next()).getValue();
            dtTemas.add(tema.getData());
        }

        return new DtAlbumContenido(this.getData(), nomGeneros, dtTemas);
    }

}
