/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Genero;
import Logica.Tema;
import Logica.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Diego
 */
public class BDAlbum {
    
   protected Connection conexion = new ConexionBD().getConexion();
    
    public boolean altaAlbum(String emailA, Album album){
    
        try {
            
            String sql = "INSERT INTO album" + "(nombre, nickname, correo) VALUES (?,?,?)";
            PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statament.setString(1, album.getNombre());
            statament.setString(2, album.getNickArtista());
            statament.setString(3, emailA);
            statament.executeUpdate();
            ResultSet rs = statament.getGeneratedKeys();
            rs.next();
            int idAlbum = Integer.parseInt(rs.getString(1));
            statament.close();
            
            HashMap<String, Tema> temas = album.getTemas();
            Iterator i = temas.entrySet().iterator();
            while (i.hasNext()) {
                Tema t = (Tema) ((Map.Entry) i.next()).getValue();
                String sqlT = "INSERT INTO tema(nombre) VALUES (?)";
                PreparedStatement statament2 = conexion.prepareStatement(sqlT, PreparedStatement.RETURN_GENERATED_KEYS);
                statament2.executeUpdate();
                ResultSet rset = statament2.getGeneratedKeys();
                rset.next();
                int idtema = Integer.parseInt(rset.getString(1));
                
                album.getTemas().get(i).setId(idtema);
                statament2.close();
                System.out.println("Idtema: " + idtema );
                                
            }
    
            Iterator i2 = temas.entrySet().iterator();
             while (i2.hasNext()) {
                String sqlT = "INSERT INTO temastienealbum(idTema, idAlbum, nickname, correo) VALUES (?,?,?,?)";
                PreparedStatement statament3 = conexion.prepareStatement(sqlT);
                Tema t = (Tema) ((Map.Entry) i2.next()).getValue();
                statament3.setInt(1, t.getId());
                statament3.setInt( 2, idAlbum);
                statament3.setString(3, album.getNickArtista());
                statament3.setString(4, emailA);
                //statament2.setString(2, java.sql.Time.valueOf(duracion
                statament3.executeUpdate();                
                statament3.close();
                
             }
            
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
    
    
}
