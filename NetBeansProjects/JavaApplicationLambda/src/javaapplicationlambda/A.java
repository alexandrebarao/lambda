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
public class A {
    private int n; 
    public A(int n) {
            this.n = n;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof A))return false;
        A a = (A)obj;
    
        return  getN() == a.getN();
       
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.getN();
        return hash;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
    
    
}
