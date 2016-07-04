/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.eeob.Demo04.dao.espec.DaoMaestroEspec;
import pe.eeob.Demo04.db.AccesoDB;
import pe.eeob.Demo04.domain.Maestro;


public class DaoMaestroImpl implements DaoMaestroEspec {

    @Override
    public Maestro validar(String usuario, String clave) {
        Maestro maestro = null;
        Connection cn = null;  
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          String sql = "select chr_maesdni, vch_maespaterno, vch_maesmaterno, vch_maesnombre, "
                  + "vch_maesdistrito, vch_maestelefono, vch_maeseducacion, vch_maesusuario, "
                  + "vch_comentariocoord, vch_escucodigo "
                  + "from Maestro "
                  + "where vch_maesusuario = ? and vch_maesclave = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                maestro = getBean(rs);
            }
            rs.close();
            pstm.close();    
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
          } catch (Exception e) {
            String mensaje = "Se ha producido un error, intentelo mas tarde.";
            if (e.getMessage() != null && !e.getMessage().isEmpty()) {
              mensaje += (" " + e.getMessage());
            }
            throw new RuntimeException(mensaje);
          } finally {
            try {
              cn.close();
            } catch (Exception e) {
            }
          }
        
        return maestro;
    }

    public Maestro getBean(ResultSet rs) throws SQLException {
        Maestro bean = new Maestro();
        bean.setDni(rs.getString("chr_maesdni"));
        bean.setPaterno(rs.getString("vch_maespaterno"));
        bean.setMaterno(rs.getString("vch_maesmaterno"));
        bean.setNombre(rs.getString("vch_maesnombre"));
        bean.setDistrito(rs.getString("vch_maesdistrito"));
        bean.setTelefono(rs.getString("vch_maestelefono"));
        bean.setEducacion(rs.getString("vch_maeseducacion"));
        bean.setUsuario(rs.getString("vch_maesusuario"));
        bean.setComentcoor(rs.getString("vch_comentariocoord"));
        bean.setEscuela_codigo(rs.getString("vch_escucodigo"));
        return bean;
    }

    @Override
    public Maestro readForId(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Maestro> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Maestro> readForCriteria(Maestro bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Maestro bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Maestro bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarClave(String usuario, String clave) {
        Connection cn = null;
        try {
          // Acceso al objeto Connection
          cn = AccesoDB.getConnection();
          // Inicia TX
          cn.setAutoCommit(false);
          String sql = "UPDATE Maestro SET "
                  + "vch_maesclave = ? "
                  + "WHERE vch_maesusuario = ? ";
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setString(1, clave);
          pstm.setString(2, usuario);
          pstm.executeUpdate();
          pstm.close();
          //Confirma TX
          cn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                  // Cancela Tx
                  cn.rollback();
            } catch (Exception e1) {
            }
            String mensaje = "Error en el Proceso, intentelo mas tarde.";
            if(e.getMessage() != null && !e.getMessage().isEmpty()){
                  mensaje += " " + e.getMessage();
            }
            throw new RuntimeException(mensaje);
        } finally {
          try {
                cn.close();
          } catch (Exception e) {
          }
        }          
    }
}
