/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.CentroCusto;
import java.sql.SQLException;
import java.util.List;
import persistencia.PCentroCusto;

/**
 *
 * @author diogo
 */
public class NCentroCusto {
    PCentroCusto persistencia;
    
    public NCentroCusto(){
        persistencia = new PCentroCusto();
    }
    
    public void salvar(CentroCusto parametro) throws SQLException, Exception {
        if(parametro.getDescricao().isEmpty()) throw new Exception ("Informar a descrição do centro de custo");
   
        if(parametro.getId() == 0){
            persistencia.incluir(parametro);
        }else{
            persistencia.alterar(parametro);
        }
    }
    
    public void excluir(int parametro) throws SQLException{
        persistencia.excluir(parametro);
    }
    
    public CentroCusto consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
         
    }
    
    public List<CentroCusto>  listar() throws SQLException{        
        return persistencia.listar();
    }
    
}
