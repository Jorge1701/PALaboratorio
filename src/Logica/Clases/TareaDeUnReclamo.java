/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nicolas
 */
@Entity
public class TareaDeUnReclamo implements Serializable {
    
    @Id
    private Integer id;
    private Boolean terminado;
    private Date fecha;
    private String nota;
    private Double tiempo;
    
    @ManyToOne
    private TipoDeArticulo tipodearticulo;
    //private Tecnico tecnico;

    public TareaDeUnReclamo() {
    }

    public Boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }

    public TipoDeArticulo getTipodearticulo() {
        return tipodearticulo;
    }

    public void setTipodearticulo(TipoDeArticulo tipodearticulo) {
        this.tipodearticulo = tipodearticulo;
    }

    /*public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }*/
    
    
    
    
}
