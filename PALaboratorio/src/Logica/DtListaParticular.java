package Logica;

import java.util.ArrayList;

public class DtListaParticular extends DtLista{
    
    private final boolean privada;

    public DtListaParticular(boolean privada, String nombre, ArrayList<DtTema> temas) {
        super(nombre, temas);
        this.privada = privada;
    }

    public boolean isPrivada() {
        return privada;
    }
}
