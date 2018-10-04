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
        String sql = " INSERT INTO "
                   + " pessoa (nome, cpf, endereco, telefone, email, ie, ativo) "
                   + " VALUES (?,?,?,?,?,?,0) ";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getCpf_Cnpj());
        prd.setString(3, parametro.getEndereco());
        prd.setString(4, parametro.getTelefone());
        prd.setString(5, parametro.getEmail());
        prd.setString(6, parametro.getIe());
        
        prd.execute();
        cnn.close();
    }
    
    public void alterar(Fornecedor parametro) throws SQLException {
        
        String sql = " UPDATE pessoa "
                   + " SET nome = ?, cpf = ?, endereco = ?, id_tipoassociado = ? "
                   + " WHERE identificador = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setString(1, parametro.getNome());
        ps.setString(2, parametro.getEndereco());
        ps.setString(3, parametro.getTelefone());
        ps.setInt(4, parametro.getTipoAssociado().getIdentificador());
        ps.setInt(5, parametro.getIdentificador());

        ps.execute();
        cnn.close();

    }

}
