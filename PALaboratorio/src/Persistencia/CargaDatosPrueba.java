package Persistencia;

import Logica.DtArtista;
import Logica.DtCliente;
import Logica.DtFecha;
import Logica.DtUsuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargaDatosPrueba {

    // Datos del  DatosPrueba2017.doc del Drive...
    private String[][] usuarios = {
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

    private String[][] infoArtistas = {
        {"Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.", "www.officialvillagepeople.com"},
        {"", "www.depechemode.com"},
        {"Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participaren el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debutShe&#39;s So Unusual a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.", "cyndilauper.com"},
        {"", "brucespringsteen.net"},
        {"Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.1", "www.tomjones.com"},
        {"La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando &quot;Paco&quot; Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).", ""},
        {"", ""},
        {"Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo", ""},
        {"", ""},
        {"", "www.pimpinela.net"},
        {"José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.", ""},
        {"Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito \"Violeta\", originalmente compuesta e interpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote».", ""}
    };

    private String[][] clientes = {};

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
        {"SO", "ML"}
    // Faltan...
    };
    // Fin de datos

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

    public boolean levantarDatos() {
        levantarAlbumes();
        return false;
    }

    public void levantarAlbumes() {

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
