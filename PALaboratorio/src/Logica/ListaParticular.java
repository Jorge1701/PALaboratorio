package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ListaParticular extends Lista {

    private String nickDuenio;
    private boolean privada;

    public ListaParticular(String nickDuenio, boolean privada, String nombre, ArrayList<Tema> temas, String imagen) {
        super(nombre, temas, imagen);
        this.privada = privada;
        this.nickDuenio = nickDuenio;
    }

    public ListaParticular(String nickCliente, String nombre) {
        super(nombre, new ArrayList<>(), null);
        this.privada = true;
        this.nickDuenio = nickDuenio;
    }

    public String getDuenio() {
        return nickDuenio;
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

    public boolean quitarTema(String nombreT) {

        Iterator i = this.temas.iterator();
        while (i.hasNext()) {
            Tema t = (Tema) ((Map.Entry) i.next()).getValue();
            if (t.getNombre().equals(nombreT)) {
                this.temas.remove(t);
                return true;
            }
        }
        return false;

    }
    public boolean agregarTema(Tema tema){
        Iterator i = this.temas.iterator();
        while(i.hasNext()){
         Tema t =  (Tema)((Map.Entry)i.next()).getValue();
         if(t.getNombre().equals(tema.getNombre())){
             return false;
         }
        }
      this.temas.add(tema);
      return true;
    }
}
