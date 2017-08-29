package Persistencia;

import Logica.DtLista;
import Logica.DtListaDefecto;
import Logica.Lista;
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
            String tipo = "";
            if (dtl instanceof DtListaDefecto) {
                tipo = "D";
            } else {
                tipo = "P";
            }
            String sql = "INSERT INTO lista" + "(nombre,tipo) VALUES (?,?)";
            PreparedStatement statament = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statament.setString(1, dtl.getNombre());
            statament.setString(2, tipo);
            statament.executeUpdate();
            ResultSet rs = statament.getGeneratedKeys();
            rs.next();
            int idLista = Integer.parseInt(rs.getString(1));

            //statament.close();
            if (dtl instanceof DtListaDefecto) {
                PreparedStatement statament2 = conexion.prepareStatement("INSERT INTO listapordefecto(idLista,nombreGenero) VALUES (?,?)");

                statament2.setInt(1, idLista);
                statament2.setString(2, ((DtListaDefecto) dtl).getGenero().getNombre());
                statament2.executeUpdate();
                statament2.close();
                statament.close();

                return true;

            } else {
                PreparedStatement statament4 = conexion.prepareStatement("INSERT INTO listaparticular (idLista,nickname,Publica) VALUES (?,?,?)");
                statament4.setInt(1, idLista);
                statament4.setString(2, nickCliente);
                statament4.setString(3, "N");
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

    public boolean publicarLista(Lista l) {

        try {
            PreparedStatement sql = conexion.prepareStatement("SELECT idLista FROM lista WHERE nombre = '" + l.getNombre() + "'");
            ResultSet id = sql.executeQuery();
            id.next();
            int idLista = id.getInt(1);
            PreparedStatement sql2 = conexion.prepareStatement("UPDATE listaparticular SET Publica='S' WHERE idLista = '" + idLista + "'");
            sql2.executeUpdate();
            sql.close();
            sql2.close();
            return true;
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

    public boolean insertarTemaALista(String nickArtista, int idAlbum, int idTema, int idLista) {
        try {
            System.out.println("Persistencia.BDLista.insertarTemaALista()" + " | " + nickArtista + " | " + idAlbum + " | " + idTema + " | " + idLista);
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO listatienetemas (nickname, idAlbum, idTema, idLista) VALUES (?, ?, ?, ?)");
            insert.setString(1, nickArtista);
            insert.setInt(2, idAlbum);
            insert.setInt(3, idTema);
            insert.setInt(4, idLista);
            insert.executeUpdate();
            insert.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
