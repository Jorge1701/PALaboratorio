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
            while (c.next())
                res = c.getString("correo");
            c.close();
            correo.close();
            
            return res;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "";
    }
    
    public boolean dejarDeSeguir(String nickname_c, String nickname_u){
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
    public boolean ingresarUsuario(Usuario u){
        try {

            if (u instanceof Cliente) {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO cliente "
            + "(nickname, correo, nombre,apellido,fecha_nac,tipo,) values(?,?,?,?,?,?)");
            statement.setString(1, u.getNickname());
            statement.setString(2, u.getEmail());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            statement.setDate(5, java.sql.Date.valueOf(u.getFechaNac().getAnio()+"-"+u.getFechaNac().getMes()+"-"+u.getFechaNac().getDia()));
            statement.setBoolean(6, false);
            statement.executeUpdate();
            statement.close();
                return true;
            } else {
                
                PreparedStatement statement3 = conexion.prepareStatement("INSERT INTO artista "
                + "(biografia, sitio_web, nickname, correo) values(?,?,?,?)");
                statement3.setString(1, ((Artista) u).getBiografia());
                statement3.setString(2, ((Artista) u).getWeb());
                statement3.setString(3, u.getNickname());
                statement3.setString(4, u.getEmail());
                statement3.executeUpdate();
                statement3.close();
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
