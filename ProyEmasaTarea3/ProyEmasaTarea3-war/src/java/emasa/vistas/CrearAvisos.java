package emasa.vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import emasa.entidades.Aviso;
import emasa.entidades.Cliente;
import emasa.entidades.Datos;
import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import emasa.entidades.HistoricoPK;
import emasa.negocio.AvisoNegocio;
import emasa.negocio.ClienteNegocio;
import emasa.negocio.EmpleadoNegocio;
import emasa.negocio.HistoricoNegocio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;


/**
 *
 * @author Adrian y Lupi
 */
@Named(value = "crearAvisos")
@SessionScoped
public class CrearAvisos implements Serializable {
    
    private Aviso nuevoAviso;
    private Cliente client;
    private String nombre ="";
    private String telefono="";
    private String poliza="";
    private String email="";
    private String dni="";
    private int idAviso;
    private String fecha="";
    private String origen="";
    private String descripcion="";
    private String direccion="";
    private String urgencia="";
    private String tipoAviso="";
    private String  causa="";
    private String  gps="";
    private String  redAgua="";
    private String  adjunto="";
    private Historico historico;
    
    @Inject
    private LoginBean login;
    
    private List<Cliente> clients;
    private List<Aviso> avisos;
    
    @EJB
    private ClienteNegocio clientEJB;
    
    @EJB
    private AvisoNegocio avisoEJB;
    
    @EJB
    private HistoricoNegocio historicoEJB;
    
    @EJB
    private EmpleadoNegocio empleadoEJB;

    public String getUrgencia() {
        return urgencia;
    }

    
    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
        
    }
    @PostConstruct
    public void init(){
        //clients=datos.getClientes();
        //avisos=datos.getAvisos();   
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoAviso() {
        return tipoAviso;
    }

    public void setTipoAviso(String tipoAviso) {
        this.tipoAviso = tipoAviso;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getRedAgua() {
        return redAgua;
    }

    public void setRedAgua(String redAgua) {
        this.redAgua = redAgua;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public Aviso getNuevoAviso() {
        return nuevoAviso;
    }

    public void setNuevoAviso(Aviso nuevoAviso) {
        this.nuevoAviso = nuevoAviso;
    }
    
    public String volverOp(){
        return "bandejaVisitasClient.xhtml";
    }
     public String volverSat(){
        return "index.xhtml";
    }
    
    public CrearAvisos() {
    }
    public String botonVolver(){
        return "bandejaVisitasClient.xhtml";
    }
    
    public String crearAvisoNuevo(){
        //----Adri------incluir cliente en historial----->
        //comprobar que si ponemos un set null, no pete
        
         //Datos del cliente
        Cliente newClient=new Cliente();
        newClient.setDni(dni);
        newClient.setEMail(email);
        newClient.setNombre(nombre);
        
       if(poliza != null){
          int pol=Integer.parseInt(poliza);
          newClient.setPoliza(pol);
       }
       else{
           newClient.setPoliza(null);
       }
        
       
       if(telefono != null){
           int tlf=Integer.parseInt(telefono);
            newClient.setTelefono(tlf);
       }else{
           newClient.setTelefono(null);
           
       }
       clientEJB.addClient(newClient);      
       //---hasta aqui Adri----  
        
        //crear aviso
        Aviso newAviso= new Aviso();
        //newAviso.setIdAviso(1);
        newAviso.setIdAviso(null);
        newAviso.setFechaEntrada(new Date());
        newAviso.setIdEmpleado(login.getUsr());
        
        if(login.getCargoUsuario() == null){
            newAviso.setOrigen("Cliente");
        }
        else{
            if(login.getCargoUsuario().equals("SAT")){
                newAviso.setOrigen("SAT"); 
            }
            else if(login.getCargoUsuario().equals("OPmov")){
                newAviso.setOrigen("OPmov");
            }
        }
        
        newAviso.setDni(newClient);  
        
        avisoEJB.crearAviso(newAviso); //persistir el aviso
        
        //creo que no hace falta controlar los null
        
        //persistir Historico
        //crear historico
        Historico newHistorico=new Historico();
        
        newHistorico.setAviso(newAviso);
        newHistorico.setCausa(causa);
        newHistorico.setDescripcion(descripcion);
        newHistorico.setDireccion(direccion);
        newHistorico.setDocAdjunto(adjunto);
        newHistorico.setUrgencia(urgencia);
        newHistorico.setRedAgua(redAgua);
        newHistorico.setTipoAviso(tipoAviso);
        newHistorico.setDuplicado(Boolean.FALSE);
        newHistorico.setEstado("Abierto");
                 
        //crear historicoPK
        HistoricoPK historicoPK =new HistoricoPK();
        historicoPK.setFechaActualizacion(new Date());
        historicoPK.setIdAviso(newAviso.getIdAviso());
        
        int tam = empleadoEJB.listaSupervisores().size();
        int rnd =(int) Math.floor(Math.random()*tam);
        Empleado sup = empleadoEJB.listaSupervisores().get(rnd); //elegimos el supervisor de forma aleatoria
        
        historicoPK.setSupervisor(sup.getIdEmpleado());
     
        newHistorico.setHistoricoPK(historicoPK);
        
        historicoEJB.crearHistorico(newHistorico); //persistir el historico          
        
        //reinicio valores
        nombre ="";
        telefono="";
        poliza="";
        email="";
        dni="";
        fecha="";
        origen="";
        descripcion="";
        direccion="";
        urgencia="";
        tipoAviso="";
        causa="";
        gps="";
        redAgua="";
        adjunto="";
        
        
        return "crearAvisosClient.xhtml";
    }
    
}
