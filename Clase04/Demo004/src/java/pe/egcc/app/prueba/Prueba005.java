package pe.egcc.app.prueba;

import java.util.List;
import java.util.Map;
import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.dao.impl.DaoCuentaImpl;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba005 {
  
  public static void main(String[] args) {
    DaoCuentaEspec dao = new DaoCuentaImpl();
    List<Map<String,?>> lista;
    lista = dao.conMovimientos("00100001");
    for (Map<String, ?> r : lista) {
      System.out.println(r.get("MOVINUMERO") + " | " 
              + r.get("TIPOACCION") + " | " 
              + r.get("MOVIIMPORTE"));
    }
  }
}
