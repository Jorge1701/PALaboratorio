package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}