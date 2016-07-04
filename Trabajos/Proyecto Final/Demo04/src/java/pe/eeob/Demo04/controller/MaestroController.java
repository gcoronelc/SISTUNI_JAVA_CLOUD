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
import pe.eeob.Demo04.service.MaestroService;

/**
 *
 * @author ErickOre
 */
@ManagedBean
@SessionScoped
public class MaestroController {
    private String usuario;
    private String clave;
    private Maestro maestro;   
    private boolean formulario = true;

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

    public boolean isFormulario() {
        return formulario;
    }

    public String verificaClave(){
      String destino;
        try {
          LogOnService service = new LogOnService();
        maestro = service.validar(usuario, clave);
        destino = "cambioClave1";
      } catch (Exception e) {
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Clave errada. Por favor, vuelva a intentarlo.", e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        destino = "cambioClave";
      }
      return destino;
    }
    
    public void cambiarClave(){
        try {          
            MaestroService service = new MaestroService();
            service.cambiarClave(usuario, clave);         
        } catch (Exception e) {
            FacesMessage msg;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error en el proceso. Por favor, vuelva a intentarlo.", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        formulario = false;
    }
}