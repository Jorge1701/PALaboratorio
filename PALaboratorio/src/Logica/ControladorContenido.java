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
import javax.swing.JOptionPane;

public class ControladorContenido implements IContenido {

    private static ControladorContenido instancia;
    private Map<String, ListaDefecto> listasDefecto;
    private Artista artista;
    private Genero genero;
    private Genero generoRecordado;

    public static ControladorContenido getInstance() {
        if (instancia == null) {
            instancia = new ControladorContenido();
        }
        return instancia;
    }

    private ControladorContenido() {
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.listasDefecto = new HashMap<String, ListaDefecto>();
        genero = new Genero("Generos");

        //this.dbPersona=new DBPersona();
    }

    public boolean selectArtista(String nick) {
        this.artista = ControladorUsuario.getInstance().selectArtista(nick);
        if (this.artista != null) {
            return true;
        } else {
            return false;
        }
    }

    public DtGenero listarGenero() {
        return genero.getData();

    }

    public ArrayList<DtAlbum> listarAlbumesGenero(String nombre) {
        Genero gen = genero.obtener(nombre);
        if (gen == null) {
            throw new UnsupportedOperationException("Genero no existe");
        }
        ArrayList al = gen.obtenerAlbumes();
        if (al.isEmpty()) {
            throw new UnsupportedOperationException("No hay albumes en este genero");
        }
        return al;
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

    public ArrayList<DtLista> listarLisReproduccionGen(String nomGen) {
        Genero g = this.genero.obtener(nomGen);
        if (g == null) {
            throw new UnsupportedOperationException("El genero no existe");
        }
        this.generoRecordado = g;
        return g.listarLisReproduccion();
    }

    public DtLista selecListGen(String nombreL) {
        return generoRecordado.seleccionarLista(nombreL);
    }
}
