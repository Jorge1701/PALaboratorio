package Logica;

public class Fabrica {
    
    public static IContenido getIContenido() {
        return ControladorContenido.getControladorContenido();
    }
    
    public static IUsuario getIUsuario() {
        return ControladorUsuario.getControladorUsuario();
    }
    
    public static void cargarDatos() {
        // TODO: Cargar datos de prueba
    }
}
