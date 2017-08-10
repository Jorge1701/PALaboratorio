package Logica;

import java.util.List;
import java.util.ArrayList;
import Logica.Usuario;
//import Persistencia.BDUsuario;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;

public class ControladorContenido implements IContenido {
    
    private static ControladorContenido instancia;
    private Map<String, ListaDefecto> listasDefecto;
    
 public static ControladorContenido getInstance(){
        if (instancia == null){
            instancia = new ControladorContenido();
        }
        return instancia;
    } 
    
 private ControladorContenido(){
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.listasDefecto=new HashMap<String, ListaDefecto>();
        //this.dbPersona=new DBPersona();
    }
    
    public boolean selectArtista(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public DtGenero listarGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public DtAlbumContenido obtenerAlbumContenido(String nickArt, String nomAlbum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void crearListaReproduccionDefecto(String nombre, String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void crearListaReproduccionParticular(String nombre, String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, ArrayList<DtTema> temas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}