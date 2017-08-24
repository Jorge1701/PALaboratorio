package Logica;

import Persistencia.CargaDatosPrueba;
import java.util.ArrayList;

public class Fabrica {

    //SINGLETON
    /* private static Fabrica instancia;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    private Fabrica() {
        levantarDatos();
    }
     */
    public static void inicializarControladores() {
        ControladorUsuario.cargarInstancia();
        ControladorContenido.cargarInstancia();
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
        ArrayList< String[]> generos = cdp.cagarGeneros();
        for (String[] genero : generos) {
            ic.cargarGenero(genero[0], genero[1]);
        }

        // Cargar Albumes
        ArrayList<DtAlbum> dtas = cdp.cargarAlbumes();
        for (DtAlbum dta : dtas) {
            Album a = new Album(dta.getNickArtista(), dta.getNombre(), dta.getAnio(), null);

            // Cargar Generos del album
            ArrayList<Genero> albumGeneros = new ArrayList<>();
            for (String g : cdp.cargarGenerosAlbum(dta.getNickArtista(), dta.getNombre())) {
                Genero genero = ic.obtenerGenero(g);
                genero.cargarAlbum(a);
                albumGeneros.add(genero);
            }
            a.setGeneros(albumGeneros);

            // Cargar Temas del album
            iu.cargarAlbum(a);
        }
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
