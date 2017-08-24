package Logica;

public class Tema {

    private int id;
    private String nombre;
    private DtTime duracion;
    private int ubicacion;

    public Tema(String nombre, DtTime duracion, int ubicacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DtTema getData() {
        return new DtTema(nombre, duracion, ubicacion);
    }

    public String getNombre() {
        return nombre;
    }

    public DtTime getDuracion() {
        return duracion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(DtTime duracion) {
        this.duracion = duracion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
}
