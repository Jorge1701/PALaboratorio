package Logica;

public class DtTema {

    private String nombre;
    private DtTime duracion;
    private int ubicacion;

    public DtTema(String nombre, DtTime duracion, int ubicacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
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
}
