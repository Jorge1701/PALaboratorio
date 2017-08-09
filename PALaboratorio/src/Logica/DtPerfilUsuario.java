package Logica;

import java.util.ArrayList;

public class DtPerfilUsuario {
    
    private DtUsuario info;
    private ArrayList<DtCliente> seguidores;

    public DtPerfilUsuario(DtUsuario info, ArrayList<DtCliente> seguidores) {
        this.info = info;
        this.seguidores = seguidores;
    }

    public DtUsuario getInfo() {
        return info;
    }

    public ArrayList<DtCliente> getSeguidores() {
        return seguidores;
    }
}
