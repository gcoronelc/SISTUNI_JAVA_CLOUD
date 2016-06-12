package pe.egcc.controller;

import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gustavo Coronel
 */
@ManagedBean
@RequestScoped
public class Pagina06Controller {

  private int n1;
  private int n2;
  private int n3;
  private int n4;
  private int n5;
  private int mayor;
  private int menor;

  public int getN1() {
    return n1;
  }

  public void setN1(int n1) {
    this.n1 = n1;
  }

  public int getN2() {
    return n2;
  }

  public void setN2(int n2) {
    this.n2 = n2;
  }

  public int getN3() {
    return n3;
  }

  public void setN3(int n3) {
    this.n3 = n3;
  }

  public int getN4() {
    return n4;
  }

  public void setN4(int n4) {
    this.n4 = n4;
  }

  public int getN5() {
    return n5;
  }

  public void setN5(int n5) {
    this.n5 = n5;
  }

  public int getMayor() {
    return mayor;
  }

  public void setMayor(int mayor) {
    this.mayor = mayor;
  }

  public int getMenor() {
    return menor;
  }

  public void setMenor(int menor) {
    this.menor = menor;
  }
  
  public void doProcesar(){
    int[] lista = {n1,n2,n3,n4,n5};
    Arrays.sort(lista);
    mayor = lista[4];
    menor = lista[0];
  }
  
 
  
}
