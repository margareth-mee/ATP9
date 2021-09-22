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
    static String nomeAplicacao;

    public static void main(String[] args) {

        imprimeCabecalho();
        imprimeMenu();
        int opcao = lerNumero("Digite uma opção: ");
        escolheMenu(opcao);
    }
    static void imprimeMensagem(String mensagem){
        System.out.println(mensagem);
    }
    static void imprimeCabecalho(){
        System.out.println("********** CADASTRO DE APLICAÇÕES **********");
        System.out.println("\nOlá! Seja bem vindo(a) ao cadastro de aplicações!\n");
    }
    static void imprimeMenu(){
        System.out.println("Opções disponíveis: ");
        System.out.println("1 - Cadastrar dev");
        System.out.println("2 - Cadastrar linguagem");
        System.out.println("3 - Sair");
    }
    static int lerNumero(String mensagem){
        int numero;

        do {
            System.out.print(mensagem);
            numero = Integer.parseInt(sc.nextLine());
        } while (!validaNumero(numero));

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

    static void escolheMenu(int opcao){
        switch (opcao){
            case 1:
                cadastrarDev();
                break;
            case 2:
                cadastrarLinguagem();
                break;
            case 3:

                break;
            default:
                break;
        }

    }
    static void cadastrarDev(){
        imprimeMensagem("********** CADASTRO DE DESENVOLVEDOR **********");
        String nome = lerString("Digite o nome do DEV: ");
        String sobrenome = lerString("Digite o sobrenome do DEV: ");
        String senioridade = lerString("Digite a senioridade: ");
        int idade = lerNumero("Digite a idade: ");
    }

    static void cadastrarLinguagem(){
        imprimeMensagem("********** CADASTRO DE LINGUAGEM **********");
        String nome = lerString("Digite o nome da linguagem: ");
        String descricao = lerString("Digite a descrição da linguagem: ");

        exibeOpcoes("aplicação","Front-end", "Back-end", "Mobile");
        int aplicacao = lerOpcao("Digite a aplicação: ");

    }
    static void exibeOpcoes(String cadeia1, String cadeia2, String cadeia3, String cadeia4){
        System.out.println("Opções de " + cadeia1 + ": ");
        System.out.println("1 - " + cadeia2);
        System.out.println("2 - " + cadeia3);
        System.out.println("3 - " + cadeia4);
    }
    static int lerOpcao(String mensagem){
        int opcao;
        do{
            opcao = lerNumero(mensagem);
        } while(!validaAplicacao(opcao));
        return opcao;
    }

    public static boolean validaNome(String nome) {
        boolean valida = true;

        if (nome.length() < 3) {
            System.out.println("A palavra deve conter no mínimo 3 caracteres, tente novamente!");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public static boolean validaNumero(int idade) {
        boolean valida = true;

        if (idade <= 0) {
            System.out.println("O valor dever ser maior que zero, tente novamente!");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }
    public static boolean validaAplicacao(int aplicacao) {
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

}
