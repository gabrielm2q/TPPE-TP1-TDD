package app;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Venda {
	private int id; // id da Compra
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private int valorTotal;
	private LocalDateTime data;
//	private String metodoPagamento;
//	private int valorFrete;
//	private int desconto;
//	private int ICMS;
//	private int municipal;
//	valorFinal =  (valorTotal *1,1)*0,9
//    100 > 110
//    90 > 100
	
	
	// descontos

	public Venda(int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public ArrayList<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public int calculaValorTotal() {
		valorTotal = 0;
		for (int i = 0; i < produtos.size(); i++) {
			valorTotal += produtos.get(i).getValorParcial();
		}
		return valorTotal;
	}
	
}
