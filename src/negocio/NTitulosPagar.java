/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.TitulosPagar;
import java.sql.SQLException;
import java.util.List;
import persistencia.PTitulosPagar;

/**
 *
 * @author diogo
 */
public class NTitulosPagar {
    
     PTitulosPagar persistencia;
    
    public NTitulosPagar(){
        persistencia = new PTitulosPagar();
    }
    
    public void salvar(TitulosPagar parametro) throws SQLException, Exception{
        if(parametro.getFornecedor() == null) throw new Exception ("Informar o nome do fornecedor");
        if(parametro.getCentroCusto() == null) throw new Exception ("Informar o nome do centro de custo");        
        if(parametro.getValor()<=0.0) throw new Exception("Informar o valor");
        if(parametro.getDataVencimento()==null) throw new Exception("Informar a data de vencimento");
        
        if(parametro.getId() == 0){
            persistencia.incluir(parametro);
        }else{
            persistencia.alterar(parametro);
        }
        
    }
    public void excluir(int parametro) throws SQLException{
        persistencia.excluir(parametro);
    }
    
    public TitulosPagar consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
         
    }
    
    public List<TitulosPagar>  listar() throws SQLException{        
        return persistencia.listar();
    }
   
}
