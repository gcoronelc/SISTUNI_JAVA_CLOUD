/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.service;

import java.util.Map;
import pe.eeob.Demo04.dao.espec.DaoEstudianteEspec;
import pe.eeob.Demo04.dao.implement.DaoEstudianteImpl;

/**
 *
 * @author ErickOre
 */
public class EstudianteService {

    private DaoEstudianteEspec dao;
    
    public EstudianteService() {
        dao = new DaoEstudianteImpl();
    }
    
    public Map<String,Object> conEstudiantes(String dni, String apellido, String nombre) {
        return dao.consultaEstudiantes(dni, apellido, nombre);
    }
    
}
