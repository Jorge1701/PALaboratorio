/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import java.util.Date;

/**
 *
 * @author Nicolás
 */
public class DataTecnico extends DataPersona{

    public DataTecnico(Integer ci, String nombre, String apellido, String domicilio, Integer telefono, Date fecha_nacimiento) {
        super(ci, nombre, apellido, domicilio, telefono, fecha_nacimiento);
    }
       
    
}
