package Logica;

import Persistencia.CargaDatosPrueba;

public class Fabrica {

    //SINGLETON
    private static Fabrica instancia;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    private Fabrica() {

    }

    public void cargarDatosPrueba() throws Exception {
        CargaDatosPrueba cdp = new CargaDatosPrueba();

        if (!cdp.borrarTodosLosDatos()) {
            throw new Exception("No se pudieron borrar los datos viejos de la base de datos para ingresar los de prueba.");
        }
        
        
        
        IUsuario iu = this.getIControladorUsuario();
        iu.cargarUsuarios();
    }

    public IUsuario getIControladorUsuario() {
        IUsuario ICU = ControladorUsuario.getInstance();
        return ICU;
    }

    public IContenido getIControladorContenido() {
        IContenido ICC = ControladorContenido.getInstance();
        return ICC;
    }
}
