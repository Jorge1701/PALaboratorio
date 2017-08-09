package Logica;

import java.util.ArrayList;

public class DtAlbumContenido {

    private DtAlbum info;
    private ArrayList<DtGenero> generos;
    private ArrayList<DtTema> temas;

    public DtAlbumContenido(DtAlbum info, ArrayList<DtGenero> generos, ArrayList<DtTema> temas) {
        this.info = info;
        this.generos = generos;
        this.temas = temas;
    }

    public DtAlbum getInfo() {
        return info;
    }

    public ArrayList<DtGenero> getGeneros() {
        return generos;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }

   
}
