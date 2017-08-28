package Logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorUsuarioTest {

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
    };

    private static IUsuario iUsuario;

    public ControladorUsuarioTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        iUsuario = Fabrica.getIControladorUsuario();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testIngresarUsuario() {
        System.out.println("ingresarUsuario");

        boolean result = true;

        for (int i = 0; i < usuarios.length; i++) {
            String[] usuario = usuarios[i];

            String tipo = usuario[8];

            String nick = usuario[1];
            String nombre = usuario[3];
            String apellido = usuario[4];
            String correo = usuario[2];
            String dia = usuario[5];
            String mes = usuario[6];
            String anio = usuario[7];
            DtFecha fecha = new DtFecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anio));

            DtUsuario dtu = null;

            if (tipo.equals("A")) {
                String bio = infoArtistas[i][0];
                String web = infoArtistas[i][1];
                dtu = new DtArtista(nick, nombre, apellido, correo, fecha, bio, web, "");
            } else {
                dtu = new DtCliente(nick, nombre, apellido, correo, fecha, "");
            }

            boolean ok = iUsuario.ingresarUsuario(dtu);
            result = result && iUsuario.obtenerUsuario(nick) != null && ok;
        }

        assertEquals(true, result);
    }

    /*
    @Test
    public void testSeguirUsuario() {
        System.out.println("seguirUsuario");
        String nickCliente = "";
        String nickSeguido = "";
        ControladorUsuario instance = null;
        instance.seguirUsuario(nickCliente, nickSeguido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDejarSeguirUsuario() {
        System.out.println("dejarSeguirUsuario");
        String nickSeguidor = "";
        String nickUsuario = "";
        ControladorUsuario instance = null;
        instance.dejarSeguirUsuario(nickSeguidor, nickUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ControladorUsuario expResult = null;
        ControladorUsuario result = ControladorUsuario.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerUsuario() {
        System.out.println("obtenerUsuario");
        String nick = "";
        ControladorUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectArtista() {
        System.out.println("selectArtista");
        String nick = "";
        ControladorUsuario instance = null;
        Artista expResult = null;
        Artista result = instance.selectArtista(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarUsuarios() {
        System.out.println("listarUsuarios");
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarArtistas() {
        System.out.println("listarArtistas");
        ControladorUsuario instance = null;
        ArrayList<DtUsuario> expResult = null;
        ArrayList<DtUsuario> result = instance.listarArtistas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerPerfilArtista() {
        System.out.println("obtenerPerfilArtista");
        String nickArtista = "";
        ControladorUsuario instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfilArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerPerfilCliente() {
        System.out.println("obtenerPerfilCliente");
        String nickCliente = "";
        ControladorUsuario instance = null;
        DtPerfilUsuario expResult = null;
        DtPerfilUsuario result = instance.obtenerPerfilCliente(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        ControladorUsuario instance = null;
        DtCliente expResult = null;
        DtCliente result = instance.getCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testListarAlbumesArtista() {
        System.out.println("listarAlbumesArtista");
        String nickArtista = "";
        ControladorUsuario instance = null;
        ArrayList<DtAlbum> expResult = null;
        ArrayList<DtAlbum> result = instance.listarAlbumesArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerAlbumContenido() {
        System.out.println("obtenerAlbumContenido");
        String nickArtista = "";
        String nomAlbum = "";
        ControladorUsuario instance = null;
        DtAlbumContenido expResult = null;
        DtAlbumContenido result = instance.obtenerAlbumContenido(nickArtista, nomAlbum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarUsuarios() {
        System.out.println("cargarUsuarios");
        ControladorUsuario instance = null;
        instance.cargarUsuarios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String nick = "";
        ControladorUsuario instance = null;
        Usuario expResult = null;
        Usuario result = instance.getUsuario(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarSeguidoresDe() {
        System.out.println("listarSeguidoresDe");
        String nickUsuario = "";
        ControladorUsuario instance = null;
        ArrayList<DtCliente> expResult = null;
        ArrayList<DtCliente> result = instance.listarSeguidoresDe(nickUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarListaReproduccionCli() {
        System.out.println("listarListaReproduccionCli");
        String nickCliente = "";
        ControladorUsuario instance = null;
        ArrayList<DtLista> expResult = null;
        ArrayList<DtLista> result = instance.listarListaReproduccionCli(nickCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSelectListaCli() {
        System.out.println("selectListaCli");
        String nombreL = "";
        ControladorUsuario instance = null;
        DtLista expResult = null;
        DtLista result = instance.selectListaCli(nombreL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
}
