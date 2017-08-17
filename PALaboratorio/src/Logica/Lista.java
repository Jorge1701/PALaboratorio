package Logica;

import java.util.ArrayList;

public abstract class Lista {
    
    private String nombre;
    protected ArrayList<Tema> temas;

    public Lista(String nombre, ArrayList<Tema> temas) {
        this.nombre = nombre;
        this.temas = temas;
    }
    
    public abstract DtLista getData();

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtTema> getTemas() {
        ArrayList<DtTema> temas = new ArrayList<>();
        
        for (Tema t : this.temas)
            if(t instanceof TemaLocal)
            temas.add(((TemaLocal)t).getData());
        else
            temas.add(((TemaRemoto)t).getData());  
        
        return temas;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    
    public abstract boolean quitarTema(String nombreT);
}
