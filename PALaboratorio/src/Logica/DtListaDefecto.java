package Logica;

import java.util.ArrayList;

public class DtListaDefecto extends DtLista {
    
    private final DtGenero genero;

    public DtListaDefecto(DtGenero genero, String nombre, ArrayList<DtTema> temas, Imagen imagen) {
        super(nombre, temas, imagen);
        this.genero = genero;
    }

    public DtGenero getGenero() {
        return genero;
    }
}
