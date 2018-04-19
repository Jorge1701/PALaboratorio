/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

/**
 *
 * @author Nicolás
 */
public class DataTarea {
    
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double tiempoEstimado;

    public DataTarea(Integer id, String nombre, String descripcion, Double tiempoEstimado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getTiempoEstimado() {
        return tiempoEstimado;
    }
    
    
}
