/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.Fornecedor;
import java.util.List;
import java.util.Scanner;
import negocio.NFornecedor;
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

        Fornecedor f = new Fornecedor();
        NFornecedor na = new NFornecedor();
        try {
            if (opcao == 1) {

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

                na.salvar(f);
            } else if (opcao == 2) {
                System.out.println("Informe o codigo-> ");
                f.setId(entrada.nextInt());
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
                System.out.println("Informe o boolean-> ");
                f.setAtivo(entrada.nextInt());

                na.salvar(f);
            } else if (opcao == 3) {
                System.out.println("Informe o codigo que será excluído-> ");
                na.excluir(entrada.nextInt());
            } else if (opcao == 4) {
                Fornecedor fornece = new Fornecedor();
                System.out.println("Informe o código do associado que será consultado -> ");
                fornece = na.consultar(entrada.nextInt());
                System.out.println("Código            -> " + fornece.getId()
                        + "\nNome           -> " + fornece.getNome()
                        + "\nEndereço       -> " + fornece.getEndereco()
                        + "\nTelefone       -> " + fornece.getTelefone()
                        + "\nEmail          -> " + fornece.getEmail()
                        + "\nIe             -> " + fornece.getIe()
                        + "\nDataCadastro   -> " + fornece.getDataCadastro()
                        + "\nAtivo          -> " + fornece.getAtivo());

            } else if (opcao == 5) {

                List<Fornecedor> listaFornecedor = na.listar();

                for (int i = 0; i < listaFornecedor.size(); i++) {
                    System.out.println("Código            -> " + listaFornecedor.get(i).getId()
                                       + "\nNome           -> " + listaFornecedor.get(i).getNome()
                                       + "\nEndereço       -> " + listaFornecedor.get(i).getEndereco()
                                       + "\nTelefone       -> " + listaFornecedor.get(i).getTelefone()
                                       + "\nEmail          -> " + listaFornecedor.get(i).getEmail()
                                       + "\nIe             -> " + listaFornecedor.get(i).getIe()
                                       + "\nDataCadastro   -> " + listaFornecedor.get(i).getDataCadastro()
                                       + "\nAtivo          -> " + listaFornecedor.get(i).getAtivo());
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
}
