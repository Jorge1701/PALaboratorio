package Logica;

class DtArtista extends DtUsuario {
    
    private String biografia;
    private String web;
    
    public DtArtista(String nickname, String nombre, String apellido, String email, DtFecha fechaNac/*,Imagen imagen*/, String biografia, String web) {
        super(nickname, nombre, apellido, email, fechaNac/*,imagen*/);
        this.biografia = biografia;
        this.web = web;
    }
    
    public String getBiografia() {
        return biografia;
    }
    
    public String getWeb() {
        return web;
    }
}
