package app;

public class ProdutoVenda {
	Produto produto;
	int quantidade;
	
	/*
	 * Foi aplicada a operacao de refatoracao Extrair Classe,
	 * onde foram removidos os atributos e metodos relativos
	 * ao conceito de Impostos e foi criada uma nova classe
	 * para tal conceito.
	 * 
	 * Apos a operacao de refatoracao, os testes previamente 
	 * desenvolvidos foram executados com sucesso, indicando 
	 * a inalteracao da logica original do codigo.
	 * */
	private Impostos taxas = new Impostos();
	private int valorParcial;
	
	public ProdutoVenda(Produto produto, int quantidade, int regiao) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		taxas.calculaImpostos(this, regiao);
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
		return this.taxas.getIcms();
	}
	
	public int getMunicipal() {
		return this.taxas.getMunicipal();
	}
	
	private void calculaValorParcial() {
		this.valorParcial = this.produto.getValor() * this.quantidade;
		this.valorParcial += this.taxas.getIcms() + this.taxas.getMunicipal();
	}
	
}
