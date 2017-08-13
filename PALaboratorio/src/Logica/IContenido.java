package Logica;

import java.util.ArrayList;
import java.util.List;

public interface IContenido {
    
    public boolean selectArtista(String nick);
    public DtGenero listarGenero();
    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre);
    public void crearListaReproduccionDefecto(String nombre, String genero);
    public void crearListaReproduccionParticular(String nombre, String nick);
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, /*Imagen img*/ ArrayList<DtTema> temas);
    public List<DtTema> selecListaDef(String nombre);
    public boolean quitarTema(String nombreT,String nombre);
    public List<DtTema> selecLista(String nick,String nomL);
    public boolean publicarLista(String nick,String nomL);
}