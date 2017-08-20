package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
