package Logica;

import java.util.ArrayList;

public interface IUsuario {
    
    public Usuario obtenerUsuario(String nick);
    public Artista selectArtista(String nick);
    public ArrayList<DtUsuario> listarUsuarios();
    public boolean ingresarUsuario(DtUsuario dtu);
    public void levantarUsuario(DtUsuario dtu);
    public ArrayList<DtUsuario> listarClientes();
    public ArrayList<DtUsuario> listarArtistas();
    public DtPerfilUsuario obtenerPerfilArtista(String nickArtista);
    public DtPerfilUsuario obtenerPerfilCliente(String nickCliente);
    public DtCliente getCliente();
    public void seguirUsuario(String nickC, String nickU);
    public void dejarSeguirUsuario(String nickSeguidor, String nickUsuario);
    public void cargarUsuarios();
    public ArrayList<DtAlbum> listarAlbumesArtista(String nickArtista);
    public DtAlbumContenido obtenerAlbumContenido(String nickArt, String nomAlbum);
    public ArrayList<DtCliente> listarSeguidoresDe(String nickUsuario);
    public ArrayList<DtLista> listarListaReproduccionCli(String nickCliente);
    public DtLista selectListaCli(String nombreL);
}
