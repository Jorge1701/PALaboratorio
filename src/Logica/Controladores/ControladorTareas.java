/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Tarea;
import Logica.Clases.TipoDeArticulo;
import Logica.DataTypes.DataTarea;
import Logica.DataTypes.DataTipoArticulo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nicolas
 */
public class ControladorTareas implements Logica.Interface.InterfaceTareas{    
    
    private ControladorTareas() {
    }
    
    public static ControladorTareas getInstance() {
        return ControladorTareasHolder.INSTANCE;
    }
    
    private static class ControladorTareasHolder {

        private static final ControladorTareas INSTANCE = new ControladorTareas();
    }    
    
    public List<DataTarea> darTareasCodTA(Integer codTA){
        List<DataTarea> tareas = new ArrayList<>();
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        TipoDeArticulo tart = em.find(TipoDeArticulo.class, codTA);
        List<Tarea> tareas_tart = tart.getTareas();
        for (Tarea tarea : tareas_tart) {
           tareas.add(new DataTarea(tarea.getId(), tarea.getNombre(), tarea.getDescripcion()));
        }
        return tareas;  
    }
    
    public void AltaTarea(DataTarea tar){
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        em.getTransaction().begin();
        Tarea tarea = new Tarea(tar);
        em.persist(tarea);
        em.getTransaction().commit();
        em.close();
    }
    
    public void AltaTipoArticulo(DataTipoArticulo tart){
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        em.getTransaction().begin();
        TipoDeArticulo tipoarticulo = new TipoDeArticulo(tart);
        em.persist(tipoarticulo);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<DataTipoArticulo> darTipoArticulos(){
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        List<DataTipoArticulo> tartadevolver = new ArrayList<>();
        Query query = em.createQuery("SELECT i FROM TipoDeArticulo i");
        List<TipoDeArticulo> tiposdearticulos = query.getResultList();
        for (TipoDeArticulo tart : tiposdearticulos) {
            tartadevolver.add(new DataTipoArticulo(tart.getId(), tart.getNombre()));
        }
        return tartadevolver;
    }
    
    
}
