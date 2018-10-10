/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import entidade.TitulosPagar;
import java.util.List;
import java.util.Scanner;
import negocio.NFornecedor;
import negocio.NTitulosPagar;

/**
 *
 * @author diogo
 */
public class TTitulosPagar {
    public static void main(String[] args) {
     
        Scanner entrada = new Scanner(System.in);
        System.out.println("Operações: \n 1 - Incluir | 2 - Alterar | 3 - Excluir | 4 - Consultar | 5 - Listar \n Informe a operação desejada->  ");

        int opcao = entrada.nextInt();

        while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5) {
            System.out.println("Operações: \n 1 - Incluir | 2 - Alterar | 3 - Excluir | 4 - Consultar | 5 - Listar \n Informe uma opção válida->  ");
            opcao = entrada.nextInt();
        }

        TitulosPagar tp = new TitulosPagar();
        NTitulosPagar ntp = new NTitulosPagar();
      
     

    }    
}
