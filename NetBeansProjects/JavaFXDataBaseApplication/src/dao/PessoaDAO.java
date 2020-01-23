/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

/**
 *
 * @author alexandrebarao
 * 
 * DAO Class (Data Access Object)
 * 
 * 
 */
public class PessoaDAO {
    
    
    
    public static Pessoa procuraPessoa (int id) throws SQLException, ClassNotFoundException {
        
        String selectStmt = "SELECT * FROM PESSOA WHERE ID="+id+";";
 
        
        try {
            
            ResultSet rsEmp = DBUtil.dbExecutaQuery(selectStmt);
 
            
            Pessoa p = obtemPessoaDoResultSet(rsEmp);
 
         
            return p;
        } catch (SQLException e) {
            System.out.println("Durante a pesquisa do id " + id + " ocorreu o erro: " + e);
          
            throw e;
        }
    }
 
  
    private static Pessoa obtemPessoaDoResultSet(ResultSet rs) throws SQLException
    {
        Pessoa p = null;
        if (rs.next()) {
            p = new Pessoa();
            p.setId(rs.getInt("ID"));
            p.setNome(rs.getString("NOME"));
            p.setEmail(rs.getString("EMAIL"));
           
        }
        return p;
    }
 
    
    public static List<Pessoa> procuraPessoas () throws SQLException, ClassNotFoundException {
       
        String selectStmt = "SELECT * FROM PESSOA";
 
       
        try {
           
            ResultSet rsPessoas = DBUtil.dbExecutaQuery(selectStmt);
 
           
            List<Pessoa> pessoasList = getListaPessoas(rsPessoas);
 
           
            return pessoasList;
        } catch (SQLException e) {
            System.out.println("Operação SQL falhou: " + e);
            
            throw e;
        }
    }
 
  
    private static List<Pessoa> getListaPessoas(ResultSet rs) throws SQLException, ClassNotFoundException {
       
        // Lista observável para implementação de interface sincronizada a partir do mundo exterior...
        ObservableList<Pessoa> listaPessoas = FXCollections.observableArrayList();
 
        while (rs.next()) {
            Pessoa p = new Pessoa();
            p.setId(rs.getInt("ID"));
            p.setNome(rs.getString("NOME"));
            p.setEmail(rs.getString("EMAIL"));
            
            
            listaPessoas.add(p);
        }
        
        return listaPessoas;
    }
 
    
    public static void atualizaPessoa (int id, String nome, String email) throws SQLException, ClassNotFoundException {
        
        
        String updateStmt = "UPDATE PESSOA SET NOME = '"+ nome +"', EMAIL = '"+ email +"' WHERE ID = "+ id + ";";
           
        try {
            DBUtil.dbExecutaUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Erro durante o UPDATE: " + e);
            throw e;
        }
    }
 
    
    public static void apagaPessoaPorId (int id) throws SQLException, ClassNotFoundException {
       
        String updateStmt = "DELETE FROM PESSOA WHERE id ="+ id +";";
 
        
        try {
            DBUtil.dbExecutaUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Erro durante o DELETE: " + e);
            throw e;
        }
    }
 
    
    public static void inserePessoa (int id, String nome, String email) throws SQLException, ClassNotFoundException {
        
        String updateStmt = "INSERT INTO PESSOA (ID, NOME, EMAIL) VALUES (" + id +",'" + nome + "','"+ email + "');"; 
 
       
        try {
            DBUtil.dbExecutaUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Erro durante o INSERT: " + e);
            throw e;
        }
    }
}
    
    

