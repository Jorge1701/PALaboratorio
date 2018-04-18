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
public class DataPersona {
    private Integer ci;
    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer telefono;
    private Date fecha_nacimiento;

    public DataPersona(Integer ci, String nombre, String apellido, String domicilio, Integer telefono, Date fecha_nacimiento) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    
    
}
