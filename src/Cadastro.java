/*_ O programa deve realizar o cadastro de um dev e uma linguagem.
        _ O programa deve ter um cabeçalho com o nome do programa.
        _ O programa deve exibir um menu com as opções cadastrar dev, cadastrar linguagem e sair.
        _ Deve ser utilizado a estrutura SWITCH-CASE para decidir sobre a opção escolhida pelo usuário.
        _ O cadastro de dev deve solicitar o nome, sobrenome, senioridade e idade.
        _ O nome e sobrenome devem conter no mínimo 3 caracteres.
        _ A idade deve ser maior que 0.
*/

import java.util.Scanner;

public class Cadastro {
    static Scanner sc = new Scanner(System.in);
    static String nomeAplicacao, nomeSenioridade;

    public static void main(String[] args) {

        imprimeCabecalho();
        exibeOpcoes("cadastro","Cadastrar dev","Cadastrar linguagem","Sair");
        lerOpcaoMenu("Digite uma opção: ");
    }

    static void imprimeCabecalho(){
        System.out.println("********** CADASTRO DE APLICAÇÕES **********");
        System.out.println("\nOlá! Seja bem vindo(a) ao cadastro de aplicações!\n");
    }

    static int lerNumero(String mensagem){
        int numero;

        do{
            System.out.print(mensagem);
            numero = Integer.parseInt(sc.nextLine());
        }while (!validaNumero(numero));

        return numero;
    }

    static String lerString(String mensagem){
        String cadeia;
        do{
            System.out.print(mensagem);
            cadeia = sc.nextLine();
        } while (!validaNome(cadeia));

        return cadeia;
    }

    static boolean escolheMenu(int opcao){
        boolean valida = true;

        switch (opcao){
            case 1:
                cadastrarDev();
                break;
            case 2:
                cadastrarLinguagem();
                break;
            case 3:
                System.out.println("Saindo... ");
                break;
            default:
                System.out.println("Opção inválida!");
                valida = false;
                break;
        }
        return valida;
    }

    static void cadastrarDev(){
        System.out.println("********** CADASTRO DE DESENVOLVEDOR **********");
        String nome = lerString("Digite o nome do DEV: ");
        String sobrenome = lerString("Digite o sobrenome do DEV: ");
        exibeOpcoes("Senioridade", "Junior","Pleno","Senior");
        String senioridade = lerOpcaoSenioridade("Digite a senioridade: ");
        int idade = lerNumero("Digite a idade: ");

        System.out.println("DESENVOLVEDOR CADASTRADO!");
        System.out.printf("\t == Usuario: %s \t == Sobrenome: %s \t == SENIORIDADE: %s \t == IDADE: %d",nome,sobrenome,senioridade,idade);

    }

    static void cadastrarLinguagem(){
        System.out.println("********** CADASTRO DE LINGUAGEM **********");
        String nome = lerString("Digite o nome da linguagem: ");
        String descricao = lerString("Digite a descrição da linguagem: ");
        exibeOpcoes("aplicação","Front-end", "Back-end", "Mobile");
        String aplicacao = lerOpcaoAplicacao("Digite a aplicação: ");

        System.out.println("LINGUAGEM CADASTRADA!");
        System.out.printf("\t == NOME: %s \t == DESCRICAO: %s \t == APLICACAO: %s",nome,descricao,aplicacao);

    }

    static void exibeOpcoes(String cadeia1, String cadeia2, String cadeia3, String cadeia4){
        System.out.println("Opções de " + cadeia1 + ": ");
        System.out.println("1 - " + cadeia2);
        System.out.println("2 - " + cadeia3);
        System.out.println("3 - " + cadeia4);
    }
    static void lerOpcaoMenu(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!escolheMenu(opcao));
    }

    static String lerOpcaoAplicacao(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!validaAplicacao(opcao));

        return nomeAplicacao;
    }

    static String lerOpcaoSenioridade(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!validaSenioridade(opcao));

        return nomeSenioridade;
    }

    static boolean validaNome(String nome) {
        boolean valida = true;

        if (nome.length() < 3) {
            System.out.println("A palavra deve conter no mínimo 3 caracteres, tente novamente!");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    static boolean validaNumero(int idade) {
        boolean valida = true;

        if (idade <= 0) {
            System.out.println("O valor dever ser maior que zero, tente novamente!");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    static boolean validaAplicacao(int aplicacao) {
        boolean valida = true;

        switch (aplicacao) {
            case 1:
                nomeAplicacao = "Front-end";
                break;
            case 2:
                nomeAplicacao = "Back-end";
                break;
            case 3:
                nomeAplicacao = "Mobile";
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                valida = false;
                break;
        }
        return valida;
    }

    static boolean validaSenioridade(int aplicacao) {
        boolean valida = true;

        switch (aplicacao) {
            case 1:
                nomeSenioridade = "Junior";
                break;
            case 2:
                nomeSenioridade = "Pleno";
                break;
            case 3:
                nomeSenioridade = "Senior";
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
                valida = false;
                break;
        }
        return valida;
    }
}
