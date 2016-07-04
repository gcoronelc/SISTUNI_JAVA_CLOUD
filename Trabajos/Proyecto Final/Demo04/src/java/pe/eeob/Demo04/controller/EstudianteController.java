/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.controller;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pe.eeob.Demo04.service.EstudianteService;

/**
 *
 * @author ErickOre
 */
@ManagedBean
@RequestScoped
public class EstudianteController {

    private String dni;
    private String apellido;
    private String nombre;
    private Map<String, Object> datos = null;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, Object> getDatos() {
        return datos;
    }

    public void doProcesar(){
      try {
        EstudianteService service = new EstudianteService();
        datos = service.conEstudiantes(dni, apellido, nombre);
      } catch (Exception e) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
        "Error en el proceo.", e.getMessage());
        FacesContext.getCurrentInstance().addMessage(dni , msg);
      }
    }
}
