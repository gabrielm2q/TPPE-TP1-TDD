//package app;
//import java.util.ArrayList;
//import java.util.Scanner;
//	// Tipos clientes:
//    // 	1. padr�o
//    //  2. especial - fazem compras mensais acima de 100 reais
//    // 	3. prime - pagam uma mensalidade de 20 reais
//    
//    // Benef�cios
//    // 1. clientes especiais tem como benef�cio 10% de desconto no valor total de compra
//    // 	1.1. podem receber mais 10% no valor total de compra de desconto caso esteja utilizando cart�o de cr�dito da empresa (4296 13XX XXXX XXXX)
//    // 	1.2. ainda ganham os mesmos benef�cios e mais 30% de desconto no valor do frete
//    // 2. clientes prime frete gratis
//    // 	2.1 cashback 0,03 miserios por real gasto (mas se for no cartao da loja, aumenta muito pra 5 cents)
//    //	2.2 cashback pode ser utilizado como desconto em compra
//    
//    // Impostos
//
////	public static void main(String[] args) {
////		System.out.println("Hello World!");
////	}
//	public class Start {
//	    private static Loja loja = new Loja();
//	    private static Scanner scanner = new Scanner(System.in);
//
//	    public static void main(String[] args) {
//	    	inicializarCliente();
//	    	inicializarProdutos();
//	        exibirMenu();
//	    }
//
//	    public static void exibirMenu() {
//	        int opcao;
//	        do {
//	            System.out.println("\nMenu Principal");
//	            System.out.println("1. Cadastrar Cliente");
//	            System.out.println("2. Listar Clientes");
//	            System.out.println("3. Cadastrar Produtos");
//	            System.out.println("4. Listar Produtos");
//	            System.out.println("5. Realizar Venda");
//	            System.out.println("6. Sair");
//	            System.out.print("Escolha uma opção: ");
//	            opcao = scanner.nextInt();
//
//	            switch (opcao) {
//	                case 1:
//	                    cadastrarCliente();
//	                    break;
//	                case 2:
//	                    listarClientes();
//	                    break;
//	                case 3:
//	                    cadastrarProduto();
//	                    break;
//	                case 4:
//	                	listarProdutos();
//	                    break;
//	                case 5:
//	                    cadastrarVenda();
//	                    break;
//	                case 6:
//	                    System.out.println("Saindo...");
//	                    break;
//	                default:
//	                    System.out.println("Opção inválida. Tente novamente.");
//	            }
//	        } while (opcao != 6);
//	    }
//
//	    private static void cadastrarCliente() {
//	        System.out.print("ID: ");
//	        int id = scanner.nextInt();
//	        scanner.nextLine(); // Limpar buffer
//
//	        System.out.print("Nome: ");
//	        String nome = scanner.nextLine();
//
//	        System.out.print("Estado (número): ");
//	        int estado = scanner.nextInt();
//	        scanner.nextLine(); //
//	        
//	        System.out.print("É capital? (sim/não): ");
//	        String respostaCapital = scanner.nextLine();
//	        boolean ehCapital = interpretarBooleano(respostaCapital);
//
//	        System.out.print("É prime? (sim/não): ");
//	        String respostaPrime = scanner.nextLine();
//	        boolean ehPrime = interpretarBooleano(respostaPrime);
//
//	        loja.cadastrarCliente(id, nome, estado, ehCapital, ehPrime);
//	        System.out.println("Cliente cadastrado com sucesso!");
//	    }
//	    private static void cadastrarProduto() {
//	        System.out.print("Código: ");
//	        int codigo = scanner.nextInt();
//	        scanner.nextLine(); // Limpar buffer
//
//	        System.out.print("Descrição: ");
//	        String descricao = scanner.nextLine();
//
//	        System.out.print("Valor de Venda (em centavos): ");
//	        int valorVenda = scanner.nextInt();
//	        scanner.nextLine(); // Limpar buffer
//
//	        System.out.print("Unidade: ");
//	        String unidade = scanner.nextLine();
//
//	        loja.cadastrarProduto(codigo, descricao, valorVenda, unidade);
//	        System.out.println("Produto cadastrado com sucesso!");
//	    }
//	    private static void listarProdutos(){
//	    	System.out.println("\nLista de Produtos:");
//	        for (Produto produto : loja.getProdutos()) {
//	            System.out.println("Código: " + produto.getCodigo() +
//	                               ", Descrição: " + produto.getDescricao() +
//	                               ", Valor: " + produto.getValor() + " centavos" +
//	                               ", Unidade: " + produto.getUnidade());
//	        }
//	    }
//	    private static void cadastrarVenda(){
//	    	int usrInput = 0, qtdProdutosSelecionados = 0;
//	    	ArrayList<Integer> produtos = new  ArrayList<Integer>();
//	    	
//	    	System.out.println("\nCadastro de Venda: ");
//	    	do {
//	    		System.out.println("\nSelecione a opção desejada: ");
//	    		System.out.println("1 - Listar Produtos");
//	    		System.out.println("2 - Selecionar Produto");
//	    		System.out.println("3 - Sair");
//	    		
//	    		System.out.print("Escolha uma opção: ");
//	            usrInput = scanner.nextInt();
//
//	            switch (usrInput) {
//	                case 1:
//	                    listarProdutos();
//	                    break;
//	                case 2:
//	                    System.out.println("Digite o código do produto desejado: ");
//	                    int codProd = scanner.nextInt();
//	                    produtos.add(codProd);
//	                    qtdProdutosSelecionados++;
//	                    break;
//	                case 3:
//	                	if ( qtdProdutosSelecionados == 0 ) {
//	                		System.out.println("É necessário adicionar ao menos um produto");
//	                		continue;
//	                	}
//	                    System.out.println("\nCarregando o próximo passo!\n");
//	                    break;
//	                default:
//	                    System.out.println("Opção inválida. Tente novamente.");
//	            }
//	    	} while ( usrInput != 3 || qtdProdutosSelecionados == 0 );
//	    	
//	    	// to-do: criar ProdutoVenda e, tendo selecionado o cliente, criar a venda e adicionar à loja
//	    	
//	    	produtos.forEach((element) -> System.out.println("Produto comprado: " + element));
//	    	
//	    }	    
//	    
//	    private static boolean interpretarBooleano(String resposta) {
//	        return resposta.equalsIgnoreCase("s");
//	    }
//
//	    private static void listarClientes() {
//	        System.out.println("\nLista de Clientes:");
//	        for (Cliente cliente : loja.getClientes()) {
//	            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() +
//	                               ", Regiao: " + cliente.getRegiao() + 
//	                               ", Capital: " + cliente.getEhCapital() + 
//	                               ", Prime: " + cliente.getEhPrime());
//	        }
//	    }
//	    
//	    private static void inicializarCliente() {
//	    	loja.cadastrarCliente(new Cliente(1, "Mariana", 2, true, true));
//	    	loja.cadastrarCliente(new Cliente(2, "Paulinho Antônio", 2, true, true));
//	    	loja.cadastrarCliente(new Cliente(3, "Paulinho Antônio", 2, false, false));
//	    }
//	    
//	    private static void inicializarProdutos() {
//	    	loja.cadastrarProduto(new Produto(1, "areia", 15000 , "m3"));
//	    	loja.cadastrarProduto(new Produto(2, "cimento", 5000 , "saco"));
//	    	loja.cadastrarProduto(new Produto(3, "tauba", 2000 , "unidade"));
//	    }
//	}
//
