package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pe.egcc.app.domain.Sucursal;
import pe.egcc.app.service.CuentaService;
import pe.egcc.app.service.SucursalService;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class MovimientosController {

  private List<Sucursal> sucursales;
  private List<String> cuentas;
  private String cuenta;
  private String sucursal;
  
  @PostConstruct
  private void initBean(){
    try {
      SucursalService sucursalService = new SucursalService();
      sucursales = sucursalService.getSucursalesConCuenta();
      cuentas = new ArrayList<String>();
    } catch (Exception e) {
    }
  }

  public List<Sucursal> getSucursales() {
    return sucursales;
  }

  public List<String> getCuentas() {
    return cuentas;
  }

  public void setSucursal(String sucursal) {
    this.sucursal = sucursal;
  }

  public String getSucursal() {
    return sucursal;
  }

  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  public String getCuenta() {
    return cuenta;
  }
  
  
  public void doCambiaSucursal(){
    try {
      CuentaService service = new CuentaService();
      cuentas = service.getSoloCuentas(sucursal);
    } catch (Exception e) {
    }
  }
  
  public void doProcesar(){
    
  }
  
}
