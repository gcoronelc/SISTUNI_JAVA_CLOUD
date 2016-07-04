/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pe.eeob.service.ImcService;

/**
 *
 * @author ErickOre
 */
@ManagedBean
@RequestScoped
public class ImcController {
    private double peso;
    private double talla;
    private double imc;
    private boolean formulario = true;

    public boolean isFormulario(){
        return formulario;
    }    
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
    
    public void doProcesar(){
        ImcService service = new ImcService();
        imc = service.calcular(peso, talla);
        formulario = false;
    }
    
    public void doRetornar(){
        formulario = true;
    }
}
