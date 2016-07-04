/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.Demo04.dao.espec;

import java.util.Map;

/**
 *
 * @author ErickOre
 */
public interface DaoEstudianteEspec {
    Map<String,Object> consultaEstudiantes(String dni, String apellido, String nombre);
}
