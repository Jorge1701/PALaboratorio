/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
//package Persistencia;




import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class BDGenero {

    
    
    
    
    
    public void llenar_genero( JList listagenero) throws SQLException//  funcion que le paso una lista y me la llena con el genero 
            {
              
              
              
                
                
                DefaultListModel modeloLista = new DefaultListModel();
               // modeloLista.addElement("Seleccione un usuario");
                 //listagenero.setModel(modeloLista);
                  ConexionBD test = new ConexionBD ();
                    if(test.conectar())
                    {
                      ResultSet rs= test.Consultar("SELECT nombre FROM  genero"); // consulta para devolver el nombre delgenero, llamo a la funcion consultar para que me devuelva datos
                         while (rs.next()) {
                            modeloLista.addElement(rs.getObject("nombre"));
                             listagenero.setModel(modeloLista);
                        }
                    }
                    }
    
    
    public void ActualizarTablaGenero(JTable jtabla){   
         //------------------------creo un modelo el cual no deja editar la celda
         
  DefaultTableModel modelo = new DefaultTableModel()
 {@Override
     public boolean isCellEditable (int fila, int columna) {
         if (columna > 5)
             return true;
         return false;
     }
 };

  //---------------------------------------------------------
jtabla.setModel(modelo);//le asigno a la tabla el modelo de   .
jtabla.getTableHeader().setReorderingAllowed(false);
      try {
          ConexionBD test = new ConexionBD ();
        if(test.conectar())
        {
         

           ResultSet rs= test.Consultar("SELECT idGenero,nombre FROM genero");
         //creo 3 columnas con sus etiquetas
        //estas son las columnas del JTable
         modelo.addColumn("id");
         modelo.addColumn("Genero");
       
         //setAnchoColumnas(jtabla);
         while(rs.next()){
             //vernombreempleado(rs.getInt("idEmpleado"));
            Object []ob=new Object[2];//Crea un vector
            //para almacenar los valores del ResultSet
           ob[0]=(rs.getString("idGenero"));
            ob[1]=(rs.getString("nombre"));
           
            
            //añado el modelo a la tabla
            modelo.addRow(ob);
            ob=null;//limpia los datos de el vector de la memoria
         }         
         rs.close();
         }
      }catch (Exception ex) {
                System.out.println(ex.getMessage());
      }    
       jtabla.getColumnModel().getColumn(0).setMaxWidth(0);
      jtabla.getColumnModel().getColumn(0).setMinWidth(0);
      jtabla.getColumnModel().getColumn(0).setPreferredWidth(0);

      
   }
    
    
    
    
      public boolean insertar_genero(String nombre) // funcion que inserta a la base de datos un genero nuevo( y devuelve tru or false) , pasandole como parametroel nbombre, llamo a ejecutar. 
     {
         
      ConexionBD test = new ConexionBD ();
       test.conectar();
       return test.Ejecutar("INSERT INTO genero(nombre) VALUE('"+nombre+"')");
  
     }
      public boolean insertar_subgenero(String idgen,String nombresub) // funcion que inserta a la base de datos un genero nuevo( y devuelve tru or false) , pasandole como parametroel nbombre, llamo a ejecutar. 
     {
         
      ConexionBD test = new ConexionBD ();
       test.conectar();
       return test.Ejecutar("INSERT INTO subgenero(idGenero,nombreSubGenero) VALUE('"+idgen+"','"+nombresub+"')");
  
     }

  
     
 }

    


  

