/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Cliente;
import Logica.Clases.Tecnico;
import Logica.Clases.TipoDeArticulo;
import Logica.DataTypes.DataPersona;
import Logica.DataTypes.DataTecnico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nicolas
 */
public class ControladorPersonas implements Logica.Interface.InterfacePersonas{
    
    private ControladorPersonas() {
    }
    
    public static ControladorPersonas getInstance() {
        return ControladorPersonasHolder.INSTANCE;
    }
    
    private static class ControladorPersonasHolder {

        private static final ControladorPersonas INSTANCE = new ControladorPersonas();
    }
    
    public List<DataTecnico> darTecnicosCodTA(Integer codTA){
        List<DataTecnico> tecnicosADevolver = new ArrayList<>();
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        Query query = em.createQuery("SELECT i FROM Tecnico i");
        List<Tecnico> tecnicos = query.getResultList();
        for (Tecnico tec : tecnicos) {
            for (TipoDeArticulo tipoDeArticulo : tec.getTipoarticulo_capacitado()) {
                if(tipoDeArticulo.getId().equals(codTA)){
                    tecnicosADevolver.add(new DataTecnico(tec.getCi(),tec.getNombre(),tec.getApellido(),tec.getDomicilio()
                    ,tec.getTelefono(),tec.getFecha_nacimiento()));
                }
            }
        }
        return tecnicosADevolver;
    }
    
    public void AltaPersona(DataPersona persona){
        EntityManager em = ControladorPrincipal.getInstance().getEntity();
        em.getTransaction().begin();
           if(persona instanceof DataTecnico){
               Tecnico te = new Tecnico();
               te.setCi(persona.getCi());
               te.setNombre(persona.getNombre());
               te.setApellido(persona.getApellido());
               te.setDomicilio(persona.getDomicilio());
               te.setTelefono(persona.getTelefono());
               te.setFecha_nacimiento(persona.getFecha_nacimiento());
               em.persist(te);
           }
           else{
               Cliente cli = new Cliente();
               cli.setCi(persona.getCi());
               cli.setNombre(persona.getNombre());
               cli.setApellido(persona.getApellido());
               cli.setDomicilio(persona.getDomicilio());
               cli.setTelefono(persona.getTelefono());
               cli.setFecha_nacimiento(persona.getFecha_nacimiento());
               em.persist(cli);
           }
           em.getTransaction().commit();
           em.close();
    }
}
