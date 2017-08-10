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
        
        for (Album a : this.albumes)
            dtAlbumes.add(a.getData());
        
        for (Lista l : this.listas)
            dtListas.add(l.getData());
        
        for (Tema t : this.temas)
            dtTemas.add(t.getData());
        
        Iterator i2 = this.seguidos.entrySet().iterator();
        while (i2.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i2.next()).getValue();
            dtSeguidos.add(u.getData());
        }
        
        return new DtPerfilCliente(dtSeguidos, dtListasCreadas, dtAlbumes, dtListas, dtTemas, info, dtSeguidores);
    }

    public void agregar(Usuario u) {
        seguidos.put(u.getNickname(), u);
    }

    public void dejarSeguir(Usuario u) {
        seguidos.remove(u.getNickname());
    }
    
    public HashMap<String, Usuario> getSeguidos() {
        return seguidos;
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
}
