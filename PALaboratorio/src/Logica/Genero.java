package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Genero {

    private String nombre;
    private HashMap<String, Genero> subgeneros;
    private HashMap<String, Album> albumes;
    private HashMap<String, ListaDefecto> listasDefecto;

    public Genero(String nombre, HashMap<String, Genero> subgeneros, HashMap<String, Album> albumes, HashMap<String, ListaDefecto> listasDefecto) {
        this.nombre = nombre;
        this.subgeneros = subgeneros;
        this.albumes = albumes;
        this.listasDefecto = listasDefecto;
    }

    public void setAlbumes(HashMap<String, Album> albumes) {
        this.albumes = albumes;
    }

    public void setListasDefecto(HashMap<String, ListaDefecto> listasDefecto) {
        this.listasDefecto = listasDefecto;
    }

    public HashMap<String, Album> getAlbumes() {
        return albumes;
    }

    public ListaDefecto getListaDefecto(String nombre) {
        return listasDefecto.get(nombre);
    }
    
    public HashMap<String, ListaDefecto> getListasDefecto() {
        return listasDefecto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSubgeneros(HashMap<String, Genero> subgeneros) {
        this.subgeneros = subgeneros;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Genero> getSubgeneros() {
        return subgeneros;
    }

    public DtGenero getData() {
        return new DtGenero(this.nombre, devolverSubgeneros(this));
    }

    public ArrayList<DtGenero> devolverSubgeneros(Genero g) {                                   //para obtener la lista de Dt de subgeneros recursivamente
        ArrayList<DtGenero> res = new ArrayList<DtGenero>();
        Iterator it = g.subgeneros.entrySet().iterator();
        while (it.hasNext()) {
            Genero genero = (Genero) ((Map.Entry) it.next()).getValue();
            res.add(new DtGenero(genero.getNombre(), genero.devolverSubgeneros(genero)));
        }
        return res;
    }

    public Genero obtener(String nombre) {
        if (this.nombre.equals(nombre)) {
            return this;
        } else {
            Iterator it = subgeneros.entrySet().iterator();
            while (it.hasNext()) {
                Genero genero = (Genero) ((Map.Entry) it.next()).getValue();
                Genero encontrado = genero.obtener(nombre);
                if (encontrado != null) {
                    return encontrado;
                }
            }
            return null;
        }
    }

    public ArrayList<DtAlbum> obtenerAlbumes() {
        ArrayList<DtAlbum> res = new ArrayList<>();
        Iterator it = albumes.entrySet().iterator();
        while (it.hasNext()) {
            Album album = (Album) ((Map.Entry) it.next()).getValue();
            res.add(new DtAlbum(album.getArtista().getNickname(), album.getNombre(), album.getAnio()/*,album.getImagen()*/));
        }
        return res;
    }

}
