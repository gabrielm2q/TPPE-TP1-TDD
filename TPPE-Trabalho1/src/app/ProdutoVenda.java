package app;

public class ProdutoVenda {
	private Produto produto;
	private int quantidade;
	private int icms;
	private int municipal;
	private int valorParcial;
	
	public ProdutoVenda(Produto produto, int quantidade, int regiao) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		calculaImpostos(regiao);
		calculaValorParcial();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getValorParcial() {
		return this.valorParcial;
	}
	
	public int getICMS() {
		return this.icms;
	}
	
	public int getMunicipal() {
		return this.municipal;
	}
	
	private void calculaImpostos(int regiao) {
		int valorProduto = this.produto.getValor() * this.quantidade;
		
		this.icms = (int) ( regiao == 0 ? valorProduto * 0.18 : valorProduto * 0.12 );
		this.municipal = (int) ( regiao == 0 ? 0 : valorProduto * 0.04 );
	}
	
	private void calculaValorParcial() {
		this.valorParcial = this.produto.getValor() * this.quantidade;
		this.valorParcial += this.icms + this.municipal;
	}
	
}
