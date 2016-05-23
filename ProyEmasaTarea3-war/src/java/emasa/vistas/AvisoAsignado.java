/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Cliente;
import emasa.entidades.Historico;
import emasa.entidades.Aviso;
import emasa.entidades.HistoricoPK;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author malex
 */
@Named(value = "avisoAsignado")
@SessionScoped
public class AvisoAsignado implements Serializable {

  
    public Historico getHis() {
        return his;
    }

    public void setHis(Historico his) {
        this.his = his;
    }
    private Historico his;

    public AvisoAsignado() {

    }

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

    public CalendarioVista getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioVista calendario) {
        this.calendario = calendario;
    }

    public Historico getHis_nuevo() {
        return his_nuevo;
    }

    public void setHis_nuevo(Historico his_nuevo) {
        this.his_nuevo = his_nuevo;
    }

    public ControlVisitas getCtrlvisita() {
        return ctrlvisita;
    }

    public void setCtrlvisita(ControlVisitas ctrlvisita) {
        this.ctrlvisita = ctrlvisita;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }
    private Aviso aviso;

    private Historico his_nuevo;
    @Inject
    private ControlVisitas ctrlvisita;

    public Integer getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Integer supervisor) {
        this.supervisor = supervisor;
    }
    
    private Integer supervisor;

    @PostConstruct
    public void init() {

        aviso =ctrlvisita.getVisitaSelected().getHistorico().getAviso();
        supervisor = ctrlvisita.getVisitaSelected().getHistorico().getHistoricoPK().getSupervisor();
        cliente = ctrlvisita.getVisitaSelected().getHistorico().getAviso().getDni();
        
        
        historicos=(List<Historico>) ctrlvisita.getVisitaSelected().getHistorico().getAviso().getHistoricoCollection();
        his = ctrlvisita.getVisitaSelected().getHistorico();
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

    }

    public String getHis_descripcion() {

        return his_descripcion;
    }

    public void setHis_descripcion(String his_descripcion) {

        this.his_descripcion = his_descripcion;
    }

    private String his_descripcion;

    public String B_avisoAsignado() {

        return "prueba.xhtml";
    }

   
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

        his_nuevo = new Historico(new HistoricoPK(aviso.getIdAviso(), new Date(), supervisor), his.getDescripcion(), his.getDireccion(), his.getEstado(), his.getDuplicado());

        his_nuevo.setCausa(his.getCausa());

        his_nuevo.setFechaCierre(calendario.getDate1());

        his_nuevo.setTipoAviso(his.getTipoAviso());

        his_nuevo.setUrgencia(his.getUrgencia());

        his_nuevo.setUbicacionGps(his.getUbicacionGps());

        his_nuevo.setRedAgua(his.getRedAgua());

        his_nuevo.setDocAdjunto(his.getDocAdjunto());

        historicos.add(his_nuevo);

        if (calendario.getDate1() == null) {
            his_nuevo.setFechaCierre(his.getFechaCierre());
        }

        his = getHistoricoReciente();
        //System.out.println(Arrays.toString(historicos.toArray()));

        //System.out.println(his);
        return "avisoAsignado.xhtml";

    }

}
