/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Datos;
import emasa.entidades.Empleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author malex
 */
@Named(value = "inicializarSupervisores")
@SessionScoped
public class InicializarSupervisores implements Serializable {

    public List<Empleado> getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(List<Empleado> supervisores) {
        this.supervisores = supervisores;
    }

    private List<Empleado> supervisores;
    private List<Empleado> empleados;
    /**
     * Creates a new instance of inicializarSupervisores
     */
    public InicializarSupervisores() {
    }
    @Inject
    
    private Datos datos;
    
    @PostConstruct
    public void init() {

        empleados = datos.getEmpleados();
        supervisores=new ArrayList<>();
        
        for (Empleado e: empleados)
        {
            if (e.getCargo().equals("Supervisor"))
            {
                supervisores.add(e);
            }
        }

        

    }
    
    
}
