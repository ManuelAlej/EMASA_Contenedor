/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Lupi
 */
@Named(value = "datos")
@SessionScoped
public class Datos implements Serializable {
    private List<Empleado> empleados;
    private List<Cliente> clientes;
    private List<Aviso> avisos; 
    private List<Brigada> brigadas;
    private Visitas visita;

    public Datos() {
    }
    
    @PostConstruct
    public void init(){
        empleados = new ArrayList<Empleado>();
        empleados.add(new Empleado(1,"Lupicinio", "García Ortiz", "25700495L", "orialuga@gmail.com", "lupi", "Aguas Blancas", "Supervisor", 1));
        empleados.add(new Empleado(2,"Pilar", "Mata", "25700496L", "pilar@gmail.com", "pilar", "Aguas Blancas", "Supervisor", 2));
        empleados.add(new Empleado(3,"Manuel", "Ortega", "25700510L", "manuel@gmail.com", "manuel", "Atención telefonica", "SAT", 1));
        Empleado e1=new Empleado(4,"Adrian", "Perez", "25850495L", "adrian@gmail.com", "adrian", "Aguas Blancas", "OPmov", 1);//lo uso para asignarle la visita
        empleados.add(e1);
        empleados.add(new Empleado(5,"Jose", "Perez", "25888495L", "jose@gmail.com", "jose", "Aguas Blancas", "brigada", 1));
        
        clientes =new ArrayList<>();
        clientes.add(new Cliente("32066973", "Manuel Ortega"));
        clientes.add(new Cliente("32066995", "Ale Ortega"));
        
        avisos =new ArrayList<>();
        Aviso a1 =new Aviso(1,new Date(),"SAT");
        Historico h1 = new Historico(new HistoricoPK(1, new Date(), 2), "se fuga el agua", "Calle Guatemala", "abierto", Boolean.FALSE);
        h1.setUrgencia("Prioritario");
        h1.setAviso(a1);
        List<Historico> h1list = new ArrayList<>();
        h1list.add(h1);
        a1.setHistoricoCollection(h1list);
        avisos.add(a1);
      
        visita = new Visitas(new Date(), e1);
        visita.setHistorico(h1);
        List<Visitas> visitas=new ArrayList<>();
        visitas.add(visita);
        e1.setVisitasCollection(visitas);
        
        
        Aviso a2 =new Aviso(2,new Date(),"SAT");
        Historico h2 = new Historico(new HistoricoPK(2, new Date(), 2), "Ha explotado una tuberia", "Calle Paris", "en cola", Boolean.FALSE);
        h2.setUrgencia("Planificable");
        List<Historico> h2list = new ArrayList<>();
        h2list.add(h2);
        a2.setHistoricoCollection(h2list);
        avisos.add(a2);
        
        brigadas = new ArrayList<>();
        brigadas.add(new Brigada(1, 1, 'N'));
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }
    
    
    
}
