package Logica;

import java.util.ArrayList;

public class DtLista {
    
    private final String nombre;
    private final ArrayList<DtTema> temas;

    public DtLista(String nombre, ArrayList<DtTema> temas) {
        this.nombre = nombre;
        this.temas = temas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtTema> getTemas() {
        return temas;
    }

  
}
