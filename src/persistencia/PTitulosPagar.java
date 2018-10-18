/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.CentroCusto;
import entidade.TitulosPagar;
import java.sql.Connection;
import java.sql.Date;
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
public class PTitulosPagar {

    public void incluir(TitulosPagar parametro) throws SQLException {
        String sql = " INSERT INTO "
                + " titulo(id_fornecedor, id_centrocusto, valor, juros,"
                + " desconto, dt_vencimento, dt_cadastro, situacao) "
                + " VALUES(?,?,?,?,?,to_date(?,'dd/mm/yyyy'),current_date,'A') ";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setInt(1, parametro.getFornecedor().getId());
        ps.setInt(2, parametro.getCentroCusto().getId());
        ps.setDouble(3, parametro.getValor());
        ps.setDouble(4, parametro.getJuros());
        ps.setDouble(5, parametro.getDesconto());
        ps.setString(6, parametro.getDataVencimento());

        ps.execute();
        cnn.close();

    }

    public void alterar(TitulosPagar parametro) throws SQLException {
        String sql = " UPDATE titulo  "
                + " SET id_fornecedor = ?,  id_centrocusto = ?, valor = ?, juros = ?, "
                + " desconto = ?, dt_vencimento = to_date(?,'dd/mm/yyyy'), situacao = ? "
                + " WHERE ID = ? ";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setInt(1, parametro.getFornecedor().getId());
        ps.setInt(2, parametro.getFornecedor().getId());
        ps.setDouble(3, parametro.getValor());
        ps.setDouble(4, parametro.getJuros());
        ps.setDouble(5, parametro.getDesconto());
        ps.setString(7, parametro.getDataVencimento());
        ps.setString(8, parametro.getSituacao());
        ps.setInt(9, parametro.getId());

        ps.execute();
        cnn.close();

    }

    public void excluir(int parametro) throws SQLException {

        String sql = " DELETE FROM titulo "
                + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        conexao.close();
    }

    public TitulosPagar consultar(int parametro) throws SQLException {

        String sql = " SELECT id, id_fornecedor, id_centrocusto, valor, juros, desconto, dt_cadastro, dt_vencimento, situacao FROM titulo "
                + " WHERE id = ?;";

        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        TitulosPagar retorno = new TitulosPagar();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setFornecedor(new PFornecedor().consultar(rs.getInt("id_fornecedor")));
            retorno.setCentroCusto(new PCentroCusto().consultar(rs.getInt("id_centrocusto")));
            retorno.setValor(rs.getDouble("valor"));
            retorno.setJuros(rs.getDouble("juros"));
            retorno.setDesconto(rs.getDouble("desconto"));
            retorno.setDataCadastro(rs.getString("dt_cadastro"));
            retorno.setDataVencimento(rs.getString("dt_vencimento"));
            retorno.setSituacao(rs.getString("situacao"));
        }
        return retorno;
    }

    public List<TitulosPagar> listar() throws SQLException {

        String sql = "SELECT * FROM titulo";

        Connection conexao = util.Conexao.getConexao();
        Statement st = conexao.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<TitulosPagar> retorno = new ArrayList<TitulosPagar>();

        while (rs.next()) {
            TitulosPagar titulo = new TitulosPagar();

            titulo.setId(rs.getInt("id"));
            titulo.setFornecedor(new PFornecedor().consultar(rs.getInt("id_fornecedor")));
            titulo.setCentroCusto(new PCentroCusto().consultar(rs.getInt("id_centrocusto")));
            titulo.setValor(rs.getDouble("valor"));
            titulo.setJuros(rs.getDouble("juros"));
            titulo.setDesconto(rs.getDouble("desconto"));
            titulo.setDataCadastro(rs.getString("dt_cadastro"));
            titulo.setDataVencimento(rs.getString("dt_vencimento"));
            titulo.setSituacao(rs.getString("situacao"));

            retorno.add(titulo);
        }

        return retorno;
    }

    public boolean fornecedorTitulo(int parametro) throws SQLException {
        String sql = " select id_fornecedor from titulo "
                     + "where id_fornecedor = ? ";      
        
        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);
        
        ResultSet rs = prd.executeQuery();
      
        List<TitulosPagar> retorno = new ArrayList<TitulosPagar>();

        while (rs.next()) {
            TitulosPagar titulo = new TitulosPagar();
            titulo.setId(rs.getInt("id_fornecedor"));          
            retorno.add(titulo);
        }
        
        if(retorno.size() > 0){
            return true;
        }

        return false;
    }
    
    public boolean ccTitulo(int parametro) throws SQLException {
        String sql = " select id_centrocusto from titulo "
                     + "where id_centrocusto = ? ";      
        
        Connection conexao = util.Conexao.getConexao();
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);
        
        ResultSet rs = prd.executeQuery();
      
        List<TitulosPagar> retorno = new ArrayList<TitulosPagar>();

        while (rs.next()) {
            TitulosPagar titulo = new TitulosPagar();
            titulo.setId(rs.getInt("id_centrocusto"));          
            retorno.add(titulo);
        }        
        if(retorno.size() > 0){
            return true;
        }
        return false;
    }

}
