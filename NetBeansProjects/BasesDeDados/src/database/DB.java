/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entidades.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alexandrebarao
 */
public class DB {

    Connection con;

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/basedados", "root", "root");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void estabelecerConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/basedados", "root", "root");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void fecharConexao() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList obterTodosRegistosPessoa() {

        ArrayList lista = new ArrayList();

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from PESSOA");
            while (rs.next()) {

                Pessoa p = new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;

    }

    public void inserePessoa(Pessoa p) {

        try {

            String query = " INSERT INTO PESSOA (ID, NOME, EMAIL) VALUES (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, p.getId());
            preparedStmt.setString(2, p.getNome());
            preparedStmt.setString(3, p.getEmail());

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
