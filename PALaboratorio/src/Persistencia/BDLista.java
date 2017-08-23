package Persistencia;
import Logica.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class BDLista {
    
    protected Connection conexion = new ConexionBD().getConexion();
    public boolean altaLista(String nombreList,String NombreTema, String NombreCliente,String Genero){
        try{
            
        String sql = "INSERT INTO lista VALUES(?,?)"; 
        PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statament.setString(1, nombreList);
        statament.setString(2, NombreTema);
        statament.executeUpdate();
        statament.close();
        if(Genero==null){
            if(altaListaParticular(nombreList, nombreList, NombreTema, sql)){
                return true;
            }else return false;      
        }else{
            if(altaListaPorDefecto(nombreList, Genero, NombreTema)){
                return true;
            }else return false;
        } 
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean altaListaPorDefecto(String nombreLista, String genero, String NombreTema){
     
    return true;
    }
    public boolean altaListaParticular(String nombreLista, String nombreCliente, String nombreTema, String Publica ){
    return true;
    }
    
    public boolean quitarTemaLista(String NomUser,String NomLista, String NomTema){
    try{
        if(NomUser==null){
        String sql= "DELETE INTO listapordefecto WHERE "+"WHERE nombre=? and nomTema=?";
         PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
         statament.setString(1, NomUser);
         statament.setString(2, NomTema);
         statament.executeUpdate();
         statament.close();
        }else{
         String sql= "DELETE INTO listapordefecto WHERE "+"WHERE nombre=? and nomTema=? and nickname=?";
         PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
         statament.setString(1, NomLista);
         statament.setString(2, NomTema);
         statament.setString(2, NomUser);
         statament.executeUpdate();
         statament.close();
        }
        return true;
    }    
    catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
   
    }
}
