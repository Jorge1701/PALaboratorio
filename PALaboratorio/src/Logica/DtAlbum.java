package Logica;

public class DtAlbum {
    
    private String nickArtista;
    private String nombre;
    private int anio;
    // private Imagen imagen;
    
    public DtAlbum(String nickArtista, String nombre, int anio /*Imagen imagen*/) {
        this.nickArtista = nickArtista;
        this.nombre = nombre;
        this.anio = anio;
        // this.imagen = imagen;
    }
    
    public String getNickArtista() {
        return nickArtista;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getAnio() {
        return anio;
    }
    
    /*
    public Imagen getImagen() {
        return imagen;
    }*/
}
