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
    public static void main(String[] args) {

        imprimeCabecalho();
        imprimeMenu();
        int opcao = lerNumero("Digite uma opção: ");

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
        Scanner sc = new Scanner(System.in);
        System.out.print(mensagem);
        int numero = Integer.parseInt(sc.nextLine());
        return numero;
    }
    static void escolheMenu(int opcao){
        switch (opcao){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

    }
    static void cadastraDev(){

    }

    static void cadastraDev(){

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

}
