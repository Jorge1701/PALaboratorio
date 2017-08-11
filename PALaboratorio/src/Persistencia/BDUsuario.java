package Persistencia;

import Logica.Artista;
import Logica.Cliente;
import Logica.Usuario;
import Persistencia.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
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
                  PreparedStatement statement = conexion.prepareStatement("INSERT INTO Usuario "
                    + "(nickname, correo, nombre,apellido,fecha_nac,tipo) values(?,?,?,?,?,?)");
            statement.setString(1, u.getNickname());
            statement.setString(2, u.getEmail());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            statement.setDate(5,null); //ver aca como convertir el DtFecha a DATE
            statement.setBoolean(6, false);
            statement.executeUpdate();
            statement.close();
            
            //cliente nickname,correo
            if(u instanceof Cliente){
      
            //
             PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO Cliente "
                    + "(nickname, correo) values(?,?)");
            statement.setString(1, u.getNickname());
            statement.setString(2, u.getEmail());
            statement.executeUpdate();
            statement.close();
            //
            return true;
            }else{
            PreparedStatement statement3 = conexion.prepareStatement("INSERT INTO Artista "
                    + "(idImagen, biografia, sitio-web,nickname,correo) values(?,?,?,?,?)");
            statement.setInt(1, 0);
            statement.setString(2, ((Artista)u).getBiografia());
            statement.setString(3, ((Artista)u).getWeb());
            statement.setString(4, u.getNickname());
            statement.setString(5, u.getEmail());
            statement.executeUpdate();
            statement.close();
            
            return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
    }
    
}
