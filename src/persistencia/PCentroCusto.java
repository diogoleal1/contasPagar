/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.CentroCusto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diogo
 */
public class PCentroCusto {

    public void incluir(CentroCusto parametro) throws SQLException {

        String sql = " INSERT INTO "
                + " centro_custo (descricao, status ) "
                + " VALUES (?,?) ";

        Connection conexao = util.Conexao.getConexao();

        PreparedStatement prd = conexao.prepareStatement(sql);

        prd.setString(1, parametro.getDescricao());
        prd.setInt(2, parametro.getStatus());

        prd.execute();
        conexao.close();
    }

    public void alterar(CentroCusto parametro) throws SQLException {

        String sql = " UPDATE centro_custo "
                + " SET descricao = ?, status = ? "
                + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();

        PreparedStatement prd = conexao.prepareStatement(sql);

        prd.setString(1, parametro.getDescricao());
        prd.setInt(2, parametro.getStatus());
        prd.setInt(3, parametro.getId());
        prd.execute();
        conexao.close();

    }

    public void excluir(int parametro) throws SQLException {
        try {

            //verificar se o fornecedor possui título
            PTitulosPagar ptp = new PTitulosPagar();
            boolean fTitulo = ptp.ccTitulo(parametro);
            if (fTitulo) {
                throw new Exception("Centro de Custo com título vinculado \nNão é possível excluir apenas desativar!");
            }
            
            /////////////////////////////////////////

            String sql = " DELETE FROM centro_custo "
                    + " WHERE id = ?;";

            Connection conexao = util.Conexao.getConexao();
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setInt(1, parametro);
            prd.execute();
            conexao.close();

            JOptionPane.showMessageDialog(null, "Exclusão efetuado com Sucesso");
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public CentroCusto consultar(int parametro) throws SQLException {

        String sql = " SELECT id, descricao, status FROM centro_custo"
                + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        CentroCusto retorno = new CentroCusto();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setDescricao(rs.getString("descricao"));
            retorno.setStatus(rs.getInt("status"));

        }
        return retorno;
    }

    public List<CentroCusto> listar() throws SQLException {

        String sql = "SELECT * FROM centro_custo ORDER BY id";

        Connection conexao = util.Conexao.getConexao();
        Statement st = conexao.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<CentroCusto> retorno = new ArrayList<CentroCusto>();

        while (rs.next()) {
            CentroCusto cc = new CentroCusto();

            cc.setId(rs.getInt("id"));
            cc.setDescricao(rs.getString("descricao"));
            cc.setStatus(rs.getInt("status"));

            retorno.add(cc);
        }

        return retorno;
    }

}
