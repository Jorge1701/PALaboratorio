/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Reclamo;
import Logica.Clases.TareaDeUnReclamo;
import java.util.List;

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
}
