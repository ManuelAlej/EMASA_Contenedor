/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author malex
 */


@Named(value = "boton")
@SessionScoped
public class Boton implements Serializable {

    /**
     * Creates a new instance of Boton
     */
    public Boton() {
    }    

    public String ot() {

        return "bandejaOrdenTrabajo.xhtml";
    }

    public String asignarVisita() {

        return "asignarVisitaClient.xhtml";
    }

    public String reasignarAviso() {

        return "reasignarAvisoClient.xhtml";
    }

    public String avisosRelacionados() {

        return "asignarRelacionClient.xhtml";
    }

    public String opcionesAvisos() {

        return "avisoClient.xhtml";
    }
    
    public String volverBandeja()
    {
        return "bandejaAvisosClient.xhtml";
    }
    
    public String crearOT()
    {
        return "crearOrdenTrabajoClient.xhtml";
    }
  
    
}
