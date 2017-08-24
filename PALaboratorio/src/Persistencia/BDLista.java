package Persistencia;

import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.DtListaParticular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDLista {

    protected Connection conexion = new ConexionBD().getConexion();

    public boolean altaLista(DtLista dtl, String nickCliente) {
        try {
            String sql = "INSERT INTO lista" + "(nombre) VALUES (?)";
            PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statament.setString(1, dtl.getNombre());
            statament.executeUpdate();
            ResultSet rs = statament.getGeneratedKeys();
            rs.next();
            int idLista = Integer.parseInt(rs.getString(1));
            //statament.close();
            
            if (dtl instanceof DtListaDefecto) {
                
                PreparedStatement statament2 = conexion.prepareStatement("INSERT INTO listapordefecto"
                        +"(nombre,idLista,nombreGenero) VALUES (?,?,?)");
                
                statament2.setString(1, dtl.getNombre());
                statament2.setInt(2, idLista);
                statament2.setString(3, ((DtListaDefecto) dtl).getGenero().getNombre());
                statament2.executeUpdate();
                //
                statament.close();
                statament2.close();
                return true;
                
            } else {

                String publica = "";
                if (((DtListaParticular) dtl).isPrivada()) {
                    publica = "N";
                } else {
                    publica = "S";
                }
                PreparedStatement statament4 = conexion.prepareStatement("INSERT INTO listaparticular"
                        + " VALUES (?,?,?,?)");
                
                statament4.setString(1, dtl.getNombre());
                statament4.setInt(2, idLista);
                statament4.setString(3, nickCliente);
                statament4.setString(4, publica);
                statament4.executeUpdate();
                statament4.close();
                statament.close();//
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDLista.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean quitarTemaLista(String NomUser, String NomLista, String NomTema) {
        try {
            if (NomUser == null) {
                String sql = "DELETE INTO listapordefecto WHERE " + "WHERE nombre=? and nomTema=?";
                PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statament.setString(1, NomUser);
                statament.setString(2, NomTema);
                statament.executeUpdate();
                statament.close();
            } else {
                String sql = "DELETE INTO listapordefecto WHERE " + "WHERE nombre=? and nomTema=? and nickname=?";
                PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statament.setString(1, NomLista);
                statament.setString(2, NomTema);
                statament.setString(2, NomUser);
                statament.executeUpdate();
                statament.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
