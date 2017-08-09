package Logica;

import java.util.ArrayList;

class DtPerfilArtista extends DtPerfilUsuario {
    
    private ArrayList<DtAlbum> albumes;

    public DtPerfilArtista(ArrayList<DtAlbum> albumes, DtUsuario info, ArrayList<DtCliente> seguidores) {
        super(info, seguidores);
        this.albumes = albumes;
    }

    public ArrayList<DtAlbum> getAlbumes() {
        return albumes;
    }
}
