package Logica;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Usuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;
    //Imagen imagen;
    private HashMap<String,Cliente> seguidores;
    
   

    public Usuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac/*,Imagen imagen*/) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        // this.imagen = imagen;
        this.seguidores = new HashMap<String,Cliente>();
    }

    public void setNickname(String nickname) {                                  //SETTERS
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(DtFecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    /* public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }*/
    
     public void setSeguidores(HashMap<String,Cliente> seguidores) {
        this.seguidores = seguidores;
    }
     
    public String getNickname() {                                                //GETTERS
        return this.nickname;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public DtFecha getFechaNac() {
        return this.fechaNac;
    }

    /* public Imagen getImagen() {
        return this.imagen;
    }*/
    public abstract String getTipo();                                                      //FUNCIONES PROPIAS

    

    public abstract DtUsuario getData();

    public abstract DtPerfilUsuario obtenerPerfil();

    public ArrayList<DtCliente> getSeguidores() {
        return null;
    }
}
