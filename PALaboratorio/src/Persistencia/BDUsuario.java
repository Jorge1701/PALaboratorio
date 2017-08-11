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
/**
 *
 * @author Luis
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDUsuario {

    private Connection conexion = new ConexionBD().getConexion();

    public boolean ingresarUsuario(Usuario u){
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO usuario "
                    + "(nickname, correo, nombre,apellido,fecha_nac,tipo) values(?,?,?,?,?,?)");
            statement.setString(1, u.getNickname());
            statement.setString(2, u.getEmail());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            statement.setDate(5, java.sql.Date.valueOf(u.getFechaNac().getAnio()+"-"+u.getFechaNac().getMes()+"-"+u.getFechaNac().getDia()));
            statement.setBoolean(6, false);
            statement.executeUpdate();
            statement.close();
            if (u instanceof Cliente) {

                //
                PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO cliente "
                        + "(nickname, correo) values(?,?)");
                statement2.setString(1, u.getNickname());
                statement2.setString(2, u.getEmail());
                statement2.executeUpdate();
                statement2.close();
                //
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
