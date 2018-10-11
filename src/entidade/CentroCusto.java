/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author diogo
 */
public class CentroCusto {
    private int id;
    private String descricao;
    private int status;
    
    public CentroCusto(){}
    
    public CentroCusto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;  
    }
    
    @Override
    public String toString(){
        return this.descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

      
    
}
