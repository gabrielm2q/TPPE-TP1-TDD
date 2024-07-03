package app;

public class ProdutoVenda {
	private Produto produto;
	private int quantidade;
	private int valorParcial;
	
	public ProdutoVenda(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		getValorParcial();
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
		this.valorParcial = this.produto.getValor() * this.quantidade;
		return this.valorParcial;
	}
	
}
