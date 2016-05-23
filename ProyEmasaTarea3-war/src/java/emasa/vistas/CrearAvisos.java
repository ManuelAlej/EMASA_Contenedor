package emasa.vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import emasa.entidades.Aviso;
import emasa.entidades.Cliente;
import emasa.entidades.Datos;
import emasa.entidades.Historico;
import emasa.entidades.HistoricoPK;
import emasa.negocio.ClienteNegocio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;


/**
 *
 * @author Adrian
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
    private int idAviso = 0;
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
    @Inject 
    private Datos datos;
    private List<Cliente> clients;
    private List<Aviso> avisos;
    @EJB
    private ClienteNegocio clientEJB;

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
        
    }
    @PostConstruct
    public void init(){
        clients=datos.getClientes();
        avisos=datos.getAvisos();
        
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
        //crear 3 listas, una para ecliente, otra para aviso y otra para historico----< Lupi
        
        
        
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
        
        
        
        
        
        
        
        
        
       
      
        
        nuevoAviso=new Aviso();
        
        nuevoAviso.setDni(newClient);
        //aqui pongo el empleado
        nuevoAviso.setIdEmpleado(login.getUsr());
        //fecha
        Date date = new Date();
        nuevoAviso.setFechaEntrada(date);
        
        
        nuevoAviso.setIdAviso(idAviso);
        if(login.getCargoUsuario().equals("SAT")){
            nuevoAviso.setOrigen("SAT");
            
        }else if(login.getCargoUsuario().equals("OPmov")){
            nuevoAviso.setOrigen("OPmov");
        }else{
            nuevoAviso.setOrigen("Cliente");
        }
        
        
        historico=new Historico();
        historico.setCausa(causa);
        historico.setDescripcion(descripcion);
        historico.setDireccion(direccion);
        historico.setDocAdjunto(adjunto);
        historico.setDuplicado(false);
        historico.setEstado("Abierto");
        
        //historico pk
        HistoricoPK hpk=new HistoricoPK(idAviso,date,1); //este 1 es el supervisor asignado a este aviso
        
        historico.setHistoricoPK(hpk);
        
        historico.setRedAgua(redAgua);
        historico.setTipoAviso(tipoAviso);
        historico.setUbicacionGps("no hay ubicacion");
        historico.setUrgencia(urgencia);
        
        List h = new ArrayList();
        h.add(historico);
        
        nuevoAviso.setHistoricoCollection(h);
        
       // nuevoAviso.setFechaEntrada(fechaEntrada);
       // nuevoAviso.set...  aasi meto todos los datos
       avisos.add(nuevoAviso);
        
        idAviso++;
        
        
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
