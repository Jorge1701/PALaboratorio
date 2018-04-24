/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Excepciones;

/**
 *
 * @author Nicolas
 */
public class ExcesoHorasTecnico extends Exception {

    private Integer ci;
    private String nombreTecnico;
    private String apellido;
    private Double horasQueTrabaja;
    /**
     * Creates a new instance of <code>ExcesoHorasTecnico</code> without detail
     * message.
     */
    public ExcesoHorasTecnico() {
    }

    public ExcesoHorasTecnico(Integer ci, String nombreTecnico, String apellido, Double horasQueTrabaja) {
        this.ci = ci;
        this.nombreTecnico = nombreTecnico;
        this.apellido = apellido;
        this.horasQueTrabaja = horasQueTrabaja;
    }

    public Integer getCi() {
        return ci;
    }

    public String getNombreTecnico() {
        return nombreTecnico;
    }

    public String getApellido() {
        return apellido;
    } 

    public Double getHorasQueTrabaja() {
        return horasQueTrabaja;
    }
    
    

    /**
     * Constructs an instance of <code>ExcesoHorasTecnico</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcesoHorasTecnico(String msg) {
        super(msg);
    }
}
