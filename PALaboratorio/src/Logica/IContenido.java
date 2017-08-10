package Logica;

import java.util.ArrayList;

public interface IContenido {
    
    public boolean selectArtista(String nick);
    public DtGenero listarGenero();
    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre);
    public void crearListaReproduccionDefecto(String nombre, String genero);
    public void crearListaReproduccionParticular(String nombre, String nick);
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, /*Imagen img*/ ArrayList<DtTema> temas);
}