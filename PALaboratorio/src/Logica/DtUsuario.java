package Logica;

class DtUsuario {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;
    // Imagen imagen;
    
    public DtUsuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac/*,Imagen imagen*/) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        // this.imagen = imagen;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public DtFecha getFechaNac() {
        return fechaNac;
    }
    
    /*
    public Imagen getImagen() {
        return imagen;
    }*/
}
