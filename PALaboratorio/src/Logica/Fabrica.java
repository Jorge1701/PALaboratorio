package Logica;

import Persistencia.CargaDatosPrueba;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Fabrica {

    public static void inicializarControladores() {
        ControladorUsuario.cargarInstancia();
        ControladorContenido.cargarInstancia();
        getIControladorContenido().setIUsuario(getIControladorUsuario());
    }

    public static void cargaDatosPrueba() throws Exception {
        CargaDatosPrueba cdp = new CargaDatosPrueba();
        if (!cdp.borrarTodosLosDatos()) {
            throw new Exception("Error : no se puedieron borrar los datos previos");
        }

        inicializarControladores();

        if (!cdp.insertarDatosPrueba()) {
            throw new Exception("Error : no se puedieron levantar los datos de la BD");
        }

        levantarDatos();
    }

    public static void levantarDatos() throws Exception {
        CargaDatosPrueba cdp = new CargaDatosPrueba();
        IUsuario iu = getIControladorUsuario();
        IContenido ic = getIControladorContenido();

        // Cargar Usuarios (Clientes y Artistas)
        ArrayList<DtUsuario> usuarios = cdp.cargarUsuarios();
        if (usuarios == null) {
            throw new Exception("Error : Los usuarios no puedieron ser cargados");

        }

        for (DtUsuario dtu : usuarios) {
            iu.levantarUsuario(dtu);
        }

        // Cargar Inforamacion de quien sigue a quien
        ArrayList<String[]> relaciones = cdp.loadFollowers();
        if (relaciones == null) {
            throw new Exception("Error : Las relaciones de seguimiento no pudieron ser cargadas");
        }

        for (String[] r : relaciones) {
            Usuario cliente = iu.obtenerUsuario(r[0]);
            Usuario usuario = iu.obtenerUsuario(r[1]);
            ((Cliente) cliente).agregar(usuario);
        }

        // Cargar Generos
        ArrayList<String[]> generos = cdp.cargarGeneros();
        while (generos.size() > 0) {
            for (int i = 0; i < generos.size(); i++) {
                String[] genero = generos.get(i);
                if (ic.existeGenero(genero[1])) {
                    ic.cargarGenero(genero[0], genero[1]);
                    generos.remove(i);
                }
            }
        }

        // Cargar Albumes
        ArrayList<DtAlbum> dtas = cdp.cargarAlbumes();
        for (DtAlbum dta : dtas) {
            Album a = new Album(dta.getNickArtista(), dta.getNombre(), dta.getAnio(), dta.getImagen());

            // Cargar Generos del album
            ArrayList<Genero> albumGeneros = new ArrayList<>();
            for (String g : cdp.cargarGenerosAlbum(dta.getNickArtista(), dta.getNombre())) {
                Genero genero = ic.obtenerGenero(g);
                genero.cargarAlbum(a);
                albumGeneros.add(genero);
            }
            a.setGeneros(albumGeneros);

            // Cargar Temas del album
            HashMap<String, Tema> temas = new HashMap<>();
            for (DtTema dtt : cdp.cargarTemasAlbum(dta.getNickArtista(), dta.getNombre())) {
                if (dtt instanceof DtTemaLocal) {
                    DtTemaLocal dttl = (DtTemaLocal) dtt;
                    temas.put(dttl.getNombre(), new TemaLocal(dttl.getDirectorio(), dttl.getNombre(), dttl.getDuracion(), dttl.getUbicacion()));
                } else {
                    DtTemaRemoto dttr = (DtTemaRemoto) dtt;
                    temas.put(dttr.getNombre(), new TemaRemoto(dttr.getNombre(), dttr.getDuracion(), dttr.getUbicacion(), dttr.getUrl()));
                }
            }
            a.setTemas(temas);

            // Ingregas album al controlador
            iu.cargarAlbum(a);
        }
        ArrayList<String[]> listasParticulares = cdp.cargarListasParticulares();

        if (listasParticulares == null) {
            throw new Exception("Error : Las listas particulares no puedieron ser cargadas");
        } else {
            ic.levantarListas(listasParticulares);
        }

        /*ArrayList<String[]> listasDefecto = cdp.cargarListasDefecto();
        if (listasDefecto == null) {
            throw new Exception("Error : Las listas por defecto no puedieron ser cargadas");
        } else {
            ic.levantarListas(listasDefecto);
        }*/
    }

    public static IUsuario getIControladorUsuario() {
        IUsuario ICU = ControladorUsuario.getInstance();
        return ICU;
    }

    public static IContenido getIControladorContenido() {
        IContenido ICC = ControladorContenido.getInstance();
        return ICC;
    }
}
