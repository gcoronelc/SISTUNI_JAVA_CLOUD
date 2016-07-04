/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.service;

import pe.eeob.Demo04.dao.espec.DaoMaestroEspec;
import pe.eeob.Demo04.dao.implement.DaoMaestroImpl;
import pe.eeob.Demo04.domain.Maestro;

/**
 *
 * @author ErickOre
 */
public class LogOnService {
    public Maestro validar(String usuario, String clave){
        Maestro bean;
        if( !esCorrecto(usuario) || !esCorrecto(clave)){
          throw new RuntimeException("Datos son incorrectos.");
        }        
        DaoMaestroEspec dao = new DaoMaestroImpl();
        bean = dao.validar(usuario, clave);
        if(bean == null){
          throw new RuntimeException("Datos son incorrectos.");
        }        
        return bean;
    }

  private boolean esCorrecto(String valor) {
    boolean rpta = false;
    if( valor != null && !valor.isEmpty()){
      rpta = true;
    }
    return rpta;
  }    
}
