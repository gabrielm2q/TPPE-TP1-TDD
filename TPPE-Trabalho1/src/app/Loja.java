package app;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Loja {
	private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Venda> vendas;
	// lista de compras -> pra ver se eh especial

    // Loja
    public Loja() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
        inicializarCliente();
        inicializarProdutos();
    }
    
    private void inicializarCliente() {
    	clientes.add(new Cliente(1, "Mariana", 2, true, true));
    	clientes.add(new Cliente(2, "Paulinho Antônio", 2, true, true));
    	clientes.add(new Cliente(3, "Paulinho Antônio", 2, false, false));
    }
    
    private void inicializarProdutos() {
        produtos.add(new Produto(1, "areia", 15000 , "m3"));
        produtos.add(new Produto(2, "cimento", 5000 , "saco"));
        produtos.add(new Produto(3, "tauba", 2000 , "unidade"));
    }
    
    // Cadastro Cliente
    public void cadastrarCliente(int id, String nome, int estado, boolean ehCapital, boolean ehPrime) {
        Cliente novoCliente = new Cliente(id, nome, estado, ehCapital, ehPrime);
        clientes.add(novoCliente);
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
    
    // Venda
    public void realizarVenda(Venda venda) {
        vendas.add(venda);
        // Realizar cálculos de frete, descontos, impostos, etc.
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }	
}
