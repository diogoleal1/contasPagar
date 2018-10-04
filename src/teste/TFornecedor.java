/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.Fornecedor;
import java.util.Scanner;
import persistencia.PFornecedor;

/**
 *
 * @author diogo
 */
public class TFornecedor {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Operações: \n 1 - Incluir | 2 - Alterar | 3 - Excluir | 4 - Consultar | 5 - Listar \n Informe a operação desejada->  ");

        int opcao = entrada.nextInt();

        while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5) {
            System.out.println("Operações: \n 1 - Incluir | 2 - Alterar | 3 - Excluir | 4 - Consultar | 5 - Listar \n Informe uma opção válida->  ");
            opcao = entrada.nextInt();
        }

        if (opcao == 1) {
            try {

                Fornecedor f = new Fornecedor();
                PFornecedor na = new PFornecedor();

                //nome, cpf, endereco, telefone, email, ie, ativo
                System.out.println("Informe o nome-> ");
                f.setNome(entrada.next());
                System.out.println("Informe o cpf-> ");
                f.setCpf_Cnpj(entrada.next());
                System.out.println("Informe o endereco-> ");
                f.setEndereco(entrada.next());
                System.out.println("Informe o telefone-> ");
                f.setTelefone(entrada.next());
                System.out.println("Informe o email-> ");
                f.setEmail(entrada.next());
                System.out.println("Informe o ie-> ");
                f.setIe(entrada.next());
                
                na.incluir(f);

            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }

    }
    
    }
}
