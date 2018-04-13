/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Tecnico;
import Logica.Clases.Cliente;
import Logica.Clases.Administrador;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class ControladorPersonas implements Logica.Interface.InterfacePersonas{
    
    private List<Tecnico> tecnicos;
    private List<Cliente> clientes;
    private List<Administrador> administradores;
    
    private ControladorPersonas() {
    }
    
    public static ControladorPersonas getInstance() {
        return ControladorPersonasHolder.INSTANCE;
    }
    
    private static class ControladorPersonasHolder {

        private static final ControladorPersonas INSTANCE = new ControladorPersonas();
    }
}
