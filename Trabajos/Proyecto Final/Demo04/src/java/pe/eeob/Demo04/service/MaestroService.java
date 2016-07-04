/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.service;

import pe.eeob.Demo04.dao.espec.DaoMaestroEspec;
import pe.eeob.Demo04.dao.implement.DaoMaestroImpl;

/**
 *
 * @author ErickOre
 */
public class MaestroService {
    DaoMaestroEspec dao;
    
    public MaestroService() {
        dao = new DaoMaestroImpl();
    }
    
    public void cambiarClave(String usuario, String clave){
        dao.cambiarClave(usuario, clave);
    }
}
