package app;

import java.util.ArrayList;
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
    
    // Cadastro Cliente
    public void cadastrarCliente(int id, String nome, int regiao, boolean ehCapital, boolean ehPrime) {
        Cliente novoCliente = new Cliente(id, nome, regiao, ehCapital, ehPrime);
        clientes.add(novoCliente);
    }
    
    public void cadastrarCliente(Cliente cli) {
    	clientes.add(cli);
    }
    
    public void validarTipoCliente(Cliente cliente) {
        ArrayList<Venda> vendasDoCliente = (ArrayList<Venda>) vendas.stream()
            .filter(venda -> venda.getCliente().getId() == cliente.getId())
            .collect(Collectors.toList());

        int totalCompras = vendasDoCliente.stream()
            .mapToInt(Venda::calculaValorTotal)
            .sum();

        if (totalCompras > 50000) { // Exemplo: mais de 500 reais
            cliente.setEhPrime(true);
        } else {
            cliente.setEhPrime(false);
        }
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
    public void realizarVenda(Venda venda) {
        vendas.add(venda); // Realizar cálculos de frete, descontos, impostos, etc.
    }
    
}
