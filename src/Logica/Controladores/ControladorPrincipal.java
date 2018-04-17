/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nicolas
 */
public class ControladorPrincipal {
    
    private ControladorPrincipal() {
    }
    
    public static ControladorPrincipal getInstance() {
        return ControladorPrincipalHolder.INSTANCE;
    }
    
    private static class ControladorPrincipalHolder {

        private static final ControladorPrincipal INSTANCE = new ControladorPrincipal();
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaReclamosPU");
        private static final EntityManager em = emf.createEntityManager();
    }
    
    
    public EntityManager getEntity(){
        return ControladorPrincipalHolder.em;
    }
    public void cerrarEntity(){
        ControladorPrincipalHolder.em.close();
    }
}
