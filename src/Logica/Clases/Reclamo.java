/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.Controladores.ControladorPersonas;
import Logica.Controladores.ControladorPrincipal;
import Logica.Controladores.ControladorReclamos;
import Logica.DataTypes.DataCliente;
import Logica.DataTypes.DataPersona;
import Logica.DataTypes.DataReclamo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

/**
 *
 * @author Nicolas
 */
@Entity
public class Reclamo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descripcion;
    private String nombre;
    private Date fecha_ingreso;
    private Boolean cerrado;
    private TipoReclamo tipo;
    private Date fecha_visita;
    
    @ManyToOne
    private TipoDeArticulo tipodearticulo;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
    private List<TareaDeUnReclamo> tarea_reclamo = new ArrayList<>();
    
    

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

    public void nuevaTareaTecnico(Tecnico te, Tarea ta){
        TareaDeUnReclamo tr = new TareaDeUnReclamo(te,ta);
        this.tarea_reclamo.add(tr);
        ControladorPrincipal.getInstance().getEntity().persist(tr);
    }
    
    
    
}

class main {
    public static void main(String[] args){
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        
        ControladorPersonas.getInstance().capacitarTecnicoEnTA(50475087, 1);
    }
}