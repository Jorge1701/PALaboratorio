package Logica;

import java.util.ArrayList;
//import Persistencia.BDUsuario;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ControladorUsuario implements IUsuario {
    
    private static ControladorUsuario instancia;
    private Map<String, Usuario> usuarios;
    //private DBPersona dbPersona=null;

    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
    
    private ControladorUsuario() {
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.usuarios = new HashMap<String, Usuario>();
        //this.dbPersona=new DBPersona();
    }
    
    public Artista selectArtista(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void ingresarUsuario(DtUsuario dtu) {
        
    }
    
    public ArrayList<DtUsuario> listarClientes() {
        ArrayList<DtUsuario> clientes = new ArrayList<>();
        
        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();
            
            if (u instanceof Cliente)
                clientes.add(u.getData());
        }
        
        return clientes;
    }

    public ArrayList<DtUsuario> listarArtistas() {
        ArrayList<DtUsuario> artistas = new ArrayList<>();
        
        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();
            
            if (u instanceof Artista)
                artistas.add(u.getData());
        }
        
        return artistas;
    }

    public DtPerfilUsuario obtenerPerfilArtista(String nickArtista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DtPerfilUsuario obtenerPerfilCliente(String nickCliente) {
        Usuario u = usuarios.get(nickCliente);
        
        if (u == null)
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no existe");
        
        if (!(u instanceof Cliente))
            throw new UnsupportedOperationException("Este usuario no es un cliente");
        
        return ((Cliente) u).obtenerPerfil();
    }
    
    public DtCliente getCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void seguirUsuario(String nickCliente, String nickSeguido) {
        Usuario cliente = usuarios.get(nickCliente);
        Usuario seguido = usuarios.get(nickSeguido);
        
        if (cliente == null) {
            throw new UnsupportedOperationException("Cliente no existe.");
        }
        
        if (seguido == null) {
            throw new UnsupportedOperationException("Usuario a seguir no existe.");
        }
        
        if (!(cliente instanceof Cliente)) {
            throw new UnsupportedOperationException("Usuario no es un cliente.");
        }
        ((Cliente) cliente).agregar(seguido);
    }
    
    public void dejarSeguirUsuario(String nickUsuario, String nickSeguidor) {
        Usuario usuario = usuarios.get(nickUsuario);
        Usuario seguidor = usuarios.get(nickSeguidor);
        
        if (usuario == null) {
            throw new UnsupportedOperationException("Usuario no existe");
        }
        
        if (seguidor == null) {
            throw new UnsupportedOperationException("Seguidor no existe");
        }
        
        if (!(usuario instanceof Cliente)) {
            throw new UnsupportedOperationException("Usuario no es un cliente.");
        }
        
        ((Cliente) usuario).dejarSeguir(seguidor);
    }
    
    @Override
    public void cargarUsuarios() {
        
    }
    
}
