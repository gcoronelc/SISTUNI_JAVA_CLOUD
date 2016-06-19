package pe.egcc.app.service;

import java.util.List;
import pe.egcc.app.dao.espec.DaoCrudSucursal;
import pe.egcc.app.dao.impl.DaoSucursalImpl;
import pe.egcc.app.domain.Sucursal;

/**
 *
 * @author Gustavo Coronel
 */
public class SucursalService {
  
  private DaoCrudSucursal daoSucursal;

  public SucursalService() {
    daoSucursal = new DaoSucursalImpl();
  }
  
  public List<Sucursal> getSucursalesConCuenta(){
    return daoSucursal.getSucursalesConCuenta();
  }
  
}
