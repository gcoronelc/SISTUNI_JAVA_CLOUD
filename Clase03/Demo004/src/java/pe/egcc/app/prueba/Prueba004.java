package pe.egcc.app.prueba;

import java.util.List;
import java.util.Map;

import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.dao.impl.DaoCuentaImpl;

public class Prueba004 {
  
  public static void main(String[] args) {
    DaoCuentaEspec dao = new DaoCuentaImpl();
    List<String> lista = dao.getSoloCuentas();
    for(String cuenta: lista){
      System.out.println(cuenta);
    }
  }

}
