package Logica;

import java.util.ArrayList;

public interface IUsuario {
    
    public Artista selectArtista(String nick);
    public void ingresarUsuario(DtUsuario dtu);
    public ArrayList<DtArtista> listarArtistas();
    public DtPerfilArtista obtenerPerfilArtista();
    public DtPerfilCliente obtenerPerfilCliente();
    public DtCliente getCliente();
    public void seguirUsuario(String nickC, String nickU);
    public void dejarSeguirUsuario(String nickC, String nickU);
}
