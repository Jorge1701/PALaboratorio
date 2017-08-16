package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Artista extends Usuario {

    private String biografia;
    private String web;
    private HashMap<String, Album> albumes;

    public Artista(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, Imagen imagen, String biografia, String web) {
        super(nickname, nombre, apellido, email, fechaNac, imagen); //LLama al constructor de Usuario
        this.biografia = biografia;
        this.web = web;
        this.albumes = new HashMap();
        
     
        
       // albumes.put("album1", new Album(this.getNickname(),"album1",2015,null,new HashMap<String, Tema> (),new ArrayList<Genero>()));
       // albumes.put("album2", new Album(this.getNickname(),"album2",2016,null,new HashMap<String, Tema> (),new ArrayList<Genero>()));
       // albumes.put("album3", new Album(this.getNickname(),"album3",2017,null,new HashMap<String, Tema> (),new ArrayList<Genero>()));
    }

    public ArrayList<DtAlbum> obtenerAlbumes() {
        ArrayList<DtAlbum> res = new ArrayList<DtAlbum>();
        Iterator it = albumes.entrySet().iterator();
        while (it.hasNext()) {
            Album album = (Album) ((Map.Entry) it.next()).getValue();
            res.add(new DtAlbum(this.getNickname(), album.getNombre(), album.getAnio()/*,album.getImagen()*/));
        }
        return res;
    }

    public DtAlbumContenido obtenerAlbumContenido(String nomAlbum) {
        DtAlbumContenido dtac = null;
        Album album = albumes.get(nomAlbum);
        if (album != null){
            dtac = album.obtenerAlbumContenido();
        }
        
        return dtac;
    }
    
    public Album getAlbum(String nombre) {
        return albumes.get(nombre);
    }

    public DtPerfilUsuario obtenerPerfil() {
        return null;
    }

    public void ingresarAlbum(String nom, int anio, ArrayList<Genero> generos/*, Imagen img*/, ArrayList<Tema> temas) {
        return;
    }

    @Override
    public String getTipo() {
        return "Artista";
    }

    @Override
    public DtUsuario getData() {
        return new DtArtista(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac(), biografia, web);
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getWeb() {
        return this.web;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }
}
