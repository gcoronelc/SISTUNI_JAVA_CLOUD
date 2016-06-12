package pe.egcc.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class Pagina03Controller {

  private String opcion;
  private String copia;
  

  public String getOpcion() {
    return opcion;
  }

  public void setOpcion(String opcion) {
    this.opcion = opcion;
  }

  public String getCopia() {
    return copia;
  }
  
  public  void doProcesar(){
    copia = opcion;
  }
  
}
