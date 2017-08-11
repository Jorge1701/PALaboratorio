package Logica;

import java.util.ArrayList;

public abstract class Lista {
    
    private String nombre;
    private ArrayList<Tema> temas;
    private Imagen imagen;

    public Lista(String nombre, ArrayList<Tema> temas, Imagen imagen) {
        this.nombre = nombre;
        this.temas = temas;
        this.imagen = imagen;
    }
    
    public abstract DtLista getData();

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtTema> getTemas() {
        ArrayList<DtTema> temas = new ArrayList<>();
        
        for (Tema t : this.temas)
            temas.add(t.getData());
        
        return temas;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
