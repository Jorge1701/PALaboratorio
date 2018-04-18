/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Cliente;
import Logica.Clases.Reclamo;
import Logica.Clases.Tarea;
import Logica.Clases.TareaDeUnReclamo;
import Logica.Clases.Tecnico;
import Logica.Clases.TipoDeArticulo;
import Logica.DataTypes.DataReclamo;
import Logica.DataTypes.DataTarea;
import Logica.DataTypes.DataTecnico;
import Logica.DataTypes.DataTipoArticulo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Nicolas
 */
public class ControladorReclamos implements Logica.Interface.InterfaceReclamos{
    
    private List<Reclamo> reclamos;
    private List<TareaDeUnReclamo> tareas_reclamos;
    
    private ControladorReclamos() {
    }
    
    public static ControladorReclamos getInstance() {
        return ControladorReclamosHolder.INSTANCE;
    }
    
    private static class ControladorReclamosHolder {

        private static final ControladorReclamos INSTANCE = new ControladorReclamos();
    }
    
    public void AltaReclamo(DataReclamo rec, Integer tipoArt, Integer[] ciTec, Integer[] idTar, Integer ciCliente){
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        TipoDeArticulo tipodearticulo = em.find(TipoDeArticulo.class, tipoArt);
        Cliente cliente = em.find(Cliente.class,ciCliente);
        em.getTransaction().begin();
        
        Reclamo r = new Reclamo();
        r.setNombre(rec.getNombre());
        r.setDescripcion(rec.getDescripcion());
        r.setFecha_ingreso(rec.getFecha_ingreso());
        r.setCerrado(rec.getCerrado());
        r.setTipo(rec.getTipo());
        r.setCliente(cliente);
        r.setTipodearticulo(tipodearticulo);
        
        for (int i = 0; i < ciTec.length; i++) {
            Tecnico te = em.find(Tecnico.class, ciTec[i]);
            Tarea ta = em.find(Tarea.class, idTar[i]);
            r.nuevaTareaTecnico(te, ta);
        }
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        
    }
    
    public List<DataTarea> darTareas(Integer codTA){
        return ControladorTareas.getInstance().darTareasCodTA(codTA);
    }
    
    public List<DataTecnico> darTecnicos(Integer codTA){
        return ControladorPersonas.getInstance().darTecnicosCodTA(codTA);
    }
    
    public List<DataTipoArticulo> darTipoArticulos(){
        return ControladorTareas.getInstance().darTipoArticulos();
    }
}
