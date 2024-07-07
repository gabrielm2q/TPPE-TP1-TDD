package app;

import java.util.ArrayList;
import java.time.LocalDateTime;


public class Venda {
	private int id; // ID da Compra
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private int valorTotal;
	private LocalDateTime data;
	private String metodoPagamento; // "PIX", "DEBITO", "CREDITO", "BOLETO"
	private boolean cartaoCreditoEhDaLoja;
	private int valorFrete;
	private int desconto;
	private int valorImpostos;
	private int valorFinal;
	private int valorCashback;

	public Venda(int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.data = data;
		this.metodoPagamento = metodoPagamento;
		this.cartaoCreditoEhDaLoja = verificaCartaoCredito(null);
		this.valorFrete = calculaFrete();
		calculaImpostos();
		calculaValorTotal();
		calculaValorFinal();
		calculaValorCashback();
	}
	
	public Venda(int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento, String cartaoCredito) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.data = data;
		this.metodoPagamento = metodoPagamento;
		this.cartaoCreditoEhDaLoja = verificaCartaoCredito(cartaoCredito);
		this.valorFrete = calculaFrete();
		calculaImpostos();
		calculaValorTotal();
		calculaValorFinal();
		calculaValorCashback();
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
	
	public String getMetodoPagamento() {
		return this.metodoPagamento;
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
	
	public int getValorTotal() {
		return this.valorTotal;
	}
	
	public int getValorFrete() {
		return this.valorFrete;
	}
	
	public int getValorFinal() {
		return this.valorFinal;
	}
	
	public int getValorCashback() {
		return this.valorCashback;
	}
	
	public boolean verificaCartaoCredito(String cartaoCredito) {
		cartaoCredito = ( cartaoCredito == null || cartaoCredito.length() < 16 ? "XXXX XXXX XXXX XXXX" : cartaoCredito.replaceAll("\s", "") );
		if ( this.metodoPagamento.equals("CREDITO") && cartaoCredito.substring(0, 6).equals("429613") ) return true;
		return false;
	}
	
	private int calculaValorCashback() {
		this.valorCashback = 0;
		
		if ( this.cliente.getEhPrime() ) {
			this.valorCashback = ((this.valorFinal / 100) * 100);
			this.valorCashback = (int) (this.valorFinal * ( this.cartaoCreditoEhDaLoja ? 0.05 : 0.03 ));
			this.cliente.setSaldoCashback(this.cliente.getSaldoCashback() + this.valorCashback);
		}
		
		return this.valorCashback;
	}
	
	private void calculaValorFinal() {
		if ( this.cliente.getEhEspecial() ) {
			this.valorFinal = (int) (this.valorTotal * ( this.cartaoCreditoEhDaLoja ? 0.8 : 0.9 ));
			this.desconto += (int) (this.valorTotal * ( this.cartaoCreditoEhDaLoja ? 0.2 : 0.1 ));
		} else {
			this.valorFinal = this.valorTotal;
		}
		
		if ( this.cliente.getEhPrime() ) {
			if ( this.valorFinal >= this.cliente.getSaldoCashback() ) {
				this.valorFinal -= this.cliente.getSaldoCashback();
				this.cliente.setSaldoCashback(0);
			} else {
				this.cliente.setSaldoCashback(this.cliente.getSaldoCashback() - this.valorFinal);
				this.valorFinal = 0;
			}
		}
	}
	
	private void calculaValorTotal() {
		this.valorTotal = 0;
		for (ProdutoVenda pv : produtos) {
			valorTotal += pv.getValorParcial();
		}
		this.valorTotal += this.valorFrete;
	}

	private int calculaFrete() {
		int valFrete = 0;
		switch ( this.cliente.getRegiao() ) {
			case 0:
				valFrete = ( this.cliente.getEhCapital() ? 500 : 0 );
				break;
			case 1:
				valFrete = ( this.cliente.getEhCapital() ? 1000 : 1300 );
				break;
			case 2:
				valFrete = ( this.cliente.getEhCapital() ? 1500 : 1800 );
				break;
			case 3:
				valFrete = ( this.cliente.getEhCapital() ? 2000 : 2500 );
				break;
			case 4:
				valFrete = ( this.cliente.getEhCapital() ? 700 : 1000 );
				break;
			case 5:
			default:
				valFrete = ( this.cliente.getEhCapital() ? 1000 : 1300 );
				break;
		}
		
		if ( this.cliente.getEhPrime() ) {
			this.desconto += valFrete;
			return 0;
		}
		
		if ( this.cliente.getEhEspecial() ) {
			this.desconto += (int) ( valFrete * 0.3 );
			valFrete = (int) ( valFrete * 0.7 );
		}
		
		return valFrete;
	}
	
	private void calculaImpostos() {
		this.valorImpostos = 0;
		for ( ProdutoVenda pv : produtos ) {
			this.valorImpostos += pv.getICMS() + pv.getMunicipal();
		}
	}
	
}
