package Logica;

import java.util.ArrayList;

public interface IContenido {
    
    public void indicarCliente(String nick);
    public void guardarTema(String nickArtista, String nomAlbum, String nomTema);
    public void guardarListaDefault(String nomGenero, String nomLista);
    public void guardarListaParticular(String nickCliente, String nomLista);
    public void guardarAlbum(String nickArtista, String nomAlbum);
    public void eliminarTema(int i);
    public void eliminarListaFavoritos(int i);
    public void eliminarAlbum(int i);
    public boolean selectArtista(String nick);
    public DtGenero listarGenero();
    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre);
    public void crearListaReproduccionDefecto(String nombre, String genero);
    public void crearListaReproduccionParticular(String nombre, String nick);
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, /*Imagen img*/ ArrayList<DtTema> temas);
}