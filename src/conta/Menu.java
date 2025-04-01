package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;

        ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
        cc1.visualizar();
        cc1.sacar(12000.0f);
        cc1.visualizar();
        cc1.depositar(5000.0f);
        cc1.visualizar();

        ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
        cp1.visualizar();
        cp1.sacar(1000.0f);
        cp1.visualizar();
        cp1.depositar(5000.0f);
        cp1.visualizar();

        while (true) {
            System.out.println(Cores.YELLOW + "***************************************" + Cores.RESET);
            System.out.println(Cores.YELLOW + "                                       " + Cores.RESET);
            System.out.println(Cores.YELLOW + "        BANCO DO BRAZIL COM Z          " + Cores.RESET);
            System.out.println(Cores.YELLOW + "***************************************" + Cores.RESET);
            System.out.println(Cores.YELLOW + "     1- Criar Conta                    " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     2- Listar todas as Contas         " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     3- Buscar conta por Numero        " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     4- Atualizar Dados da Conta       " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     5- Apagar Conta                   " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     6- Sacar                          " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     7- Depositar                      " + Cores.RESET);
            System.out.println(Cores.YELLOW + "     8- Transferir valores entre Contas" + Cores.RESET);
            System.out.println(Cores.YELLOW + "     9- Sair                           " + Cores.RESET);
            System.out.println(Cores.YELLOW + "                                       " + Cores.RESET);
            System.out.println(Cores.YELLOW + "***************************************" + Cores.RESET);
            System.out.print(Cores.YELLOW + "Entre com a opção desejada:            \n" + Cores.RESET);
            System.out.println(Cores.YELLOW + "***************************************" + Cores.RESET);
            System.out.println(Cores.YELLOW + "                                       " + Cores.RESET);

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 9) {
                System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n Criar Conta");
                    keyPress();
                    break;
                case 2:
                    System.out.println("\n Listar todas as Contas");
                    keyPress();
                    break;
                case 3:
                    System.out.println("\n Buscar Conta por número");
                    keyPress();
                    break;
                case 4:
                    System.out.println("\n Atualizar dados da Conta");
                    keyPress();
                    break;
                case 5:
                    System.out.println("\n Apagar Conta");
                    keyPress();
                    break;
                case 6:
                    System.out.println("\n Sacar");
                    keyPress();
                    break;
                case 7:
                    System.out.println("\n Depositar");
                    keyPress();
                    break;
                case 8:
                    System.out.println("\n Transferir");
                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção Inválida" + Cores.RESET);
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por:Luana Cardoso da Silva");
        System.out.println(" luanacardosos@outlook.com");
        System.out.println("github.com/luacrds");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}

class Cores {
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
}
