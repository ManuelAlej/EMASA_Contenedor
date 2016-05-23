package emasa.vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Adrian
 */
@Named(value = "QuienEntra")
@SessionScoped
public class QuienEntra implements Serializable {

    private static boolean entraComoCliente = false;
    private static boolean opmov=false;
    @Inject 
    private LoginBean login;

    public boolean isOpmov() {
        return opmov;
    }

    public void setOpmov(boolean opmov) {
        this.opmov = opmov;
    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }
    
    
   public String volver(){
       //si es Sat
       if(opmov==false){
           return "crearAvisosClient.xhtml";
       }
       //si es OPmov
       
       return "bandejaVisitasClient.xhtml";
   }
    public boolean isEntraComoCliente() {
        return entraComoCliente;
    }
    
    public String cliente(){
        opmov=false;
        entraComoCliente=true;
        return "crearAvisosClient.xhtml";
    }
    public static void sat(){
        opmov=false;
        entraComoCliente = false;  
        
    }
    
    public static String OPmov(){
        opmov=true;
        entraComoCliente=false;
        return "crearAvisosClient.xhtml";
    }

    public void setEntraComoCliente(boolean entraComoCliente) {
        this.entraComoCliente = entraComoCliente;
    }
    
    
    public QuienEntra() {
        
    }
    
    
}
