package Logica;

public class Cliente extends Usuario {

    public Cliente(String nickname, String nombre, String apellido, String email, DtFecha fechaNac/*,Imagen imagen*/) {
        super(nickname, nombre, apellido, email, fechaNac/*, imagen*/);
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

    }

}
