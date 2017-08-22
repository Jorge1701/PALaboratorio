/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Genero;
import Logica.Tema;
import Logica.Album;
import Logica.TemaLocal;
import Logica.TemaRemoto;
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
    
    public boolean altaAlbum(Album album){
    
        try {
            
            String sql = "INSERT INTO album" + "(nicknameArtista, nombre, anio) VALUES (?,?,?)";
            PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statament.setString(1, album.getNickArtista());
            statament.setString(2, album.getNombre());
            statament.setInt(3, album.getAnio());
            statament.executeUpdate();
            ResultSet rs = statament.getGeneratedKeys();
            rs.next();
            int idAlbum = Integer.parseInt(rs.getString(1));
            statament.close();
            
            HashMap<String, Tema> temas = album.getTemas();
            Iterator i = temas.entrySet().iterator();
            while (i.hasNext()) {
                Tema t = (Tema) ((Map.Entry) i.next()).getValue();
                String sqlT = "INSERT INTO tema(nicknameArtista, idAlbum, nombre, duracion, ubicacion, tipo, link) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement statament2 = conexion.prepareStatement(sqlT, PreparedStatement.RETURN_GENERATED_KEYS);
                statament2.setString(1, album.getNickArtista());
                statament2.setInt(2, idAlbum);
                statament2.setString(3, t.getNombre());
                String duracion = String.valueOf(t.getDuracion().getHoras())+":"+String.valueOf(t.getDuracion().getMinutos())+":"+ String.valueOf(t.getDuracion().getSegundos());
                statament2.setString(4, duracion);
                statament2.setInt(5, t.getUbicacion());
                if(t instanceof TemaLocal){
                    statament2.setString(6, "L");
                    statament2.setString(7, ((TemaLocal) t).getDirectorio());                    
                
                } else if (t instanceof TemaRemoto) {
                     statament2.setString(6, "R");
                     statament2.setString(7, ((TemaRemoto) t).getUrl());
                }
                statament2.executeUpdate();
                ResultSet rset = statament2.getGeneratedKeys();
                rset.next();
                int idtema = Integer.parseInt(rset.getString(1));
                
                t.setId(idtema);
                statament2.close();
                //System.out.println("Idtema: " + idtema );
                                
            }
                
            Iterator i2 = temas.entrySet().iterator();
             while (i2.hasNext()) {
                String sqlT = "INSERT INTO temastienealbum(idTema, idAlbum, nicknameArtista) VALUES (?,?,?)";
                PreparedStatement statament3 = conexion.prepareStatement(sqlT);
                Tema t = (Tema) ((Map.Entry) i2.next()).getValue();
                statament3.setInt(1, t.getId());
                statament3.setInt( 2, idAlbum);
                statament3.setString(3, album.getNickArtista());
                statament3.executeUpdate();                
                statament3.close();
                
             }
             
             ArrayList<Genero> gros = album.getGeneros();
             for (int e = 0; e < gros.size(); e++) {
                Genero g = gros.get(e);
                String sqlT = "INSERT INTO clasificacionalbum(idAlbum, nickname, nombreGenero) VALUES (?,?,?)";
                PreparedStatement statament4 = conexion.prepareStatement(sqlT);
                statament4.setInt(1, idAlbum);
                statament4.setString(2, album.getNickArtista());
                statament4.setString(3, g.getNombre());
                statament4.executeUpdate();
                statament4.close();
             }  
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    
    
    
}
