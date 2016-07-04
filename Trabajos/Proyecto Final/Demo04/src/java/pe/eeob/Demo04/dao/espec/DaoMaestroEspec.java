/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.dao.espec;
import pe.eeob.Demo04.domain.Maestro;

/**
 *
 * @author ErickOre
 */
public interface DaoMaestroEspec extends DaoCrudEspec<Maestro>{
    
    Maestro validar(String usuario, String clave);
    void cambiarClave(String usuario, String clave);
    
}
