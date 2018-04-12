/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class Reclamo {
    
    private Integer id;
    private String descripcion;
    private String nombre;
    private Date fecha_ingreso;
    private Boolean cerrado;
    private TipoReclamo tipo;
    private Date fecha_visita;
    
    private TipoDeArticulo tipodearticulo;
    private Cliente cliente;
    private List<TareaDeUnReclamo> tarea_reclamo;
    
    

    public Reclamo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public TipoReclamo getTipo() {
        return tipo;
    }

    public void setTipo(TipoReclamo tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(Date fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public TipoDeArticulo getTipodearticulo() {
        return tipodearticulo;
    }

    public void setTipodearticulo(TipoDeArticulo tipodearticulo) {
        this.tipodearticulo = tipodearticulo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<TareaDeUnReclamo> getTarea_reclamo() {
        return tarea_reclamo;
    }

    public void setTarea_reclamo(List<TareaDeUnReclamo> tarea_reclamo) {
        this.tarea_reclamo = tarea_reclamo;
    }
    
    
    
    
    
}
