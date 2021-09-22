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

    //método que imprime um cabeçalho
    static void imprimeCabecalho(){
        System.out.println("********** CADASTRO DE APLICAÇÕES **********");
        System.out.println("\nOlá! Seja bem vindo(a) ao cadastro de aplicações!\n");
    }

    //método que lê um número
    static int lerNumero(String mensagem){
        int numero;

        do{
            System.out.print(mensagem);
            numero = Integer.parseInt(sc.nextLine());
        }while (!validaNumero(numero));

        return numero;
    }

    //método que lê uma string
    static String lerString(String mensagem){
        String cadeia;
        do{
            System.out.print(mensagem);
            cadeia = sc.nextLine();
        } while (!validaNome(cadeia));

        return cadeia;
    }

    //método que recebe a opção do menu e executa a opção, caso ela seja válida
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

    //método que cadastra um(a) desenvolvedor(a)
    static void cadastrarDev(){
        System.out.println("********** CADASTRO DE DESENVOLVEDOR(A) **********");
        String nome = lerString("Digite o nome do(a) DEV: ");
        String sobrenome = lerString("Digite o sobrenome do(a) DEV: ");
        exibeOpcoes("Senioridade", "Junior","Pleno","Senior");
        String senioridade = lerOpcaoSenioridade("Digite a senioridade: ");
        int idade = lerNumero("Digite a idade: ");

        System.out.println("DESENVOLVEDOR(A) CADASTRADO!");
        System.out.printf("\t == Usuario: %s \t == Sobrenome: %s \t == SENIORIDADE: %s \t == IDADE: %d",nome,sobrenome,senioridade,idade);

    }

    //método que cadastra uma linguagem de programação
    static void cadastrarLinguagem(){
        System.out.println("********** CADASTRO DE LINGUAGEM **********");
        String nome = lerString("Digite o nome da linguagem: ");
        String descricao = lerString("Digite a descrição da linguagem: ");
        exibeOpcoes("aplicação","Front-end", "Back-end", "Mobile");
        String aplicacao = lerOpcaoAplicacao("Digite a aplicação: ");

        System.out.println("LINGUAGEM CADASTRADA!");
        System.out.printf("\t == NOME: %s \t == DESCRICAO: %s \t == APLICACAO: %s",nome,descricao,aplicacao);

    }

    //método que exibe um menu de opções
    static void exibeOpcoes(String cadeia1, String cadeia2, String cadeia3, String cadeia4){
        System.out.println("Opções de " + cadeia1 + ": ");
        System.out.println("1 - " + cadeia2);
        System.out.println("2 - " + cadeia3);
        System.out.println("3 - " + cadeia4);
    }

    //método que lê a opção do menu e a executa, caso seja uma opção valida
    static void lerOpcaoMenu(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!escolheMenu(opcao));
    }

    //método que lê a aplicação, valida e retorna seu valor
    static String lerOpcaoAplicacao(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!validaAplicacao(opcao));

        return nomeAplicacao;
    }

    //método que lê a senioridade, valida e retorna seu valor
    static String lerOpcaoSenioridade(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!validaSenioridade(opcao));

        return nomeSenioridade;
    }

    //metodo que valida se a string tem mais que 3 caracteres
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

    //método que valida o número informado pelo usuário (não permite valores negativos)
    static boolean validaNumero(int numero) {
        boolean valida = true;

        if (numero <= 0) {
            System.out.println("O valor dever ser maior que zero, tente novamente!");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    //método que valida a opção informada pelo usuário e atribui o nome da aplicação
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

    //método que valida a opção informada pelo usuário e atribui o nome da senioridade
    static boolean validaSenioridade(int senioridade) {
        boolean valida = true;

        switch (senioridade) {
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
