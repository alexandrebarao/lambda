/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author alexandrebarao
 */
public class Pessoa {
    private int id;
    private String nome;
    private String email;

    public Pessoa (int id, String nome, String email) { 
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Pessoa() {
      
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String informacao() {
        String info = "ID:"+id+ " Nome:" + nome + " Email:" + email;
        return info;
    }
    
}