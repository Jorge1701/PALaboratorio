package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cliente extends Usuario {

    private HashMap<String, Usuario> seguidos;
    private HashMap<String, ListaParticular> listasParticulares;

    private ArrayList<Album> albumes;
    private ArrayList<Lista> listas;
    private ArrayList<Tema> temas;

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, Imagen imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);

        this.seguidos = new HashMap();
        this.listasParticulares = new HashMap();
        this.albumes = new ArrayList<>();
        this.listas = new ArrayList<>();
        this.temas = new ArrayList<>();

    }

    public void agregarAlbumFav(Album a) {
        if (albumes.contains(a)) {
            throw new UnsupportedOperationException("Album ya en favoritos");
        } else {
            albumes.add(a);
        }
    }

    public void agregarListaFav(Lista l) {
        if (listas.contains(l)) {
            throw new UnsupportedOperationException("Lista ya en favoritos");
        } else {
            listas.add(l);
        }
    }

    public void agregarTemaFav(Tema t) {
        if (temas.contains(t)) {
            throw new UnsupportedOperationException("Tema ya en favoritos");
        } else {
            temas.add(t);
        }
    }

    public void eliminarAlbumFav(int i) {
        if (albumes.size() >= i) {
            albumes.remove(i);
        } else {
            throw new UnsupportedOperationException("Album no esta en favoritos");
        }
    }

    public void eliminarListaFav(int i) {
        if (listas.size() >= i) {
            listas.remove(i);
        } else {
            throw new UnsupportedOperationException("Lista no esta en favoritos");
        }
    }

    public void eliminarTemaFav(int i) {
        if (temas.size() >= i) {
            temas.remove(i);
        } else {
            throw new UnsupportedOperationException("Tema no esta en favoritos");
        }
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    @Override
    public DtCliente getData() {
        return new DtCliente(getNickname(), getNombre(), getApellido(), getEmail(), getFechaNac());
    }

    @Override
    public DtPerfilUsuario obtenerPerfil() {
        DtUsuario info = getData();
        ArrayList<DtCliente> dtSeguidores = getSeguidores();
        ArrayList<DtUsuario> dtSeguidos = new ArrayList<>();
        ArrayList<DtListaParticular> dtListasCreadas = new ArrayList<>();
        ArrayList<DtAlbum> dtAlbumes = new ArrayList<>();
        ArrayList<DtLista> dtListas = new ArrayList<>();
        ArrayList<DtTema> dtTemas = new ArrayList<>();

        Iterator i = listasParticulares.entrySet().iterator();
        while (i.hasNext()) {
            ListaParticular p = (ListaParticular) ((Map.Entry) i.next()).getValue();
            dtListasCreadas.add((DtListaParticular) p.getData());
        }

        for (Album a : this.albumes) {
            dtAlbumes.add(a.getData());
        }

        for (Lista l : this.listas) {
            dtListas.add(l.getData());
        }

        for (Tema t : this.temas) {
            dtTemas.add(t.getData());
        }

        Iterator i2 = this.seguidos.entrySet().iterator();
        while (i2.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i2.next()).getValue();
            dtSeguidos.add(u.getData());
        }

        return new DtPerfilCliente(dtSeguidos, dtListasCreadas, dtAlbumes, dtListas, dtTemas, info, dtSeguidores);
    }

    public boolean agregar(Usuario u) {
        if (seguidos.get(u.getNickname()) != null) {
            return false;
        }
        if (!u.meComenzoASeguir(this)) {
            return false;
        }
        seguidos.put(u.getNickname(), u);
        return true;
    }

    public boolean dejarSeguir(Usuario u) {
        if (seguidos.get(u.getNickname()) == null) {
            return false;
        }
        if (!u.meDejoDeSeguir(this)) {
            return false;
        }
        seguidos.remove(u.getNickname());
        return true;
    }

    public HashMap<String, Usuario> getSeguidos() {
        return seguidos;
    }

    public ListaParticular getListaParticular(String nombre) {
        return listasParticulares.get(nombre);
    }

    public HashMap<String, ListaParticular> getListasParticulares() {
        return listasParticulares;
    }

    public void setSeguidos(HashMap<String, Usuario> seguidos) {
        this.seguidos = seguidos;
    }

    public void setListasParticulares(HashMap<String, ListaParticular> listasParticulares) {
        this.listasParticulares = listasParticulares;
    }

    public Lista getLista(String nomL) {

        Lista l = this.listasParticulares.get(nomL);

        if (l == null) {
            throw new UnsupportedOperationException("No existe la lista" + nomL + " en el sistema.");
        } else {
            return l;
        }
    }

    public ArrayList<DtLista> listarLisReproduccion() {
        ArrayList<DtLista> res = new ArrayList<>();
        Iterator it = listasParticulares.entrySet().iterator();
        while (it.hasNext()) {
            ListaParticular lp = (ListaParticular) ((Map.Entry) it.next()).getValue();
            if (!(lp.isPrivada())) {
                res.add(new DtListaParticular(lp.isPrivada(), lp.getNombre(), lp.getTemas()));
            }
        }
        return res;
    }

    public DtLista seleccionarLista(String nombreL) {
        ListaParticular lp = listasParticulares.get(nombreL);
        return new DtListaParticular(lp.isPrivada(), lp.getNombre(), lp.getTemas());
    }
    
    public ArrayList<String> obtenerSeguidos(){
        ArrayList<String> dtu = new ArrayList<>();
        
        Iterator it = seguidos.entrySet().iterator();
        while(it.hasNext()){
            Usuario u = (Usuario) ((Map.Entry) it.next()).getValue();
            dtu.add(u.getNickname());
        }
        return dtu;
    } 
}
