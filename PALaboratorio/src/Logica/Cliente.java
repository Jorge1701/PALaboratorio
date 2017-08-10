package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cliente extends Usuario {

    private HashMap<String, Usuario> seguidos;
    private HashMap<String, ListaParticular> listasParticulares;

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, Imagen imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);
        this.seguidos = new HashMap();
        this.listasParticulares = new HashMap();
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

        Iterator i = this.seguidos.entrySet().iterator();
        while (i.hasNext()) {
            Usuario u = (Usuario) ((Map.Entry) i.next()).getValue();
            dtSeguidos.add(u.getData());
        }

        return new DtPerfilCliente(dtSeguidos, info, dtSeguidores);
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
