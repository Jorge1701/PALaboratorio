package Logica;

import java.util.ArrayList;

public class ListaDefecto extends Lista {
    
    private Genero genero;

    public ListaDefecto(Genero genero, String nombre, ArrayList<Tema> temas, Imagen imagen) {
        super(nombre, temas, imagen);
        this.genero = genero;
    }
    
    @Override
    public DtLista getData() {
        return new DtListaDefecto(genero.getData(), getNombre(), getTemas(), getImagen());
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
