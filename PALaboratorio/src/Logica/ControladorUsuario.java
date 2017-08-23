package Logica;

import Persistencia.BDUsuario;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ControladorUsuario implements IUsuario {

    private static ControladorUsuario instancia;

    public static void cargarInstancia() {
        instancia = new ControladorUsuario();
    }

    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            cargarInstancia();
        }
        return instancia;
    }
    private final HashMap<String, Usuario> usuarios;
    private Usuario usuarioRecordado;

    private BDUsuario bdUsuario = null;

    private ControladorUsuario() {
        this.usuarios = new HashMap();
        this.usuarioRecordado = null;
        this.bdUsuario = new BDUsuario();
    }

    @Override
    public Usuario obtenerUsuario(String nick) {
        return usuarios.get(nick);
    }

    @Override
    public Artista selectArtista(String nick) {
        Usuario us = usuarios.get(nick);

        if (us == null) {
            throw new UnsupportedOperationException("El artista " + nick + " no existe");
        }

        if (!(us instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un Artista");
        }

        return (Artista) us;
    }

    @Override
    public boolean ingresarUsuario(DtUsuario dtu) {

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();

            if (u.getNickname() == dtu.getNickname() || u.getEmail() == dtu.getEmail()) {
                return false;
            }
        }

        Usuario usr;
        boolean res = this.bdUsuario.ingresarUsuario(dtu);
        if (res) {

            if (dtu instanceof DtCliente) {
                usr = new Cliente(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), null);
            } else {
                usr = new Artista(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), null, ((DtArtista) dtu).getBiografia(), ((DtArtista) dtu).getWeb());
            }
            this.usuarios.put(usr.getNickname(), usr);

        } else {
            throw new UnsupportedOperationException("No se pudo ingresar el usuario a la BD");
        }

        return res;
    }

    @Override
    public void levantarUsuario(DtUsuario dtu) {
        Usuario u;
        if (dtu instanceof DtCliente) {
            u = new Cliente(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), null);
        } else {
            u = new Artista(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), new DtFecha(dtu.getFechaNac().getDia(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getAnio()), null, ((DtArtista) dtu).getBiografia(), ((DtArtista) dtu).getWeb());
        }
        usuarios.put(u.getNickname(), u);
    }

    @Override
    public ArrayList<DtUsuario> listarUsuarios() {
        ArrayList<DtUsuario> dtUsuarios = new ArrayList<>();

        Iterator i = usuarios.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();
            dtUsuarios.add(u.getData());
        }

        return dtUsuarios;
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
        Usuario u = usuarios.get(nickArtista);
        if (u == null) {
            throw new UnsupportedOperationException("El Artista " + nickArtista + " no existe");
        }

        if (!(u instanceof Artista)) {
            throw new UnsupportedOperationException("Este usuario no es un artista");
        }

        return ((Artista) u).obtenerPerfil();
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

    @Override
    public void seguirUsuario(String nickCliente, String nickSeguido) {
        Usuario cliente = usuarios.get(nickCliente);
        Usuario seguido = usuarios.get(nickSeguido);

        BDUsuario bdu = new BDUsuario();
        if (!((Cliente) cliente).agregar(seguido)) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no pudo seguir al usuario " + nickSeguido);
        }
        if (!bdu.seguirUsuario(nickCliente, nickSeguido)) {
            throw new UnsupportedOperationException("El cliente " + nickCliente + " no pudo seguir al usuario " + nickSeguido);
        }
    }

    @Override
    public void dejarSeguirUsuario(String nickSeguidor, String nickUsuario) {
        Usuario seguidor = usuarios.get(nickSeguidor);
        Usuario usuario = usuarios.get(nickUsuario);

        if (seguidor == null) {
            throw new UnsupportedOperationException("Cliente seguidor no existe");
        }

        BDUsuario bdu = new BDUsuario();
        if (!bdu.dejarDeSeguir(nickSeguidor, nickUsuario)) {
            throw new UnsupportedOperationException("El cliente " + nickSeguidor + " no pudo dejar de seguir al usuario " + nickUsuario);
        }
        if (!((Cliente) seguidor).dejarSeguir(usuario)) {
            throw new UnsupportedOperationException("El cliente " + nickSeguidor + " no pudo dejar de seguir al usuario " + nickUsuario);
        }
    }

    @Override
    public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista) {
        Usuario usuario = usuarios.get(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe");
        }
        if (!(usuario instanceof Artista)) {
            throw new UnsupportedOperationException("Usuario no es un artista");
        }

        return ((Artista) usuario).obtenerAlbumes();
    }

    @Override
    public DtAlbumContenido obtenerAlbumContenido(String nickArtista, String nomAlbum) {
        Usuario usuario = usuarios.get(nickArtista);
        if (usuario == null) {
            throw new UnsupportedOperationException("Artista no existe");
        }
        if (!(usuario instanceof Artista)) {
            throw new UnsupportedOperationException("Usuario no es un artista");
        }

        DtAlbumContenido dt = ((Artista) usuario).obtenerAlbumContenido(nomAlbum);
        if (dt == null) {
            throw new UnsupportedOperationException("Album no existe");
        }

        return dt;
    }

    @Override
    public void cargarUsuarios() {

    }

    public Usuario getUsuario(String nick) {

        Usuario us = usuarios.get(nick);

        if (us == null) {
            throw new UnsupportedOperationException("El usuario " + nick + " no existe");
        } else {
            return us;
        }

    }

    @Override
    public ArrayList<DtUsuario> listarSeguidosDe(String nickCliente) {
        Cliente c = (Cliente) usuarios.get(nickCliente);
        return c.obtenerSeguidos();

    }

    @Override
    public ArrayList<DtCliente> listarSeguidoresDe(String nickUsuario) {
        Usuario u = usuarios.get(nickUsuario);

        if (u == null) {
            throw new UnsupportedOperationException("El cliente no existe");
        }

        return u.getSeguidores();
    }

    public ArrayList<DtLista> listarListaReproduccionCli(String nickCliente) {
        Usuario c = this.usuarios.get(nickCliente);
        if (c == null) {
            throw new UnsupportedOperationException("No existe el Cliente");
        }
        if (!(c instanceof Cliente)) {
            throw new UnsupportedOperationException("Usuario no es un cliente");
        }

        this.usuarioRecordado = c;

        return ((Cliente) c).listarLisReproduccion();
    }

    public DtLista selectListaCli(String nombreL) {
        return ((Cliente) this.usuarioRecordado).seleccionarLista(nombreL);
    }
    
    public ArrayList<DtLista> listarLisReproduccion(String nickCliente){
    return ((Cliente)obtenerUsuario(nickCliente)).listarLisReproduccion();
    }
}
