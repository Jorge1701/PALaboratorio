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

public class ControladorUsuario implements IUsuario {

    private static ControladorUsuario controladorUsuario;

    public static ControladorUsuario getControladorUsuario() {
        if (controladorUsuario == null) {
            controladorUsuario = new ControladorUsuario();
        }

        return controladorUsuario;
    }

    private ControladorUsuario() {
    }

    private static ControladorUsuario instancia;
    private Map<String, Usuario> usuarios;
    
    public static ControladorUsuario getInstance(){
        if (instancia == null){
            instancia = new ControladorUsuario();
        }
        return instancia;
    }    

    private ControladorUsuario(){
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.usuarios=new HashMap<String, Usuario>();
        //this.dbPersona=new DBPersona();
    }
    
    public Artista selectArtista(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ingresarUsuario(DtUsuario dtu) {
        
    }

    public ArrayList<DtArtista> listarArtistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DtPerfilArtista obtenerPerfilArtista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DtPerfilCliente obtenerPerfilCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DtCliente getCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void seguirUsuario(String nickC, String nickU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dejarSeguirUsuario(String nickC, String nickU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
