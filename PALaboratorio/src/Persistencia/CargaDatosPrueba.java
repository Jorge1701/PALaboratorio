package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargaDatosPrueba {
    
    protected Connection conexion = new ConexionBD().getConexion();
    
    public boolean borrarTodosLosDatos() {
        try {
            PreparedStatement query = conexion.prepareStatement("SHOW TABLES");
            
            ResultSet tablas = query.executeQuery();
            
            while (tablas.next())
                borrarDatosTabla(tablas.getString(1));
            
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