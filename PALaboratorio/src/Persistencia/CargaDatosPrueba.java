package Persistencia;

import Logica.DtAlbum;
import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtFecha;
import Logica.DtUsuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargaDatosPrueba {

    // Datos del DatosPrueba2017.doc del Drive...
    // Pefiles (Ref, Nickname, Correo, Nombre, Apellido, FechaNac, Tipo)
    private String[][] perfiles = {
        {"VP", "vpeople", "vpeople@tuta.io", "Village", "People", "1", "1", "1977", "A"},
        {"DM", "dmode", "dmode@tuta.io", "Depeche", "Mode", "14", "6", "1980", "A"},
        {"CL", "clauper", "clauper@hotmail.com", "Cyndi", "Lauper", "22", "6", "1953", "A"},
        {"BS", "bruceTheBoss", "bruceTheBoss@gmail.com", "Bruce", "Springsteen", "23", "9", "1949", "A"},
        {"TN", "tripleNelson", "tripleNelson@tuta.io", "La Triple", "Nelson", "1", "1", "1998", "A"},
        {"LL", "la_ley", "la_ley@tuta.io", "La", "Ley", "14", "2", "1987", "A"},
        {"TJ", "tigerOfWales", "tigerOfWales@tuta.io", "Tom", "Jones", "7", "6", "1940", "A"},
        {"PT", "chaiko", "chaiko@tuta.io", "Piotr", "Tchaikovsky", "25", "4", "1840", "A"},
        {"NN", "nicoleneu", "nicoleneu@hotmail.com", "Nicole", "Neumann", "31", "10", "1980", "A"},
        {"PI", "lospimpi", "lospimpi@gmail.com", "Pimpinela", "", "13", "8", "1981", "A"},
        {"DY", "dyangounchained", "dyangounchained@gmail.com", "Dyango", "", "5", "3", "1940", "A"},
        {"AL", "alcides", "alcides@tuta.io", "Alcides", "", "17", "7", "1952", "A"},
        {"VC", "el_padrino", "el_padrino@tuta.io", "Vito", "Corleone", "8", "3", "1972", "C"},
        {"SO", "scarlettO", "scarlettO@tuta.io", "Scarlett", "O’Hara", "27", "11", "1984", "C"},
        {"PA", "ppArgento", "ppArgento@hotmail.com", "Pepe", "Argento", "14", "2", "1955", "C"},
        {"WW", "Heisenberg", "Heisenberg@tuta.io", "Walter", "White", "7", "3", "1956", "C"},
        {"OK", "benKenobi", "benKenobi@gmail.com", "Obi-Wan", "Kenobi", "2", "4", "1914", "C"},
        {"ML", "lachiqui", "lachiqui@hotmail.com.ar", "Mirtha", "Legrand", "23", "2", "1927", "C"},
        {"CB", "cbochinche", "cbochinche@vera.com.uy", "Cacho", "Bochinche", "8", "5", "1937", "C"},
        {"EL", "Eleven11", "Eleven11@gmail.com", "Eleven", "", "31", "12", "1971", "C"}
    };

    // Datos Opcionales de Artistas (Ref, Imagen, Bio, Web)
    private String[][] infoArtistas = {
        {"VP", "bit.ly/vpeople", "Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.", "www.officialvillagepeople.com"},
        {"DM", "bit.ly/depecheMode", "", "www.depechemode.com"},
        {"CL", "bit.ly/cLauper", "Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participaren el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debutShe&#39;s So Unusual a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.", "cyndilauper.com"},
        {"BS", "bit.ly/bruceTheBoss", "", "brucespringsteen.net"},
        {"TJ", "", "Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.1", "www.tomjones.com"},
        {"TN", "bit.ly/tripleNelson", "La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando &quot;Paco&quot; Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).", ""},
        {"LL", "", "", ""},
        {"PT", "", "Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo", ""},
        {"NN", "bit.ly/nicoleneu", "", ""},
        {"PI", "bit.ly/losPimpinela", "", "www.pimpinela.net"},
        {"DY", "", "José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.", ""},
        {"AL", "", "Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito \"Violeta\", originalmente compuesta e interpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote».", ""}
    };

    // Datos Opcionales de Clientes (Ref, Imagen,)
    private String[][] infoClientes = {
        {"VC", "bit.ly/vitoCorleone"},
        {"SO", "bit.ly/scarlettO"},
        {"PA", "bit.ly/ppArgento"},
        {"WW", "bit.ly/heisenbergWW"},
        {"OK", "bit.ly/benKenobi"},
        {"ML", "bit.ly/laChiqui"},
        {"CB", "bit.ly/cbochinche"},
        {"EL", "bit.ly/11Eleven11"}
    };

    // Seguidores (Seguidor, Seguido)
    private String[][] seguidores = {
        {"VC", "VP"},
        {"VC", "DM"},
        {"VC", "CL"},
        {"VC", "OK"},
        {"VC", "ML"},
        {"VC", "CB"},
        {"VC", "EL"},
        {"SO", "DM"},
        {"SO", "BS"},
        {"SO", "TJ"},
        {"SO", "TN"},
        {"SO", "WW"},
        {"SO", "OK"},
        {"SO", "ML"},
        {"PA", "DM"},
        {"PA", "BS"},
        {"PA", "TN"},
        {"PA", "OK"},
        {"PA", "ML"},
        {"PA", "CB"},
        {"PA", "EL"},
        {"WW", "DM"},
        {"WW", "BS"},
        {"WW", "TJ"},
        {"WW", "TN"},
        {"WW", "PI"},
        {"WW", "DY"},
        {"WW", "AL"},
        {"WW", "VC"},
        {"WW", "SO"},
        {"WW", "PA"},
        {"WW", "OK"},
        {"WW", "ML"},
        {"WW", "EL"},
        {"OK", "DM"},
        {"OK", "BS"},
        {"OK", "LL"},
        {"OK", "PT"},
        {"OK", "NN"},
        {"OK", "PI"},
        {"OK", "AL"},
        {"OK", "VC"},
        {"OK", "PA"},
        {"OK", "ML"},
        {"OK", "CB"},
        {"OK", "EL"},
        {"ML", "BS"},
        {"ML", "LL"},
        {"ML", "PI"},
        {"ML", "AL"},
        {"ML", "VC"},
        {"ML", "SO"},
        {"ML", "PA"},
        {"CB", "LL"},
        {"CB", "PI"},
        {"CB", "DY"},
        {"CB", "AL"},
        {"CB", "PA"},
        {"EL", "LL"},
        {"EL", "VC"},
        {"EL", "SO"},
        {"EL", "PA"}
    };

    // Generos (Ref, Nombre, Padre)
    private String[][] generos = {
        {"ROK", "Rock", ""},
        {"RCL", "Rock Clasico", "ROK"},
        {"RKL", "Rock Latino", "ROK"},
        {"RAR", "Rock & Roll", "ROK"},
        {"CLA", "Clasica", ""},
        {"DIS", "Disco", ""},
        {"POP", "Pop", ""},
        {"EPO", "Electropop", "POP"},
        {"DPO", "Dance-pop", "POP"},
        {"PCL", "Pop Clasico", "POP"},
        {"BAL", "Balada", ""},
        {"CUM", "Cumbia", ""}
    };

    // Albumes (Ref artista, Ref album, Nombre, Generos, Anio, Imagen)
    private String[][] albumes = {
        {"VP", "VPL", "Village People Live and Sleazy", "DIS,DPO,PCL", "1980", ""},
        {"DM", "DMV", "Violator", "EPO", "1990", ""},
        {"CL", "CLU", "She’s So Unusual", "PCL,DPO", "1983", "bit.ly/shesunusual"},
        {"BS", "USA", "Born In The U.S.A.", "RCL,RAR,PCL", "1984", ""},
        {"TJ", "INU", "It’s Not Unusual", "RCL,PCL", "1965", "bit.ly/itsNotUnusual"},
        {"TN", "AYS", "Agua Y Sal", "RKL", "2012", ""},
        {"LL", "LLU", "MTV Unplugged", "RKL,PCL", "2001", "bit.ly/MTVunplugged"},
        {"PT", "LDC", "El Lago De Los Cisnes", "CLA", "1875", ""},
        {"PT", "CPP", "Concierto Para Piano No. 1 En Si Menor, Opus 23", "CLA", "1875", ""},
        {"NN", "PAM", "Primer Amor", "EPO", "1994", ""},
        {"PI", "AMA", "Hay Amores Que Matan", "PCL,BAL", "1993", ""},
        {"DY", "LOC", "Un Loco Como Yo", "PCL,BAL", "1993", "bit.ly/UnLocoComo"},
        {"AL", "VIO", "20 Grandes Éxitos", "CUM", "1989", "bit.ly/alcides20"}
    };

    // Temas de los Albumes (Ref album, Ref tema, Nombre, Minutos, Segundos, Ubicacion)
    private String[][] temas = {
        {"VPL", "T11", "YMCA", "4", "28", "1"},
        {"VPL", "T12", "Macho Man", "3", "28", "2"},
        {"VPL", "T13", "In the Navy", "3", "13", "3"},
        {"DMV", "T21", "Personal Jesus", "4", "56", "1"},
        {"DMV", "T22", "Enjoy The Silence", "4", "21", "2"},
        {"CLU", "T31", "Girls Just Want To Have Fun", "3", "15", "1"},
        {"CLU", "T32", "Time After Time", "5", "12", "2"},
        {"USA", "T41", "Born In The U.S.A.", "4", "58", "1"},
        {"USA", "T42", "Glory Days", "5", "23", "2"},
        {"USA", "T43", "Dancing In The Park", "3", "58", "3"},
        {"INU", "T51", "It's Not Unusual", "2", "0", "1"},
        {"AYS", "T61", "Adegio De Mi Pais", "4", "50", "1"},
        {"LLU", "T71", "El Duelo", "5", "23", "1"},
        {"LLU", "T72", "Mentura", "4", "48", "2"},
        {"LDC", "T81", "Acto 2, Numero 10, Escena (Moderato)", "2", "40", "1"},
        {"CPP", "T91", "Primer Movimiento (Allegro non troppo e molto maestroso - Allegro con spirito)", "21", "58", "1"},
        {"PAM", "T101", "No Quiero Estudiar", "2", "12", "1"},
        {"AMA", "T111", "Por Ese Hombre", "4", "45", "1"},
        {"LOC", "T121", "Por Ese Hombre", "5", "13", "1"},
        {"VIO", "T131", "Violeta", "1", "56", "1"},};

    // Archivos y Streams de Musica (Album ref, Ref, Archivo, Stream)
    private String[][] archivosYStreams = {
        {"VPL", "T11", "", "bit.ly/SCvpymca"},
        {"VPL", "T12", "picosong.com/download/zf8T", ""},
        {"VPL", "T13", "", "bit.ly/SCvpinthenavy"},
        {"DMV", "T21", "picosong.com/download/zfQ3", ""},
        {"DMV", "T22", "picosong.com/download/zfQX", ""},
        {"CLU", "T31", "", "bit.ly/SCclgirlsjustwant"},
        {"CLU", "T32", "picosong.com/download/zfER", ""},
        {"USA", "T41", "", "bit.ly/SCbsborninusa"},
        {"USA", "T42", "", "bit.ly/SCbsglorydays"},
        {"USA", "T43", "picosong.com/download/zf86", ""},
        {"INU", "T51", "picosong.com/download/zfbS", ""},
        {"AYS", "T61", "", "bit.ly/SCtnadagiopais"},
        {"LLU", "T71", "picosong.com/download/zfh6", ""},
        {"LLU", "T72", "picosong.com/download/zfAe", ""},
        {"LDC", "T81", "", "bit.ly/SCptswanlake"},
        {"CPP", "T91", "", "bit.ly/SCptpiano"},
        {"PAM", "T101", "picosong.com/download/zfZN", ""},
        {"AMA", "T111", "picosong.com/download/zfa4", ""},
        {"LOC", "T121", "", "bit.ly/SCdyporesehombre"},
        {"VIO", "T131", "", "bit.ly/SCvioleta"}
    };

    // Listas de Reproduccion por Defecto (Ref, Nombre, Genero, Imagen)
    private String[][] listarPorDefecto = {
        {"LD1", "Noche De La Nostalgia", "PCL", "bit.ly/laNocheNostalgia"},
        {"LD2", "Rock En Español", "RKL", ""},
        {"LD3", "Cusica Clasica", "CLA", "bit.ly/musicaCla"},};

    // Listas de Reproduccion Particulares (Ref cliente, Ref, Nombre, Publica, Imagen)
    private String[][] listasParticulares = {
        {"VC", "LP1", "Musica Inspiradora", "S", "bit.ly/musicInspi"},
        {"SO", "LP2", "De Todo Un Poco", "S", ""},
        {"WW", "LP3", "Para Cocinar", "N", "bit.ly/ParaCocinar"},
        {"ML", "LP4", "Para Las Chicas", "S", ""},
        {"CB", "LP5", "Fiesteras", "S", "bit.ly/fiestaFiesta"},
        {"CB", "LP6", "Mis FAvoritas", "N", ""},};

    // Temas De Listas (Ref Lista, Ref Album, Ref Tema)
    private String[][] temasDeListas = {
        {"LD1", "VPL", "T11"},
        {"LD1", "VPL", "T12"},
        {"LD1", "VPL", "T13"},
        {"LD1", "CLU", "T31"},
        {"LD1", "CLU", "T32"},
        {"LD1", "USA", "T41"},
        {"LD1", "USA", "T42"},
        {"LD1", "USA", "T43"},
        {"LD1", "INU", "T51"},
        {"LD2", "AYS", "T61"},
        {"LD2", "LLU", "T71"},
        {"LD2", "LLU", "T72"},
        {"LD3", "LDC", "T81"},
        {"LD3", "CPP", "T91"},
        {"LP1", "LDC", "T81"},
        {"LP1", "CPP", "T91"},
        {"LP1", "DMV", "T21"},
        {"LP2", "CLU", "T31"},
        {"LP2", "CLU", "T32"},
        {"LP2", "INU", "T51"},
        {"LP2", "LDC", "T81"},
        {"LP3", "DMV", "T21"},
        {"LP3", "DMV", "T22"},
        {"LP3", "USA", "T41"},
        {"LP3", "USA", "T42"},
        {"LP4", "CLU", "T31"},
        {"LP4", "INU", "T51"},
        {"LP4", "CPP", "T91"},
        {"LP4", "PAM", "T101"},
        {"LP4", "LOC", "T121"},
        {"LP5", "VPL", "T11"},
        {"LP5", "VPL", "T12"},
        {"LP5", "VPL", "T13"},
        {"LP5", "USA", "T42"},
        {"LP5", "VIO", "T131"},
        {"LP6", "AYS", "T61"},
        {"LP6", "CPP", "T91"},
        {"LP6", "AMA", "T111"}
    };

    // Favoritos
    // Temas Favoritos (Ref Cliente, Ref Album, Ref Tema)
    private String[][] refTemaFav = {
        {"VC", "LLU", "T71"},
        {"PA", "AYS", "T61"},
        {"CB", "CPP", "T91"},
        {"EL", "PAM", "T101"}
    };

    // Listas Favoritas (Ref Cliente, Ref Listas)
    private String[][] refListaFav = {
        {"VC", "LD1"},
        {"VC", "LD3"},
        {"SO", "LD3"},
        {"PA", "LD1"},
        {"PA", "LD2"},
        {"WW", "LP1"},
        {"CB", "LD1"},
        {"CB", "LD2"}
    };

    // Albumes Favoritos (Ref Cliente, Ref Album)
    private String[][] refAlbumFav = {
        {"VC", "DMV"},
        {"VC", "LDC"},
        {"VC", "CPP"},
        {"VC", "LDC"},
        {"VC", "CPP"},
        {"VC", "AMA"}
    };
    // Fin de datos de prueba

    protected Connection conexion = new ConexionBD().getConexion();

    public ArrayList<DtUsuario> cargarUsuarios() {
        try {
            ArrayList<DtUsuario> usuarios = new ArrayList<>();

            PreparedStatement usuario = conexion.prepareStatement("SELECT * FROM artista");
            ResultSet artistas = usuario.executeQuery();

            while (artistas.next()) {
                String nickName = artistas.getString(1);
                String nombre = artistas.getString(2);
                String apellido = artistas.getString(3);
                String correo = artistas.getString(4);
                Date fecha = artistas.getDate(5);
                String biografia = artistas.getString(6);
                String web = artistas.getString(7);
                usuarios.add(new DtArtista(nickName, nombre, apellido, correo, new DtFecha(fecha.getDay(), fecha.getMonth(), fecha.getYear()), biografia, web));
            }

            usuario.close();
            artistas.close();

            PreparedStatement usuario1 = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet clientes = usuario1.executeQuery();

            while (clientes.next()) {
                String nickName = clientes.getString(1);
                String nombre = clientes.getString(2);
                String apellido = clientes.getString(3);
                String correo = clientes.getString(4);
                Date fecha = clientes.getDate(5);
                usuarios.add(new DtCliente(nickName, nombre, apellido, correo, new DtFecha(fecha.getDay(), fecha.getMonth(), fecha.getYear())));
            }

            usuario1.close();
            clientes.close();

            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<String[]> loadFollowers() {
        try {
            ArrayList<String[]> res = new ArrayList<>();
            PreparedStatement s = conexion.prepareStatement("SELECT * FROM seguir_usuario");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                res.add(new String[]{r.getString(1), r.getString(2)});
            }
            r.close();
            s.close();
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertarDatosPrueba() {
        insertarUsuarios();

        if (!insertarSeguidores()) {
            return false;
        }

        //if (!insertarTemas()) {
        //  return false;
        //}
        return true;
    }

    public boolean insertarUsuarios() {

        for (String[] usuario : perfiles) {
            String nickName = usuario[1];
            String nombre = usuario[3];
            String apellido = usuario[4];
            String correo = usuario[2];
            Date fecha = new Date(Integer.parseInt(usuario[5]), Integer.parseInt(usuario[6]), Integer.parseInt(usuario[7]));
            if (usuario[8] == "A") {
                try {
                    String bio = "";
                    String web = "";
                    for (String[] info : infoArtistas) {
                        if (info[0] == usuario[0]) {
                            bio = info[2];
                            web = info[3];
                        }
                    }
                    PreparedStatement insert = conexion.prepareStatement("INSERT INTO artista VALUES(?,?,?,?,?,?,?)");
                    insert.setString(1, nickName);
                    insert.setString(2, nombre);
                    insert.setString(3, apellido);
                    insert.setString(4, correo);
                    insert.setDate(5, fecha);
                    insert.setString(6, bio);
                    insert.setString(7, web);
                    insert.executeUpdate();
                    insert.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    PreparedStatement insert = conexion.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?)");
                    insert.setString(1, nickName);
                    insert.setString(2, nombre);
                    insert.setString(3, apellido);
                    insert.setString(4, correo);
                    insert.setDate(5, fecha);
                    insert.executeUpdate();
                    insert.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CargaDatosPrueba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }

    
    private boolean levantarListaPorDefecto(){
    BDLista bdl = new BDLista();
    for(String[] listaPordefecto : listarPorDefecto){
        String refLista = listaPordefecto[0];
        String nombre = listaPordefecto[1];
        String genero = listaPordefecto[2];
        
    String nombreListaD="";
    String nombreTema="";
    
    for(String[] listapordefecto : listarPorDefecto){
        if(listapordefecto[0]==refLista ){
        nombreListaD=listapordefecto[1];
        }
    }
    for(String[] temaLista : temasDeListas){
    if(temaLista[0]==refLista){
       String refTema = temaLista[2];
       
     for(String[] tema : temas){
     if(tema[1] == refTema ){
     nombreTema = tema[2];
     }
     }
    if(bdl.altaLista(nombreListaD, nombreTema)){
    if(!bdl.altaListaPorDefecto(nombreListaD,genero,nombreTema)){
     return false; 
    }else return false;
    }
    }
    }
    }
     return true;
    }
    // Listas de Reproduccion Particulares (Ref cliente, Ref, Nombre, Publica, Imagen)
    private boolean levantarListaParticular(){
    BDLista bdl = new BDLista();
    for(String[] listaParticular : listasParticulares){
    String refCliente = listaParticular[0];
    String refLista = listaParticular[1];
    String nombreLista = listaParticular[2];
    String publica = listaParticular[3];
  
    String nombreCliente="";
    String  nombretema="";
    String refTema="";
    for(String[] cliente : perfiles){
    if(cliente[0]==refCliente){
     nombreCliente=cliente[1];   
    }
    
    for(String[] temalista: temasDeListas){
        
    if(temalista[0]==refLista){
    refTema = temalista[2];
    }   
    
    for(String[] tema : temas){
    if(tema[0]==refTema){
    nombretema=tema[2];
    }
    }
    if(bdl.altaLista(nombreLista, nombretema)){
    if(!bdl.altaListaParticular(nombreLista, nombreCliente, nombretema, publica)){
     return false;
    }
    }else return false;
    }
    return false;
    }
    }
    return true;
    }
    private boolean insertarSeguidores(){
        BDCliente bdc = new BDCliente();

        for (String[] seguidor : seguidores) {
            String codC = seguidor[0];
            String codU = seguidor[1];

            String nickC = "";
            String nickU = "";

            for (String[] usuario : perfiles) {
                if (usuario[0] == codC) {
                    nickC = usuario[1];
                }

                if (usuario[0] == codU) {
                    nickU = usuario[1];
                }
            }

            if (!bdc.seguirUsuario(nickC, nickU)) {
                return false;
            }
        }

        return true;
    }

    private boolean insertarTemas() {
        for (String[] tema : temas) {
            try {
                String nickArtista = "";
                String nombreAlbum = "";

                for (String[] album : albumes) {
                    if (album[1] == tema[0]) {
                        nombreAlbum = album[2];

                        for (String[] usuario : perfiles) {
                            if (usuario[0] == album[0]) {
                                nickArtista = usuario[1];
                            }
                        }
                    }
                }

                int idAlbum = obtenerIdAlbum(nickArtista, nombreAlbum);
                String nombre = tema[2];
                Time duracion = new Time(0, Integer.parseInt(nombre), 0);
                int ubicacion = Integer.parseInt(tema[5]);

                PreparedStatement insert = conexion.prepareStatement("INSERT INTO tema (nickArtista, idAlbum, nombre, duracion, ubicacion) VALUES (?, ?, ?, ?, ?)");
                insert.setString(1, nickArtista);
                insert.setInt(2, idAlbum);
                insert.setString(3, nombre);
                insert.setTime(4, duracion);
                insert.setInt(5, ubicacion);
                insert.executeUpdate();
                insert.close();

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private int obtenerIdAlbum(String nickArtista, String nombreAlbum) {
        try {
            PreparedStatement query = conexion.prepareStatement("SELECT idAlbum FROM album WHERE nombre = ? AND nicknameArtista = ?");
            query.setString(1, nombreAlbum);
            query.setString(2, nickArtista);

            ResultSet rs = query.executeQuery();
            int idAlbum = 0;

            while (rs.next()) {
                idAlbum = rs.getInt(1);
            }

            rs.close();
            query.close();

            return idAlbum;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public boolean borrarTodosLosDatos() {
        try {
            PreparedStatement query = conexion.prepareStatement("SHOW TABLES");

            ResultSet tablas = query.executeQuery();

            while (tablas.next()) {
                borrarDatosTabla(tablas.getString(1));
            }

            tablas.close();
            query.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean borrarDatosTabla(String nombre) {
        try {
            PreparedStatement truncate = conexion.prepareStatement("DELETE FROM " + nombre);
            truncate.executeUpdate();
            truncate.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    


}
