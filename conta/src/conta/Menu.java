package conta;

import java.util.Scanner;

public class Menu {

    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println(YELLOW + "***************************************" + RESET);
            System.out.println(YELLOW + "                                       " + RESET);
            System.out.println(YELLOW + "        BANCO DO BRAZIL COM Z          " + RESET);
            System.out.println(YELLOW + "***************************************" + RESET);
            System.out.println(YELLOW + "     1- Criar Conta                    " + RESET);
            System.out.println(YELLOW + "     2- Listar todas as Contas         " + RESET);
            System.out.println(YELLOW + "     3- Buscar conta por Numero        " + RESET);
            System.out.println(YELLOW + "     4- Atualizar Dados da Conta       " + RESET);
            System.out.println(YELLOW + "     5- Apagar Conta                   " + RESET);
            System.out.println(YELLOW + "     6- Sacar                          " + RESET);
            System.out.println(YELLOW + "     7- Depositar                      " + RESET);
            System.out.println(YELLOW + "     8- Transferir valores entre Contas" + RESET);
            System.out.println(YELLOW + "     9- Sair                           " + RESET);
            System.out.println(YELLOW + "                                       " + RESET);
            System.out.println(YELLOW + "***************************************" + RESET);
            System.out.print(YELLOW + "Entre com a opção desejada:            \n" + RESET);
            System.out.println(YELLOW + "***************************************" + RESET);
            System.out.println(YELLOW + "                                       " + RESET);

            opcao = leia.nextInt();

            if (opcao == 9) {
                System.out.println(YELLOW + "\nBanco do Brazil com Z - O seu Futuro começa aqui!" + RESET);
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(YELLOW + "Criar Conta\n\n" + RESET);
                    break;
                case 2:
                    System.out.println(YELLOW + "Listar todas as Contas\n\n" + RESET);
                    break;
                case 3:
                    System.out.println(YELLOW + "Consultar dados da Conta - por número\n\n" + RESET);
                    break;
                case 4:
                    System.out.println(YELLOW + "Atualizar dados da Conta\n\n" + RESET);
                    break;
                case 5:
                    System.out.println(YELLOW + "Apagar a Conta\n\n" + RESET);
                    break;
                case 6:
                    System.out.println(YELLOW + "Saque\n\n" + RESET);
                    break;
                case 7:
                    System.out.println(YELLOW + "Depósito\n\n" + RESET);
                    break;
                case 8:
                    System.out.println(YELLOW + "Transferência entre Contas\n\n" + RESET);
                    break;
                default:
                    System.out.println(YELLOW + "\nOpção Inválida!\n" + RESET);
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println(BLUE + "\n*********************************************************" + RESET);
        System.out.println(BLUE + "Projeto Desenvolvido por: Luana Cardoso da Silva " + RESET);
        System.out.println(BLUE + "luanacardosos@outlook.com" + RESET);
        System.out.println(BLUE + "https://github.com/luacrds" + RESET);
        System.out.println(BLUE + "*********************************************************" + RESET);
    }
}

			
	
		

	


