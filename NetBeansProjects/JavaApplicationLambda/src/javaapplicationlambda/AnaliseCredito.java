/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationlambda;

/**
 *
 * @author alexandrebarao
 */
public class AnaliseCredito implements Filtro {

    @Override
    public boolean autorizaCredito(Conta c) {
       return c.getSaldo() > 1000;
       
    }
    
}
