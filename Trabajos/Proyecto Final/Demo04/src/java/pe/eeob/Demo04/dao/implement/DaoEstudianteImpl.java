/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import pe.eeob.Demo04.dao.espec.DaoEstudianteEspec;
import pe.eeob.Demo04.db.AccesoDB;

/**
 *
 * @author ErickOre
 */
public class DaoEstudianteImpl implements DaoEstudianteEspec{

    @Override
    public Map<String,Object> consultaEstudiantes(String dni, String apellido, String nombre) {
    Map<String, Object> rec = null;
    Connection cn = null;
    try {
          cn = AccesoDB.getConnection();
          String sql = "select chr_estudni, vch_estupaterno, vch_estumaterno, vch_estunombre, "
                  + "dtt_estunacimiento, vch_estudistrito, vch_comentariomaes, vch_comentarioapo, "
                  + "chr_encuentro, chr_apodni "
                  + "from Estudiante "
                  + "where chr_estudni like ? and vch_estupaterno like ? and vch_estunombre like ?";
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setString(1, dni + "%");
          pstm.setString(2, apellido + "%");
          pstm.setString(3, nombre + "%");
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        rec = JdbcUtil.rsToMap(rs);
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
    return rec;
  
  }
  
}
