package Logica;

//import Persistencia.BDUsuario;
import Persistencia.BDCliente;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorContenido implements IContenido {

    private static ControladorContenido instancia;
    private Map<String, ListaDefecto> listasDefecto;
    private Artista artista;
    private Genero genero;
    private Genero generoRecordado;

    private Cliente clienteFav;

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
        genero = new Genero("Géneros");

        //this.dbPersona=new DBPersona();
        //this.genero.agregarGenero("Géneros", "Rock");
        //this.genero.agregarGenero("Rock", "Rock clásico");
        //this.genero.agregarGenero("Géneros", "Electrónica");
        //this.genero.agregarGenero("Electrónica", "Electro house");
        //this.genero.agregarGenero("Géneros", "Pop");
        //this.genero.agregarGenero("Géneros", "Cumbia");
        //this.genero.agregarGenero("Cumbia", "Cumbia cheta");
        //this.genero.agregarGenero("Cumbia", "Cumbia de negro");
    }

    @Override
    public void indicarCliente(String nick) {
        Usuario u = Fabrica.getInstance().getIControladorUsuario().obtenerUsuario(nick);

        if (u == null) {
            throw new UnsupportedOperationException("Usuario " + nick + " no existe");
        }

        if (!(u instanceof Cliente)) {
            throw new UnsupportedOperationException("El usuario " + nick + " debe ser un cliente");
        }

        clienteFav = (Cliente) u;
    }

    @Override
    public void guardarTema(String nickArtista, String nomAlbum, String nomTema) {
        Usuario u = Fabrica.getInstance().getIControladorUsuario().obtenerUsuario(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario " + nickArtista + " debe ser un artista");
        }

        Album album = ((Artista) u).getAlbum(nomAlbum);

        if (album == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no tiene ningun album llamado " + nomAlbum);
        }

        Tema tema = album.getTema(nomTema);

        if (tema == null) {
            throw new UnsupportedOperationException("El album " + nomAlbum + " no tiene ningun tema llamado " + nomTema);
        }

        try {
            BDCliente bdc = new BDCliente();
            //boolean ok = bdc.agregarTemaFav();

            //if (!ok)
            // throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            clienteFav.agregarTemaFav(tema);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void guardarListaDefault(String nomGenero, String nomLista) {
        Genero g = genero.obtener(nomGenero);

        if (g == null) {
            throw new UnsupportedOperationException("El genero " + nomGenero + " no existe");
        }

        ListaDefecto l = g.getListaDefecto(nomLista);

        if (l == null) {
            throw new UnsupportedOperationException("La lista " + nomLista + " no existe dentro del genero " + nomGenero);
        }

        try {
            BDCliente bdc = new BDCliente();
            boolean ok = bdc.agregarListaDefaultFav(nomGenero, nomLista, clienteFav.getNickname());

            if (!ok) {
                throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            }

            clienteFav.agregarListaFav(l);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void guardarListaParticular(String nickCliente, String nomLista) {
        Usuario u = Fabrica.getInstance().getIControladorUsuario().obtenerUsuario(nickCliente);

        if (u == null) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no existe");
        }

        if (!(u instanceof Cliente)) {
            throw new UnsupportedOperationException("El usuario " + nickCliente + " debe ser un cliente");
        }

        ListaParticular l = ((Cliente) u).getListaParticular(nomLista);

        if (l == null) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no tinene ninguna lista llamada " + nomLista);
        }

        try {
            BDCliente bdc = new BDCliente();
            boolean ok = bdc.agregarListaParticularFav(nickCliente, nomLista, clienteFav.getNickname());

            if (!ok) {
                throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            }

            clienteFav.agregarListaFav(l);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void guardarAlbum(String nickArtista, String nomAlbum) {
        Usuario u = Fabrica.getInstance().getIControladorUsuario().obtenerUsuario(nickArtista);

        if (u == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario " + nickArtista + " debe ser un artista");
        }

        Album album = ((Artista) u).getAlbum(nomAlbum);

        if (album == null) {
            throw new UnsupportedOperationException("El artista " + nickArtista + " no tiene ningun album llamado " + nomAlbum);
        }

        try {
            BDCliente bdc = new BDCliente();
            boolean ok = bdc.agregarAlbumFav(nickArtista, nomAlbum, clienteFav.getNickname());

            if (!ok) {
                throw new UnsupportedOperationException("Error al agregar datos en la base de datos");
            }

            clienteFav.agregarAlbumFav(album);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void eliminarTema(int i) {
        try {
            clienteFav.eliminarTemaFav(i);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void eliminarListaFavoritos(int i) {
        try {
            clienteFav.eliminarListaFav(i);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public void eliminarAlbum(int i) {
        try {
            clienteFav.eliminarAlbumFav(i);
            clienteFav = null;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Override
    public boolean selectArtista(String nick) {
        this.artista = ControladorUsuario.getInstance().selectArtista(nick);
        if (this.artista != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DtGenero listarGenero() {
        return genero.getData();
    }

    @Override
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

    @Override
    public void crearListaReproduccionDefecto(String nombre, String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaReproduccionParticular(String nombre, String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarAlbum(String nom, int anio, ArrayList<String> generos, ArrayList<DtTema> temas) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        ArrayList<Genero> lstGeneros = new ArrayList<Genero>();
        HashMap<String, Tema> mapTemas = new  HashMap<String, Tema>();
        
        if (generos.isEmpty()){
            throw new UnsupportedOperationException("Debe de indicar al menos un Genero");
        }
        
        for(int i =0; i< generos.size(); i++){
            String nomG = generos.get(i);
            lstGeneros.add(this.genero.obtener(nomG));
            //mapGeneros.put(nomG, this.genero.obtener(nomG));           
            
        }
        
         if (temas.isEmpty()){
            throw new UnsupportedOperationException("Debe de indicar al menos un Tema");
        }       
        
        for(int i = 0; i< temas.size(); i++){
            DtTema dtT = (DtTema) temas.get(i);
            Tema t = new Tema(dtT.getNombre(), dtT.getDuracion(), dtT.getUbicacion());
            mapTemas.put(dtT.getNombre(), t);
            //lstTemas.add(t);
        }
        
        
        this.artista.ingresarAlbum(nom, anio, lstGeneros, mapTemas);
        
        //set null artista seleccionado
        this.artista = null;
        
    
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

    public ArrayList<DtTema> selecListaDef(String nombre) {

        ListaDefecto aux = listasDefecto.get(nombre);

        if (aux == null) {
            throw new UnsupportedOperationException("No existe la lista");
        }

        ArrayList<DtTema> res = aux.getTemas();

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

    public ArrayList<DtTema> selecLista(String nick, String nomL) {
        Cliente us = (Cliente) ControladorUsuario.getInstance().getUsuario(nick);

        if (us == null) {
            throw new UnsupportedOperationException("No existe el usuario" + nick + " en el sistema.");
        }

        Lista lista = us.getLista(nomL);

        ArrayList<DtTema> temas = lista.getTemas();

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
