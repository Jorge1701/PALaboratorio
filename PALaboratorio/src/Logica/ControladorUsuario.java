package Logica;

import Persistencia.BDUsuario;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import jdk.nashorn.internal.objects.NativeArray;

public class ControladorUsuario implements IUsuario {

    private static ControladorUsuario instancia;
    private Map<String, Usuario> usuarios;
    private BDUsuario bdUsuario=null;

    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    private ControladorUsuario() {
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.usuarios = new HashMap();
        this.bdUsuario=new BDUsuario();
    }

    @Override
    public Artista selectArtista(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresarUsuario(DtUsuario dtu) {

        ArrayList<Usuario> usr = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u.getNickname() == dtu.getNickname() || u.getEmail() == dtu.getEmail()) {
                return false;
            }
        }
        if (dtu instanceof DtCliente) {
            Usuario c = new Cliente(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), null);
            boolean res =this.bdUsuario.ingresarUsuario(c);
            if (res){
                //Colección genérica común
                //this.personas.add(p);
                this.usuarios.put(c.getNickname(), c);
            }
            return res;
        } else {
            Usuario a = new Artista(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), null, ((DtArtista) dtu).getBiografia(), ((DtArtista) dtu).getWeb());
            boolean res =this.bdUsuario.ingresarUsuario(a);
            if (res){
                //Colección genérica común
                //this.personas.add(p);
                this.usuarios.put(a.getNickname(), a);
            }
            return res;
        }

    }

    @Override
    public ArrayList<DtUsuario> listarClientes() {
        ArrayList<DtUsuario> clientes = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u instanceof Cliente) {
                clientes.add(u.getData());
            }
        }

        return clientes;
    }

    @Override
    public ArrayList<DtUsuario> listarArtistas() {
        ArrayList<DtUsuario> artistas = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u instanceof Artista) {
                artistas.add(u.getData());
            }
        }

        return artistas;
    }

    @Override
    public DtPerfilUsuario obtenerPerfilArtista(String nickArtista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtPerfilUsuario obtenerPerfilCliente(String nickCliente) {
        Usuario u = usuarios.get(nickCliente);

        if (u == null) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no existe");
        }

        if (!(u instanceof Cliente)) {
            throw new UnsupportedOperationException("Este usuario no es un cliente");
        }

        return ((Cliente) u).obtenerPerfil();
    }

    @Override
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

    @Override
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

    public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista) {
        Usuario usuario = usuarios.get(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe"); 
        }
        if (!(usuario instanceof Artista)){
            throw new UnsupportedOperationException("Usuario no es un artista"); 
        }
        
        return  ((Artista) usuario).obtenerAlbumes();
    }
    
     public DtAlbumContenido obtenerAlbumContenido(String nickArtista, String nomAlbum) {
         Usuario usuario = usuarios.get(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe"); 
        }
        if (!(usuario instanceof Artista)){
            throw new UnsupportedOperationException("Usuario no es un artista"); 
        }
        
        DtAlbumContenido dt = ((Artista) usuario).obtenerAlbumContenido(nomAlbum);
        if(dt == null){
            throw new UnsupportedOperationException("Album no existe"); 
        }
        
        return dt;
    }

    @Override
    public void cargarUsuarios() {

    }

}
