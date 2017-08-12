package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ListaDefecto extends Lista {
    
    private Genero genero;

    public ListaDefecto(Genero genero, String nombre, ArrayList<Tema> temas) {
        super(nombre, temas);
        this.genero = genero;
    }
    
    @Override
    public DtLista getData() {
        return new DtListaDefecto(genero.getData(), getNombre(), getTemas());
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public boolean quitarTema(String nombreT){
        
        Iterator i = this.temas.iterator();
        while (i.hasNext()) {
            Tema t = (Tema) ((Map.Entry) i.next()).getValue();
         if(t.getNombre().equals(nombreT)){
         this.temas.remove(t);
         return true;
         }
        }
    return false;
    }
}
