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
public class Fornecedor extends Pessoa{
    
    public Fornecedor(){
        
    }
  
    public Fornecedor(int id, String nome) {
        this.id = id;
        this.nome = nome;  
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
