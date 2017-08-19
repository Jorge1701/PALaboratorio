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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

public class CargaDatosPrueba {

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

    public ArrayList<String[]> loadFollowers(){
        try{
            ArrayList<String[]> res = new ArrayList<>();
            PreparedStatement s = conexion.prepareStatement("SELECT * FROM seguir_usuario");
            ResultSet r = s.executeQuery();
            while(r.next()){
                res.add(new String[]{r.getString(1),r.getString(2)});
            }
            r.close();
            s.close();
            return res;
            
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean levantarDatos(){
        return false;
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
