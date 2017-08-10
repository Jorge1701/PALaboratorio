package Logica;

import java.util.HashMap;

public class Cliente extends Usuario {

    private HashMap<String, Usuario> seguidos;
    private HashMap<String, ListaParticular> listasParticulares;

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac, Imagen imagen) {
        super(nickname, nombre, apellido, email, fechaNac, imagen);
        this.seguidos = new HashMap<String, Usuario>();
        this.listasParticulares = new HashMap<String, ListaParticular>();
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

    public String getTipo() {
        return "Cliente";
    }

    public DtUsuario getData() {
        return null;
    }

    public DtPerfilUsuario obtenerPerfil() {
        return null;
    }

    public void agregar(Usuario u) {

    }

    public void dejarSeguir(Usuario u) {
        seguidos.remove(u.getNickname());
    }
}
