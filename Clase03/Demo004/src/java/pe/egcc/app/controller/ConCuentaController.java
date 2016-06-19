package pe.egcc.app.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
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
public class ConCuentaController {

  private String cuenta;
  private Map<String, Object> datos = null;
  private List<String> listaCuentas;

  @PostConstruct
  public void initBean(){
    try {
      CuentaService service = new CuentaService();
      listaCuentas = service.getSoloCuentas();
    } catch (Exception e) {
    }
  }

  public List<String> getListaCuentas() {
    return listaCuentas;
  }
  
  public String getCuenta() {
    return cuenta;
  }

  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  public Map<String, Object> getDatos() {
    return datos;
  }
  
  public void doProcesar(){
    try {
      CuentaService service = new CuentaService();
      datos = service.conCuenta(cuenta);
    } catch (Exception e) {
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
      "Error en el proceo.", e.getMessage());
      FacesContext.getCurrentInstance().addMessage(cuenta, msg);
    }
  }
  
}
