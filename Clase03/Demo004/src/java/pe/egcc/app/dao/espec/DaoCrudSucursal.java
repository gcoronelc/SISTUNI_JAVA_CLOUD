package pe.egcc.app.dao.espec;

import java.util.List;
import pe.egcc.app.domain.Sucursal;

public interface DaoCrudSucursal extends DaoCrud<Sucursal> {

  
  List<Sucursal> getSucursalesConCuenta();
}
