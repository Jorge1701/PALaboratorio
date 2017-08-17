package Logica;

import java.util.ArrayList;
import java.util.List;

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
    public List<DtTema> selecListaDef(String nombre);
    public boolean quitarTema(String nombreT,String nombre);
    public List<DtTema> selecLista(String nick,String nomL);
    public boolean publicarLista(String nick,String nomL);
    public ArrayList<DtLista> listarLisReproduccionGen(String nomGen);
    public DtLista selecListGen(String nombreL);
        
    
}
