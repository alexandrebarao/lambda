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
public class Conta {
    
    private double saldo;
    private String titular;
    
    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        saldo = saldoInicial;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }
    
    public String toString() {
        
        return String.format("%s %.2f€", titular, saldo);
    }

    
}
