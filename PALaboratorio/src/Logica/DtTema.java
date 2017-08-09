package Logica;

class DtTema {
    
    private String nombre;
    private int duracion;
    private int ubicacion;

    public DtTema(String nombre, int duracion, int ubicacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getUbicacion() {
        return ubicacion;
    }
}
