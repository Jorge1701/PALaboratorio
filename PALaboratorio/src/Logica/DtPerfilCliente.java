package Logica;

import java.util.ArrayList;

public class DtPerfilCliente extends DtPerfilUsuario{
    
    private final ArrayList<DtUsuario> seguidos;

    public DtPerfilCliente(ArrayList<DtUsuario> seguidos, DtUsuario info, ArrayList<DtCliente> seguidores) {
        super(info, seguidores);
        this.seguidos = seguidos;
    }

    public ArrayList<DtUsuario> getSeguidos() {
        return seguidos;
    }
}
