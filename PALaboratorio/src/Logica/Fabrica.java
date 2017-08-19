package Logica;

import Persistencia.CargaDatosPrueba;
import java.util.ArrayList;
import java.util.HashMap;

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

        if (!cdp.levantarDatos()) {
            throw new Exception("Error : no se puedieron levantar los datos de la BD");
        }

        levantarDatos();
    }

    public static void levantarDatos() throws Exception {
        CargaDatosPrueba cdp = new CargaDatosPrueba();
        IUsuario iu = getIControladorUsuario();

        ArrayList<DtUsuario> usuarios = cdp.cargarUsuarios();
        if (usuarios == null) {
            throw new Exception("Error : Los usuarios no puedieron ser cargados");
        }

        for (DtUsuario dtu : usuarios) {
            iu.levantarUsuario(dtu);
        }

        ArrayList<String[]> relaciones = cdp.loadFollowers();
        if (relaciones == null) {
            throw new Exception("Error : Las relaciones de seguimiento no pudieron ser cargadas");
        }
        
        for (String[] r : relaciones) {
            Usuario cliente = iu.obtenerUsuario(r[0]);
            Usuario usuario = iu.obtenerUsuario(r[1]);
            ((Cliente) cliente).agregar(usuario);
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
