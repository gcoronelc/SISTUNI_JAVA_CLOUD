package pe.egcc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import pe.egcc.dto.ProductoDto;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class Pagina05Controller {

  private List<ProductoDto> lista;
  private String opcion;
  private String copia;
  
  @PostConstruct
  public void initBean(){
    lista = new ArrayList<ProductoDto>();
    lista.add(new ProductoDto("A001", "Coca Cola",5.0,100));
    lista.add(new ProductoDto("A002", "Inka Cola",4.5,200));
    lista.add(new ProductoDto("A003", "Triple Cola",3.5,1000));
    lista.add(new ProductoDto("A004", "Cristal Cola",10.0,10000));
    lista.add(new ProductoDto("A005", "Pilsen Cola",15.0,15000));
  }

  public List<ProductoDto> getLista() {
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
