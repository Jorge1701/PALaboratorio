package Logica;

import java.util.ArrayList;

class Album {

    public String nickArtista;
    public String nombre;
    public int anio;
    public Imagen imagen;
    public ArrayList<Tema> temas;
    public ArrayList<Genero> generos;

    public Album(String nickArtista, String nombre, int anio, Imagen imagen, ArrayList<Tema> temas, ArrayList<Genero> generos) {
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

    public ArrayList<Genero> getGeneros() {
        return generos;
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

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public DtAlbum getData() {
     return new DtAlbum(nickArtista, nombre, anio);
    }

    public DtAlbumContenido obtenerAlbumContenido() {
     return null;
    }

}
