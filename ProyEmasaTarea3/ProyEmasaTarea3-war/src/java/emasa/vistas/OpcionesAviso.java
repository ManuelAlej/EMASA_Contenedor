/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Aviso;
import javax.inject.Named;
import emasa.entidades.Cliente;
import emasa.entidades.Historico;
import emasa.entidades.HistoricoPK;
import emasa.negocio.AvisoNegocio;
import emasa.negocio.HistoricoNegocio;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "opcionesAviso")
@ViewScoped
public class OpcionesAviso implements Serializable {
    
    @EJB
    private AvisoNegocio avisoNegocio;
    
     @EJB
    private HistoricoNegocio historicoNegocio;
     
     


    @Inject
    private ControlAvisos datos;

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int idSupervisor) {
        supervisor = idSupervisor;
    }
    private int supervisor;

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }
    private Aviso aviso;
    private String fechaEntrada;
    private String ultimoHist;

    public String getUltimoHist() {
        Date fechLast = his.getHistoricoPK().getFechaActualizacion();
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
        ultimoHist = dmyFormat.format(fechLast);
        return ultimoHist;
    }

    public void setUltimoHist(String ultimoHist) {
        this.ultimoHist = ultimoHist;
    }

    public String getFechaEntrada() {
        Date fech = new Date();
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
        String mdy = dmyFormat.format(fech);
        return mdy;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Historico getHis() {
        return his;
    }

    public void setHis(Historico his) {
        this.his = his;
    }
    private Historico his;

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
    private List<Historico> historicos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private Cliente cliente;

    @Inject
    private CalendarioVista calendario;
    
    
    public ControlAvisos getDatos() {
        return datos;
    }

    public void setDatos(ControlAvisos datos) {
        this.datos = datos;
    }



    public Historico getHis_nuevo() {
        return his_nuevo;
    }

    public void setHis_nuevo(Historico his_nuevo) {
        this.his_nuevo = his_nuevo;
    }
  

    public CalendarioVista getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioVista calendario) {
        this.calendario = calendario;
    }

    private Historico his_nuevo;

    @PostConstruct
    public void init() {
       aviso =(Aviso)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("avisoSelected");
        /**************************************************************
         * ***************************************************
         * ************
         */
     
       // Integer a= Integer.parseInt(ultimoHist)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAv");

       // System.out.println("//////////**************"+a);
        
        supervisor = datos.getHistorico(aviso).getHistoricoPK().getSupervisor();
             
        cliente = aviso.getDni();
        historicos=(List<Historico>) aviso.getHistoricoCollection();
        his =datos.getHistorico(aviso);
        
           FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("Historico", his); 
        System.out.println("*****************"+his);
           
        if (his.getDescripcion() == null) {
            his.setDescripcion("Vacio");
        }
        if (his.getDireccion() == null) {
            his.setDireccion("Vacio");
        }
        if (his.getEstado() == null) {
            his.setEstado("Vacio");
        }

        if (his.getDescripcion() == null) {
            his.setDescripcion("Vacio");
        }
        if (his.getDireccion() == null) {
            his.setDireccion("Vacio");
        }

        if (his.getTipoAviso() == null) {
            his.setTipoAviso("vacio");
        }

        if (his.getCausa() == null) {
            his.setCausa("vacio");
        }

        if (his.getUbicacionGps() == null) {
            his.setUbicacionGps("vacio");
        }

        if (his.getRedAgua() == null) {
            his.setRedAgua("vacio");
        }
        if (his.getDocAdjunto() == null) {
            his.setDocAdjunto("vacio");
        }

        if (his.getUrgencia() == null) {
            his.setUrgencia("vacio");
        }
        
        if (his.getDuplicado() == null) {
            his.setDuplicado(false);
        }

        his_nuevo = new Historico(new HistoricoPK(aviso.getIdAviso(), new Date(), supervisor), his.getDescripcion(), his.getDireccion(), his.getEstado(), his.getDuplicado());
        his_nuevo.setCausa(his.getCausa());

        his_nuevo.setFechaCierre(null);

        his_nuevo.setTipoAviso(his.getTipoAviso());

        his_nuevo.setUrgencia(his.getUrgencia());

        his_nuevo.setUbicacionGps(his.getUbicacionGps());

        his_nuevo.setRedAgua(his.getRedAgua());

        his_nuevo.setDocAdjunto(his.getDocAdjunto());

      

    }

    public String getHis_descripcion() {

        return his_descripcion;
    }

    public void setHis_descripcion(String his_descripcion) {

        this.his_descripcion = his_descripcion;
    }

    private String his_descripcion;

  

    public Historico getHistoricoReciente() {
        Historico reciente;

        reciente = historicos.get(0);

        Date fecha = reciente.getHistoricoPK().getFechaActualizacion();

        for (Historico h : historicos) {

            if (h.getHistoricoPK().getFechaActualizacion().after(fecha)) {
                reciente = h;
                fecha = h.getHistoricoPK().getFechaActualizacion();
            }
        }

        return reciente;
    }

    public String modificarAviso() {
        //id_aviso,fecha_entrada,supervisor_asignado,descripcion,direccion,estado,duplicado,fechacierre,tipodeaviso,urgencia,ubicacion_gps,red_agua

        his.setFechaCierre(new Date());
        historicoNegocio.actualizarHistorico(his);
        his = getHistoricoReciente();
        
        aviso.getHistoricoCollection().add(his_nuevo);
       
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("avisoSelected", aviso);
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+ FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("avisoSelected"));
       
        historicoNegocio.persist(his_nuevo);

        return "bandejaAvisosClient.xhtml";

    }

    public String getRelacionado() {

        if (aviso.getRelacionado() == null) {
            return "No está relacionado con ningún aviso ";
        } else {
            return aviso.getRelacionado().getIdAviso().toString();
        }

    }
    private String relacionado;

    
    public void setRelacionado(String relacionado) {
        this.relacionado = relacionado;
    }
    public void guardarId(Integer ida){
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("id", ida);
    }

}
