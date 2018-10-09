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

        String sql = " INSERT INTO "
                + " pessoa (nome, cpf, endereco, telefone, email, ie, ativo, dataCadastro ) "
                + " VALUES (?,?,?,?,?,?,1,CURRENT_DATE) ";

        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

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
                + " SET nome = ?, cpf = ?, endereco = ?, telefone = ?, email = ?, ie = ?, ativo = ? "
                + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();

        PreparedStatement prd = conexao.prepareStatement(sql);

        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getCpf_Cnpj());
        prd.setString(3, parametro.getEndereco());
        prd.setString(4, parametro.getTelefone());
        prd.setString(5, parametro.getEmail());
        prd.setString(6, parametro.getIe());
        prd.setInt(7, parametro.getAtivo());
        prd.setInt(8, parametro.getId());
        prd.execute();
        conexao.close();

    }

    public void excluir(int parametro) throws SQLException {

        String sql = " DELETE FROM pessoa "
                    + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        conexao.close();
    }

    public Fornecedor consultar(int parametro) throws SQLException {

        String sql = " SELECT id, nome, cpf, endereco, telefone, email, ativo, ie, datacadastro FROM pessoa "
                + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Fornecedor retorno = new Fornecedor();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            retorno.setCpf_Cnpj(rs.getString("cpf"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
            retorno.setAtivo(rs.getInt("ativo"));
            retorno.setIe(rs.getString("ie"));
            retorno.setDataCadastro(rs.getDate("datacadastro"));
        }
        return retorno;
    }

    public List<Fornecedor> listar() throws SQLException {

        String sql = "SELECT * FROM pessoa";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<Fornecedor> retorno = new ArrayList<Fornecedor>();

        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setId(rs.getInt("id"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setCpf_Cnpj(rs.getString("cpf"));
            fornecedor.setEndereco(rs.getString("endereco"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setAtivo(rs.getInt("ativo"));
            fornecedor.setIe(rs.getString("ie"));
            fornecedor.setDataCadastro(rs.getDate("datacadastro"));

            retorno.add(fornecedor);
        }

        return retorno;
    }

}
