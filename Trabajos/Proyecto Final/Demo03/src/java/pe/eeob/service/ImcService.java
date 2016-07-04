/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.service;

/**
 *
 * @author ErickOre
 */
public class ImcService {
    public double calcular(double peso, double talla){
        double imc;
        imc = peso / (talla * talla);
        return imc ;
    }
}
