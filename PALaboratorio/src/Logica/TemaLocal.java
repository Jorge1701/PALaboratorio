package Logica;

public class TemaLocal extends Tema {

    public String directorio;

    public TemaLocal(String directorio, String nombre, DtTime duracion, int ubicacion) {
        super(nombre, duracion, ubicacion);
        this.directorio = directorio;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public DtTemaLocal getData() {
        return new DtTemaLocal(this.getDirectorio(), this.getNombre(), this.getDuracion(), this.getUbicacion());
    }
}
