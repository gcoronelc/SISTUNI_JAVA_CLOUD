package pe.egcc.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.app.dao.espec.DaoCrudSucursal;
import pe.egcc.app.dao.espec.MapperResultSet;
import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.domain.Sucursal;

/**
 *
 * @author Gustavo Coronel
 */
public class DaoSucursalImpl implements DaoCrudSucursal, MapperResultSet<Sucursal>{

  @Override
  public List<Sucursal> getSucursalesConCuenta() {
    List<Sucursal> lista = new ArrayList<Sucursal>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_sucucodigo, vch_sucunombre, "
              + "vch_sucuciudad, vch_sucudireccion, int_sucucontcuenta "
              + "from sucursal where chr_sucucodigo in "
              + "(select distinct chr_sucucodigo from cuenta)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Sucursal bean = mapper(rs);
        lista.add(bean);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String msg = "Error en el acceso a la BD.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        msg += " " + e.getMessage();
      }
      throw new RuntimeException(msg);
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
    return lista;
  }

  @Override
  public void insertar(Sucursal bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void actualizar(Sucursal bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminar(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Sucursal obtener(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Sucursal> obtener() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Sucursal> obtener(Sucursal bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * Crear un objeto de tipo Sucursal con los
   * datos de la fila actual del ResultSet.
   * 
   * @param rs
   * @return
   * @throws SQLException 
   */
  @Override
  public Sucursal mapper(ResultSet rs) throws SQLException {
    Sucursal bean = new Sucursal();
    bean.setCodigo(rs.getString("CHR_SUCUCODIGO"));
    bean.setNombre(rs.getString("VCH_SUCUNOMBRE"));
    bean.setCiudad(rs.getString("VCH_SUCUCIUDAD"));
    bean.setDireccion(rs.getString("VCH_SUCUDIRECCION"));
    bean.setContcuenta(rs.getInt("INT_SUCUCONTCUENTA"));
    return bean;
  }
      
}
