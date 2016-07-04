/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pe.eeob.Demo04.domain.Maestro;
import pe.eeob.Demo04.service.LogOnService;

/**
 *
 * @author ErickOre
 */
@ManagedBean
@SessionScoped
public class LogonController {

    private String usuario;
    private String clave;
    private Maestro maestro;        
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }
    
    public String doLogon(){
      String destino;
        try {
          LogOnService service = new LogOnService();
        maestro = service.validar(usuario, clave);
        destino = "main";
      } catch (Exception e) {
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error en el proceso.", e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        destino = "index";
      }
      return destino;
    }      
        
}
