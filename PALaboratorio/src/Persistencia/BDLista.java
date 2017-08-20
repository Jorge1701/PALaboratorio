/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author brian
 */
public class BDLista {
    
    protected Connection conexion = new ConexionBD().getConexion();
    
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
