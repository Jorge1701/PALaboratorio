package Logica;

import java.util.ArrayList;

public class ListaParticular extends Lista {
    
    private boolean privada;

    public ListaParticular(boolean privada, String nombre, ArrayList<Tema> temas, Imagen imagen) {
        super(nombre, temas, imagen);
        this.privada = privada;
    }
    
    @Override
    public DtLista getData() {
        return new DtListaParticular(isPrivada(), getNombre(), getTemas(), getImagen());
    }

    public boolean isPrivada() {
        return privada;
    }

    public void setPrivada(boolean privada) {
        this.privada = privada;
    }
}
