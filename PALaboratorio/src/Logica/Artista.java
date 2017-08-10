package Logica;

import java.util.ArrayList;
import java.util.HashMap;

public class Artista extends Usuario {

    private String biografia;
    private String web;
    private HashMap<String, Album> albumes;

    public Artista(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, Imagen imagen, String biografia, String web) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);             //LLama al constructor de Usuario
        this.biografia = biografia;
        this.web = web;
        this.albumes = new HashMap<String, Album>();
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getWeb() {
        return this.web;
    }

    public String getTipo() {
        return "Artista";
    }

    public DtUsuario getData() {
        return null;
    }

    public HashMap<String, Album> getAlbumes() {
        return albumes;
    }

    public ArrayList<DtAlbum> obtenerAlbumes() {
        return null;
    }

    public DtAlbumContenido obtenerAlbumContenido(String nomAlbum) {
        return null;
    }

    public DtPerfilUsuario obtenerPerfil() {
        return null;
    }

    public void ingresarAlbum(String nom, int anio, ArrayList<Genero> generos/*, Imagen img*/, ArrayList<Tema> temas) {
        return;
    }
}
