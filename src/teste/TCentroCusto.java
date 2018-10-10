/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.CentroCusto;
import java.util.List;
import java.util.Scanner;
import negocio.NCentroCusto;

/**
 *
 * @author diogo
 */
public class TCentroCusto {
      public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Operações: \n 1 - Incluir | 2 - Alterar | 3 - Excluir | 4 - Consultar | 5 - Listar \n Informe a operação desejada->  ");

        int opcao = entrada.nextInt();

        while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5) {
            System.out.println("Operações: \n 1 - Incluir | 2 - Alterar | 3 - Excluir | 4 - Consultar | 5 - Listar \n Informe uma opção válida->  ");
            opcao = entrada.nextInt();
        }

        CentroCusto cc = new CentroCusto();
        NCentroCusto na = new NCentroCusto();
        try {
            if (opcao == 1) {
                System.out.println("Informe a descricao-> ");
                cc.setDescricao(entrada.next());
                na.salvar(cc);
                
            } else if (opcao == 2) {
                System.out.println("Informe o centro de custo-> ");
                cc.setId(entrada.nextInt());
                System.out.println("Informe a descricao-> ");
                cc.setDescricao(entrada.next());
                System.out.println("Informe o Status-> ");
                cc.setStatus(entrada.nextInt());
                na.salvar(cc);
                
            } else if (opcao == 3) {
                System.out.println("Informe o centro de custo que será excluído-> ");
                na.excluir(entrada.nextInt());
                
            } else if (opcao == 4) {
                CentroCusto centroCusto = new CentroCusto();
                System.out.println("Informe o código do associado que será consultado -> ");
                centroCusto = na.consultar(entrada.nextInt());
                System.out.println("Código            -> " + centroCusto.getId()
                                   + "\nDescricao     -> " + centroCusto.getDescricao()
                                   + "\nStatus        -> " + centroCusto.getStatus());                     

            } else if (opcao == 5) {

                List<CentroCusto> listaCentroCusto = na.listar();

                for (int i = 0; i < listaCentroCusto.size(); i++) {
                    System.out.println("Código            -> " + listaCentroCusto.get(i).getId()
                                       + "\nDescricao     -> " + listaCentroCusto.get(i).getDescricao()
                                       + "\nStatus        -> " + listaCentroCusto.get(i).getStatus());         
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
}
