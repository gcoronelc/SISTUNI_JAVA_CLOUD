
package pe.egcc.app.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pe.egcc.app.domain.Empleado;
import pe.egcc.app.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@SessionScoped
public class LogonController {

  private String usuario;
  private String clave;
  private Empleado empleado;

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

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }
  
  public String doLogon(){
    String destino;
    try {
      LogonService service = new LogonService();
      empleado = service.validar(usuario, clave);
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
