package Persistencia;

import Logica.Artista;
import Logica.DtArtista;
import Logica.DtUsuario;
import Logica.Usuario;
import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDUsuario {

    protected Connection conexion = new ConexionBD().getConexion();

    protected String obtenerCorreo(String nick) {
        try {
            String res = "";

            PreparedStatement correo = conexion.prepareStatement("SELECT correo FROM usuario WHERE nickname = '" + nick + "'");
            ResultSet c = correo.executeQuery();
            while (c.next()) {
                res = c.getString("correo");
            }
            c.close();
            correo.close();

            return res;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return "";
    }

    public boolean seguirUsuario(String nickname_c, String nickname_u) {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO seguir_usuario VALUES (?,?) ");
            insert.setString(1, nickname_c);
            insert.setString(2, nickname_u);
            insert.executeUpdate();
            insert.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean dejarDeSeguir(String nickname_c, String nickname_u) {
        try {
            PreparedStatement delete = conexion.prepareStatement("DELETE FROM seguir_usuario WHERE nickname_c = ? AND nickname_u = ?");
            delete.setString(1, nickname_c);
            delete.setString(2, nickname_u);
            delete.executeUpdate();
            delete.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ingresarUsuario(DtUsuario dtu) {

        String nickName = dtu.getNickname();
        String nombre = dtu.getNombre();
        String apellido = dtu.getApellido();
        String correo = dtu.getEmail();
        Date fecha = new Date(dtu.getFechaNac().getAnio(), dtu.getFechaNac().getMes(), dtu.getFechaNac().getDia());
        //java.sql.Date.valueOf(dtu.getFechaNac().getAnio() + "-" + dtu.getFechaNac().getMes() + "-" + dtu.getFechaNac().getDia());

        if (dtu instanceof DtArtista) {
            try {
                String biografia = ((DtArtista) dtu).getBiografia();
                String web = ((DtArtista) dtu).getWeb();

                PreparedStatement insertar = conexion.prepareStatement("INSERT INTO artista "
                        + "(nickname, nombre, apellido,correo,fecha_nac,biografia,sitio_web) values(?,?,?,?,?,?,?)");
                insertar.setString(1, nickName);
                insertar.setString(2, nombre);
                insertar.setString(3, apellido);
                insertar.setString(4, correo);
                insertar.setDate(5, fecha);
                insertar.setString(6, biografia);
                insertar.setString(7, web);
                insertar.executeUpdate();
                insertar.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        } else {

            try {
                PreparedStatement insertar = conexion.prepareStatement("INSERT INTO cliente "
                        + "(nickname, correo, nombre, apellido, fecha_nac) values(?,?,?,?,?)");
                insertar.setString(1, nickName);
                insertar.setString(2, nombre);
                insertar.setString(3, apellido);
                insertar.setString(4, correo);
                insertar.setDate(5, fecha);
                insertar.executeUpdate();
                insertar.close();
            } catch (SQLException ex) {
                Logger.getLogger(BDUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
}
