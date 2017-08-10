package Logica;

public class Fabrica {
    
    
    //SINGLETON
    private static Fabrica instancia;

    public static Fabrica getInstance(){
        if (instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }    
    
    private Fabrica(){
        this.cargarDatosPrueba();
    };
    
    private void cargarDatosPrueba(){
        IUsuario iu=this.getIControladorUsuario();
        iu.cargarUsuarios();
    }
    
    public IUsuario getIControladorUsuario() {
        IUsuario ICU = ControladorUsuario.getInstance();
        return ICU;
    } 
}
