/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Tarea;
import Logica.Clases.TipoDeArticulo;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class ControladorTareas implements Logica.Interface.InterfaceTareas{
    
    private List<Tarea> tareas;
    private List<TipoDeArticulo> tiposdearticulos;
    
    private ControladorTareas() {
    }
    
    public static ControladorTareas getInstance() {
        return ControladorTareasHolder.INSTANCE;
    }
    
    private static class ControladorTareasHolder {

        private static final ControladorTareas INSTANCE = new ControladorTareas();
    }
}
