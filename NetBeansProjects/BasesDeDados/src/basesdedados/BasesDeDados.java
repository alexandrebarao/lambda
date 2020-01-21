/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basesdedados;

import database.DB;
import entidades.Pessoa;
import java.util.ArrayList;




/**
 *
 * @author alexandrebarao
 */
public class BasesDeDados {

   
    public static void main(String[] args) {
       
     
      // Demonstração ... 
      
      DB db = new DB(); 
      db.estabelecerConexao();
      
      ArrayList lista = db.obterTodosRegistosPessoa();
      
      for ( int i = 0; i < lista.size(); i++ ) { 
          Pessoa p = (Pessoa) lista.get(i);
          System.out.println(p.getId() + " " + p.getNome() + " " + p.getEmail() );
      }
        
      db.inserePessoa(new Pessoa(3, "Raquel", "r@raquel.br"));
      db.inserePessoa(new Pessoa(4, "Guilherme", "g@guilherme.br"));
      db.inserePessoa(new Pessoa(5, "Ana", "a@ana.pt"));
      db.inserePessoa(new Pessoa(6, "Ricardo", "r@ricardo.br"));
      db.inserePessoa(new Pessoa(7, "Inês", "r@ricardo.br"));
      db.inserePessoa(new Pessoa(8, "Claudio", "c@claudio.pt"));
      db.inserePessoa(new Pessoa(9, "Filipe", "f@filipe.pt"));
      
      Pessoa p = new Pessoa();
      p.setId(10);
      p.setNome("Warley");
      p.setEmail("w@warley.pt");
      
      db.inserePessoa(p);
      
      lista = db.obterTodosRegistosPessoa();
      
      for ( int i = 0; i < lista.size(); i++ ) { 
          p = (Pessoa) lista.get(i);
          System.out.println(p.getId() + " " + p.getNome() + " " + p.getEmail() );
      }
      
      
      
      db.fecharConexao();
      
      
      
      
      
    }
    
}
