package Persistencia;

import Logica.Artista;
import Logica.Cliente;
import Logica.Usuario;
import Persistencia.ConexionBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
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

    public boolean dejarDeSeguir(String nickname_c, String nickname_u) {
        try {
            String correo_c = obtenerCorreo(nickname_c);
            String correo_u = obtenerCorreo(nickname_u);

            PreparedStatement delete = conexion.prepareStatement("DELETE FROM seguir_usuario WHERE nickname_c = ? AND correo_c = ? AND nickname_u = ? AND correo_u = ?");
            delete.setString(1, nickname_c);
            delete.setString(2, correo_c);
            delete.setString(3, nickname_u);
            delete.setString(4, correo_u);
            delete.executeUpdate();
            delete.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean ingresarUsuario(Usuario u) {
        try {
            if (u instanceof Artista) {

                PreparedStatement statement = conexion.prepareStatement("INSERT INTO artista "
                        + "(nickname, nombre, apellido,correo,fecha_nac,tipo,biografia,sitio_web) values(?,?,?,?,?,?,?,?)");
                statement.setString(1, u.getNickname());
                statement.setString(2, u.getNombre());
                statement.setString(3, u.getApellido());
                statement.setString(4, u.getEmail());
                statement.setDate(5, java.sql.Date.valueOf(u.getFechaNac().getAnio() + "-" + u.getFechaNac().getMes() + "-" + u.getFechaNac().getDia()));
                statement.setBoolean(6, true);
                statement.setString(6, ((Artista) u).getBiografia());
                statement.setString(7, ((Artista) u).getWeb());
                statement.executeUpdate();
                statement.close();
                return true;

            } else {

                PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO cliente "
                        + "(nickname, correo, nombre, apellido, fecha_nac, tipo) values(?,?,?,?,?,?)");
                statement2.setString(1, u.getNickname());
                statement2.setString(2, u.getEmail());
                statement2.setString(3, u.getNombre());
                statement2.setString(4, u.getApellido());
                statement2.setDate(5, java.sql.Date.valueOf(u.getFechaNac().getAnio() + "-" + u.getFechaNac().getMes() + "-" + u.getFechaNac().getDia()));
                statement2.setBoolean(6, false);
                statement2.executeUpdate();
                statement2.close();
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
