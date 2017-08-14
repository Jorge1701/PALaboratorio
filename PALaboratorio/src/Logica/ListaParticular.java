package Logica;

import java.util.ArrayList;

public class ListaParticular extends Lista {
    
    private boolean privada;

    public ListaParticular(boolean privada, String nombre, ArrayList<Tema> temas) {
        super(nombre, temas);
        this.privada = privada;
    }
    
    @Override
    public DtLista getData() {
        return new DtListaParticular(isPrivada(), getNombre(), getTemas());
    }

    public boolean isPrivada() {
        return privada;
    }

    public void setPrivada(boolean privada) {
        this.privada = privada;
    }
    
    public boolean quitarTema(String nombreT){
    return false;
    }
}
