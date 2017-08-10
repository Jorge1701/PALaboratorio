package Logica;

import java.util.ArrayList;

public interface IUsuario {
    
    public Artista selectArtista(String nick);
    public void ingresarUsuario(DtUsuario dtu);
    public ArrayList<DtUsuario> listarClientes();
    public ArrayList<DtUsuario> listarArtistas();
    public DtPerfilUsuario obtenerPerfilArtista(String nickArtista);
    public DtPerfilUsuario obtenerPerfilCliente(String nickCliente);
    public DtCliente getCliente();
    public void seguirUsuario(String nickC, String nickU);
    public void dejarSeguirUsuario(String nickC, String nickU);
    public void cargarUsuarios();
}
