package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente extends BDUsuario {
    
    public boolean agregarListaDefaultFav(String nomGenero, String nomLista, String nomCliente) {
        try {
            int idLista = obtenerIdListaDefecto(obtenerIdGenero(nomGenero), nomLista);
            
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favl VALUES (?, ?)");
            agregar.setString(1, nomCliente);
            agregar.setInt(2, idLista);
            agregar.executeUpdate();
            agregar.close();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean agregarListaParticularFav(String duenio, String nomLista, String cliente) {
        try {
            int idLista = obtenerIdListaParticular(duenio, nomLista);
            
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favl VALUES (?, ?)");
            agregar.setString(1, cliente);
            agregar.setInt(2, idLista);
            agregar.executeUpdate();
            agregar.close();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean agregarAlbumFav(String nickArt, String nomAlbum, String nickCli){
        try {
            int idAlbum = obtenerIdAlbum(nickArt, nomAlbum);
            
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO fava VALUES (?, ?, ?)");
            agregar.setInt(1, idAlbum);
            agregar.setString(2, nickArt);
            agregar.setString(3, nickCli);
            agregar.executeUpdate();
            agregar.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private int obtenerIdGenero(String nombre) {
        try {
            PreparedStatement buscar = conexion.prepareStatement("SELECT idGenero FROM genero WHERE nombre = '" + nombre + "'");
            ResultSet rs = buscar.executeQuery();
            
            int idGenero = 0;
            while (rs.next())
                idGenero = rs.getInt("idGenero");
            
            rs.close();
            buscar.close();
            
            return idGenero;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    private int obtenerIdListaDefecto(int idGenero, String nombreLista) {
        try {
            PreparedStatement buscar = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listapordefecto AS ld WHERE l.idLista = ld.idLista AND l.nombre = ? AND ld.idGenero = ?");
            buscar.setString(1, nombreLista);
            buscar.setInt(2, idGenero);
            
            int idLista = 0;
            ResultSet rs = buscar.executeQuery();
            while (rs.next())
                idLista = rs.getInt(1);
            
            rs.close();
            buscar.close();
            
            return idLista;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    private int obtenerIdListaParticular(String cliente, String nomLista) {
        try {
            PreparedStatement lista = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listaparticular AS lp WHERE l.idLista = lp.idLista AND l.nombre = ? AND lp.nickname = ?");
            lista.setString(1, nomLista);
            lista.setString(2, cliente);
            
            int idLista = 0;
            ResultSet rs = lista.executeQuery();
            while (rs.next())
                idLista = rs.getInt(1);
            rs.close();
            lista.close();
            
            return idLista;
        } catch (SQLException e) {
            e.printStackTrace();;
            return 0;
        }
    }
    
    private int obtenerIdAlbum(String nickArt, String nomAlbum) {
        try {
            PreparedStatement buscar = conexion.prepareStatement("SELECT idAlbum FROM album WHERE nickname = ? AND nombre = ?");
            buscar.setString(1, nickArt);
            buscar.setString(2, nomAlbum);
            ResultSet rs = buscar.executeQuery();
            int id = 0;
            while (rs.next())
                id = rs.getInt("idAlbum");
            rs.close();
            buscar.close();
            
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return 0;
    }
}