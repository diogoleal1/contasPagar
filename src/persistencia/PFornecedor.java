/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diogo
 */
public class PFornecedor {
    
    public void incluir(Fornecedor parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " fornecedor (nome, cpf, endereco, telefone, email, ie, ativo) "
                + " VALUES (?,?,?,?,?,?,0)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());
        
        prd.execute();
        cnn.close();
    }

}
