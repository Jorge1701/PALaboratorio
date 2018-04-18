/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

import Logica.Clases.Cliente;
import Logica.Clases.TareaDeUnReclamo;
import Logica.Clases.TipoDeArticulo;
import Logica.Clases.TipoReclamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Nicolás
 */
public class DataReclamo {
    
    private Integer id;
    private String descripcion;
    private String nombre;
    private Date fecha_ingreso;
    private Boolean cerrado;
    private TipoReclamo tipo;
    private Date fecha_visita;
    //las asociaciones las veo despues

    public DataReclamo() {
    }

    public DataReclamo(Integer id, String descripcion, String nombre, Date fecha_ingreso, Boolean cerrado, TipoReclamo tipo, Date fecha_visita) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.cerrado = cerrado;
        this.tipo = tipo;
        this.fecha_visita = fecha_visita;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public TipoReclamo getTipo() {
        return tipo;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }
    
    
}
