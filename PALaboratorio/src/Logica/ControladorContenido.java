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
    private Artista artista;
    private Genero genero;

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
        //this.dbPersona=new DBPersona();
    }

    public boolean selectArtista(String nick) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public List<DtTema> selecListaDef(String nombre) {

        ListaDefecto aux = listasDefecto.get(nombre);

        if (aux == null) {
            throw new UnsupportedOperationException("No existe la lista");
        }

        List<DtTema> res = aux.getTemas();

        if (res.isEmpty()) {
            throw new UnsupportedOperationException("No hay temas en esta lista");
        }
        return res;
    }

    public boolean quitarTema(String nombreT, String nombre) {

        Lista lista = (ListaDefecto) listasDefecto.get(nombre);

        if (lista == null) {
            throw new UnsupportedOperationException("No existe la lista");
        }

        return lista.quitarTema(nombreT);
    }

    public List<DtTema> selecLista(String nick, String nomL) {
        Cliente us = (Cliente) ControladorUsuario.getInstance().getUsuario(nick);

        if (us == null) {
            throw new UnsupportedOperationException("No existe el usuario" + nick + " en el sistema.");
        }

        Lista lista = us.getLista(nomL);

        List<DtTema> temas = lista.getTemas();

        if (temas == null) {
            throw new UnsupportedOperationException("No hay temas en la lista " + nomL + ".");
        } else {
            return temas;
        }
    }

    @Override
    public boolean publicarLista(String nick, String nomL) {
        Cliente us = (Cliente) ControladorUsuario.getInstance().getUsuario(nick);

        if (us == null) {
            throw new UnsupportedOperationException("No existe el usuario" + nick + " en el sistema.");
        }

        ListaParticular l = (ListaParticular) us.getLista(nomL);

        if (l == null) {
            throw new UnsupportedOperationException("No existe la lista" + nomL + " en el sistema.");
        }

        l.setPrivada(false);

        return true;
    }
}
