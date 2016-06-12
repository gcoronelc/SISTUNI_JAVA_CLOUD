package pe.egcc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class Pagina04Controller {

  private List<SelectItem> lista;
  private String opcion;
  private String copia;
  
  @PostConstruct
  public void initBean(){
    lista = new ArrayList<SelectItem>();
    lista.add(new SelectItem("A001", "Coca Cola"));
    lista.add(new SelectItem("A002", "Inka Cola"));
    lista.add(new SelectItem("A003", "Triple Cola"));
    lista.add(new SelectItem("A004", "Cristal Cola"));
    lista.add(new SelectItem("A005", "Pilsen Cola"));
  }

  public List<SelectItem> getLista() {
    return lista;
  }
  
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
