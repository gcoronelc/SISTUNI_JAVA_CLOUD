package pe.egcc.app.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pe.egcc.app.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class CuentaController {

  private String cuenta;
  private double importe;

  public String getCuenta() {
    return cuenta;
  }

  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }
  
  public void doDeposito(){
    try {
      CuentaService service = new CuentaService();
      service.procDeposito(cuenta, importe, "0002");
      FacesMessage msg;
      msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
              "Proceso ok.", "Cuenta actualizada correctamente.");
      FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
      FacesMessage msg;
      msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  }
  
}
