package pe.egcc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pe.egcc.dto.ValoresDto;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class Pagina02Controller {

  private List<ValoresDto> lista;
  private double num1;
  private double num2;
  private double suma;
  
  @PostConstruct
  public void initBean(){
    lista = new ArrayList<ValoresDto>();
    lista.add(new ValoresDto(30, 20));
    lista.add(new ValoresDto(25, 41));
    lista.add(new ValoresDto(79, 56));
    lista.add(new ValoresDto(23, 21));
  }

  public List<ValoresDto> getLista() {
    return lista;
  }

  public double getNum1() {
    return num1;
  }

  public double getNum2() {
    return num2;
  }

  public double getSuma() {
    return suma;
  }
  
  public String doSumar(double n1, double n2){
    num1 = n1;
    num2 = n2;
    suma = n1 + n2;
    return "pagina02Rpta";
  }
  
}
