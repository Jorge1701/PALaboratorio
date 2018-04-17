/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Nicolas
 */
@Entity
public class Tecnico extends Persona{
    
    private String contrasena;
    
    @OneToMany(mappedBy = "tecnico")
    private List<TareaDeUnReclamo> tareas_a_realizar;
    @ManyToMany
    private List<TipoDeArticulo> tipoarticulo_capacitado;

    public Tecnico() {
        
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<TareaDeUnReclamo> getTareas_a_realizar() {
        return tareas_a_realizar;
    }

    public void setTareas_a_realizar(List<TareaDeUnReclamo> tareas_a_realizar) {
        this.tareas_a_realizar = tareas_a_realizar;
    }

    public List<TipoDeArticulo> getTipoarticulo_capacitado() {
        return tipoarticulo_capacitado;
    }

    public void setTipoarticulo_capacitado(List<TipoDeArticulo> tipoarticulo_capacitado) {
        this.tipoarticulo_capacitado = tipoarticulo_capacitado;
    }
    
    public void nuevoTareaDeUnReclamo(TareaDeUnReclamo r){
        tareas_a_realizar.add(r);
    }
    
    
    
    
}