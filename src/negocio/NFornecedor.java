/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Fornecedor;
import java.sql.SQLException;
import java.util.List;
import persistencia.PFornecedor;

/**
 *
 * @author diogo
 */
public class NFornecedor {
    
    PFornecedor persistencia;
    
    public NFornecedor(){
        persistencia = new PFornecedor();
    }
    
    public void salvar(Fornecedor parametro) throws SQLException, Exception {
        if(parametro.getNome().isEmpty()) throw new Exception ("Informar o nome do fornecedor");
        if(parametro.getCpf_Cnpj().isEmpty()) throw new Exception("Informar o cpf");
        if(parametro.getEndereco().isEmpty()) throw new Exception("Informar o endereco");
        if(parametro.getTelefone().isEmpty()) throw new Exception("Informar o telefone");
        if(parametro.getEmail().isEmpty()) throw new Exception("Informar o email");
                
        if(parametro.getId() == 0){
            persistencia.incluir(parametro);
        }else{
            persistencia.alterar(parametro);
        }
    }
    
    public void excluir(int parametro) throws SQLException{
        persistencia.excluir(parametro);
    }
    
    public Fornecedor consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
         
    }
    
    public List<Fornecedor>  listar() throws SQLException{        
        return persistencia.listar();
    }
    
}
