package Logica;

import java.util.ArrayList;

public abstract class Lista {

    private String nombre;
    protected ArrayList<Tema> temas;
    private String imagen;

    public Lista(String nombre, ArrayList<Tema> temas, String imagen) {
        this.nombre = nombre;
        this.temas = temas;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public abstract DtLista getData();

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DtTema> getTemas() {
        ArrayList<DtTema> temas = new ArrayList<>();

        for (Tema t : this.temas) {
            if (t instanceof TemaLocal) {
                temas.add(((TemaLocal) t).getData());
            } else {
                temas.add(((TemaRemoto) t).getData());
            }
        }

        return temas;
    }

    public ArrayList<Tema> obtenerTemas() {
        ArrayList<Tema> temas = new ArrayList<>();

        for (Tema t : this.temas) {
            if (t instanceof TemaLocal) {
                temas.add(t);
            } else {
                temas.add(t);
            }
        }

        return temas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public abstract boolean quitarTema(String nombreT);
}
