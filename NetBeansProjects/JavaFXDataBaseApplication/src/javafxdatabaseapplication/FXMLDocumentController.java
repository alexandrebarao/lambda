/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdatabaseapplication;

import Entidades.Pessoa;
import dao.PessoaDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author alexandrebarao
 * 
 * Consultar outro exemplo completo em: 
 * 
 * https://www.swtestacademy.com/database-operations-javafx/ 
 * 
 * (Interface com tabela sincronizada...) 
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    boolean modoInsercao;
    
    @FXML
    private Button botaoProcurar;
    
    
    @FXML
    private Button botaoAtualizar;
    
    @FXML
    private Button botaoApagar;
    
    @FXML
    private Button botaoLimpar;
    
    @FXML
    private Button botaoVerTodos;
    
    
    @FXML
    private TextField textoId;
    
    @FXML
    private TextField textoNome;
    
    @FXML
    private TextField textoEmail;
    
    @FXML
    private TextArea textAreaPessoas;
    
    
    @FXML
    private void handleBotaoProcurar(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        if ( textoId.getText().trim().equals("")) {
        
            mensagemInformacao("Procurar", "Preencha o ID", "O ID deve ser numérico...");
             
        } else {     
            try {
                //Get Employee information
                Pessoa p = PessoaDAO.procuraPessoa(Integer.parseInt(textoId.getText()));
                //Populate Employee on TableView and Display on TextArea

                if ( p != null ) {
                    popularInterface(p);
                    modoInsercao = false;
                    botaoApagar.setVisible(true);
                } else {
                    
                    mensagemInformacao("Procurar", "Registo inexistente", "Tente outro ID");
                    
                }
            } catch (SQLException e) {

                modoInsercao = false;
                limparCampos();
                mensagemInformacao("Procurar", "Problema...", "Razão: " + e);
                
                throw e;
            }


            botaoApagar.setVisible(true);
        }
    }
    
    @FXML
    private void handleBotaoNovo(ActionEvent event) {
        limparCampos();
               
        botaoApagar.setVisible(false);
        modoInsercao = true;
       
    }
    
   
    
    @FXML
    private void handleBotaoAtualizar(ActionEvent event) throws SQLException, ClassNotFoundException {
        
         if ( textoId.getText().trim().equals("")) {
        
              mensagemInformacao("Atualizar", "Preencha o ID", "Só é possível atualizar com dados preenchidos...");
            
        } else {    
        
                    try {

                        if ( modoInsercao ) {
                                PessoaDAO.inserePessoa(Integer.parseInt(textoId.getText()), textoNome.getText(), textoEmail.getText());
                                mensagemInformacao("Inserir registo", "Modo de inserção", "Registo inserido na base dados");
                                modoInsercao = false;
                                botaoApagar.setVisible(true);
                        } else {
                                PessoaDAO.atualizaPessoa(Integer.parseInt(textoId.getText()), textoNome.getText(), textoEmail.getText());
                                mensagemInformacao("Alterar registo", "Modo de alteração", "Registo alterado na base dados");
                                
                               
                        }

                    } catch (SQLException e) {
                        
                        mensagemInformacao("Atualizar", "Problema...", "Razão: " + e);
                        
                        throw e;
                    }
        
        
         }
       
    }
    
    
    @FXML
    private void handleBotaoApagar(ActionEvent event) throws ClassNotFoundException, SQLException {
      try {
            PessoaDAO.apagaPessoaPorId(Integer.parseInt(textoId.getText()));
            
            mensagemInformacao("Apagar", "Apagar Pessoa", "A pessoa foi removida da base de dados");
           
            limparCampos();
            modoInsercao = true;
            botaoApagar.setVisible(false);
            
        } catch (SQLException e) {
           
            throw e;
        }
    }
    
    @FXML
    private void handleBotaoVerTodos(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        try {
            
            textAreaPessoas.clear();
            
            List lista = PessoaDAO.procuraPessoas();
            String texto = "";
            for (int i = 0; i < lista.size(); i++ ) { 
                Pessoa p = (Pessoa) lista.get(i);
                texto = texto  + p.informacao()+ "\n";
               
            }
            textAreaPessoas.setText(texto);
            
            
        } catch (SQLException e) {
           
            throw e;
        }
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        limparCampos();
        modoInsercao=true;
        botaoApagar.setVisible(false);
        
        
    }   
    
    private void limparCampos() { 
        textoId.setText("");
        textoNome.setText("");
        textoEmail.setText("");
        
        
       
    }
    
    
    private void popularInterface(Pessoa p ) {
    
            textoId.setText(String.valueOf(p.getId()));
            textoNome.setText(p.getNome());
            textoEmail.setText(p.getEmail());
            
    }
    
    private void mensagemInformacao(String titulo, String cabecalho, String texto) {
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle(titulo);
            alert.setHeaderText(cabecalho);
            alert.setContentText(texto);
            alert.show();
    }
    
}
