package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente extends BDUsuario {
    
    public boolean agregarListaDefaultFav(String nomGenero, String nomLista, String nomCliente) {
        try {
            String correoCliente = obtenerCorreo(nomCliente);
            int idLista = obtenerIdListaDefecto(obtenerIdGenero(nomGenero), nomLista);
            
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favl VALUES (?, ?, ?)");
            agregar.setString(1, nomCliente);
            agregar.setString(2, correoCliente);
            agregar.setInt(3, idLista);
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
            String correoCliente = obtenerCorreo(cliente);
            int idLista = obtenerIdListaParticular(duenio, nomLista);
            
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO favl VALUES (?, ?, ?)");
            agregar.setString(1, cliente);
            agregar.setString(2, correoCliente);
            agregar.setInt(3, idLista);
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
            String correoArt = obtenerCorreo(nickArt);
            String correoCli = obtenerCorreo(nickCli);
            int idAlbum = obtenerIdAlbum(nickArt, correoArt, nomAlbum);
            
            PreparedStatement agregar = conexion.prepareStatement("INSERT INTO fava VALUES (?, ?, ?, ?, ?)");
            agregar.setInt(1, idAlbum);
            agregar.setString(2, nickArt);
            agregar.setString(3, correoArt);
            agregar.setString(4, nickCli);
            agregar.setString(5, correoCli);
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
            PreparedStatement buscar = conexion.prepareStatement("SELECT FROM lista AS l, listapordefecto AS ld WHERE l.idLista = ld.idLista AND l.nombre = ? AND ld.idGenero = ?");
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
            e.printStackTrace();;
            return 0;
        }
    }
    
    private int obtenerIdListaParticular(String cliente, String nomLista) {
        try {
            String correoCliente = obtenerCorreo(cliente);
            
            PreparedStatement lista = conexion.prepareStatement("SELECT l.idLista FROM lista AS l, listaparticular AS lp WHERE l.idLista = lp.idLista AND l.nombre = ? AND lp.nickname = ? AND lp.correo = ?");
            lista.setString(1, nomLista);
            lista.setString(2, cliente);
            lista.setString(3, correoCliente);
            
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
    
    private int obtenerIdAlbum(String nickArt, String correoArt, String nomAlbum) {
        try {
            PreparedStatement buscar = conexion.prepareStatement("SELECT idAlbum FROM album WHERE nickname = ? AND correo = ? AND nombre = ?");
            buscar.setString(1, nickArt);
            buscar.setString(2, correoArt);
            buscar.setString(3, nomAlbum);
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