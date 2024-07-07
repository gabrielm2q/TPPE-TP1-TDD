package app;

import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Loja {
	private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Venda> vendas;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }
    
    public ArrayList<Cliente> getClientes() {
    	return clientes;
    }
    
    public ArrayList<Produto> getProdutos() {
    	return produtos;
    }	
    
    public Cliente getClienteById (int idCliente) {
    	Optional<Cliente> foundClient = (Optional<Cliente>) clientes.stream()
    			.filter(cli -> cli.getId() == idCliente)
                .findFirst();
    	

    	return foundClient.orElseThrow();
    }
    
    // Cadastro Cliente
    public void cadastrarCliente(int id, String nome, int regiao, boolean ehCapital, boolean ehPrime) {
        Cliente novoCliente = new Cliente(id, nome, regiao, ehCapital, ehPrime);
        clientes.add(novoCliente);
    }
    
    public void cadastrarCliente(Cliente cli) {
    	clientes.add(cli);
    }
    
    public boolean ehEspecial (Cliente cli) {
    	LocalDateTime dataAtual = LocalDateTime.now();
    	
        ArrayList<Venda> vendasDoCliente = (ArrayList<Venda>) vendas.stream()
            .filter(venda -> venda.getCliente().getId() == cli.getId())
            .filter(venda -> venda.getData().isAfter(dataAtual.minusDays(30)))
            .collect(Collectors.toList());

        int totalCompras = vendasDoCliente.stream()
            .mapToInt(Venda::calculaValorTotal)
            .sum();

        /*
         * Caso o cliente tenha comprado mais de 100 reais 
         * no ultimo mes, ele eh um cliente especial
         * */
        boolean ehEsp = (totalCompras > 10000 ? true : false);
        cli.setEhEspecial(ehEsp);
        
        return ehEsp; 
    }
    
    // Cadastro Produto
    public void cadastrarProduto(int codigo, String descricao, int valorVenda, String unidade) {
        Produto novoProduto = new Produto(codigo, descricao, valorVenda, unidade);
        produtos.add(novoProduto);
    }
    
    public void cadastrarProduto(Produto novoProduto) {
        produtos.add(novoProduto);
    }
    
    // Venda
    public void cadastrarVenda(Venda venda) {
        vendas.add(venda); // Realizar cálculos de frete, descontos, impostos, etc.
    }
    
}
