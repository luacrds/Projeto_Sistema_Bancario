package conta;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao, numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite, valor;
        ContaController contas  = new ContaController();
        
        System.out.println("\nCriar Conta\n");
        
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.cadastrar(cc1);
        
        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.cadastrar(cc2);
        
        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 124, 1, "Mariana dos Santos", 4000f, 12);
        contas.cadastrar(cp1);
        
        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 124, 1, "Mariana dos Santos", 4000f, 12);
        contas.cadastrar(cp2);
        
        contas.listarTodas();
        
        
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
                    System.out.println("Digite o número da agência: ");
                    agencia = leia.nextInt();
                    System.out.println("Digite o nome do titular: ");
                    leia.skip("\\R?");
                    titular = leia.nextLine();
                    
                    do {
                    	System.out.println("Digite o tipo da conta (1-CC ou 2-CP)");
                    	tipo = leia.nextInt();
                    }while(tipo < 1 && tipo > 2);
                    
                    System.out.println("Digite o saldo da conta (R$)");
                    saldo = leia.nextFloat();
                    
                    switch(tipo) {
                    case 1 -> {
                    	System.out.println("Digite o limite de crédito (R$):");
                    	limite = leia.nextFloat();
                    	contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia,tipo, titular, saldo, limite ));
                    	
                     }
                    case 2 ->{
                    	System.out.println("Digite o dia do aniversário da conta:");
                    	aniversario = leia.nextInt();
                    	contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
                    }
                    }
                    
                    keyPress();
                    break;
                case 2:
                    System.out.println(YELLOW + "Listar todas as Contas\n\n" + RESET);
                    contas.listarTodas();
                    keyPress();
				
                    break;
                case 3:
                    System.out.println(YELLOW + "Consultar dados da Conta - por número\n\n" + RESET);
                    
                    System.out.println("Digite o número da Conta: ");
                    numero = leia.nextInt();

                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;
                case 4:
                    System.out.println(YELLOW + "Atualizar dados da Conta\n\n" + RESET);
                    System.out.println("Digite o número da conta: ");
                    numero =  leia.nextInt();
		
				var buscaConta= contas.buscarNaCollection(numero);
                    
                    if(buscaConta != null) {
                    	tipo = ((Conta) buscaConta).getTipo();
                    	
                    	System.out.println("Digite o Numero da Agência: ");
                    	agencia= leia.nextInt();
                    	System.out.println("Digite o Nome do Titular: ");
                    	leia.skip("\\R?");
                    	titular= leia.nextLine();
                    	
                    	System.out.println("Digite o Saldo da Conta (R$): ");
                    	saldo= leia.nextFloat();
                    	switch (tipo) {
                    	case 1 -> {
                    	System.out.println("Digite o Limite de Crédito (R$): ");
                    	limite= leia.nextFloat();
                    	contas.atualizar(new ContaCorrente (numero, agencia, tipo, titular, saldo, limite));
                    }
                    	case 2 -> {
                            System.out.println("Digite o dia do Aniversário da Conta: ");
                            aniversario = leia.nextInt();
                            contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo,
                                    aniversario));
                        }
                        default -> {
                            System.out.println( "\nOpção Inválida!\n" );
                        }
                    }

                } else {
                    System.out.println( "\nConta não encontrada!\n" );
                }
                    
                    keyPress();
                    break;
                case 5:
                    System.out.println(YELLOW + "Apagar a Conta\n\n" + RESET);
                    System.out.println("Digite o número da Conta: ");
                    numero = leia.nextInt();

                    contas.deletar(numero);
                    
                    keyPress();
                    break;
                case 6:
                    System.out.println(YELLOW + "Saque\n\n" + RESET);
                    
                    System.out.println("Digite o Numero da conta: ");
                    numero = leia.nextInt();

                    do {
                        System.out.println("Digite o Valor do Saque (R$): ");
                        valor = leia.nextFloat();
                    } while (valor <= 0);

                    contas.sacar(numero, valor);
                   
                    keyPress();
                    break;
                case 7:
                    System.out.println(YELLOW + "Depósito\n\n" + RESET);
                    
                    System.out.println("Digite o Numero da conta: ");
                    numero = leia.nextInt();

                    do {
                        System.out.println("Digite o Valor do Depósito (R$): ");
                        valor = leia.nextFloat();
                    } while (valor <= 0);

                    contas.depositar(numero, valor);
                    
                    keyPress();
                    break;
                case 8:
                    System.out.println(YELLOW + "Transferência entre Contas\n\n" + RESET);
                    
                    System.out.println("Digite o Numero da conta: ");
                    numero = leia.nextInt();

                    do {
                        System.out.println("Digite o Valor do Depósito (R$): ");
                        valor = leia.nextFloat();
                    } while (valor <= 0);

                    contas.depositar(numero, valor);
                   
                    keyPress();
                    break;
                default:
                    System.out.println(YELLOW + "\nOpção Inválida!\n" + RESET);
                    
                    keyPress();
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
    
    public static void keyPress() {
    	try {
    		System.out.println(RESET + "\n\nPressione Enter para Continuar...");
        System.in.read();
        }catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    	
    }
    
}


			
	
		

	


