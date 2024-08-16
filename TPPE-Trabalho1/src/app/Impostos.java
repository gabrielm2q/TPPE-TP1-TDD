package app;


/*
 * Foi aplicada a operacao de refatoracao Extrair Classe 
 * sobre a classe ProdutoVenda, sendo gerada esta nova 
 * classe voltada apenas para Impostos, recebendo os 
 * atributos e metodos relativos a tal.
 * 
 * Apos a operacao de refatoracao, os testes previamente 
 * desenvolvidos foram executados com sucesso, indicando 
 * a inalteracao da logica original do codigo.
 * */
public class Impostos {
	private int icms;
	private int municipal;

	public Impostos() {
		
	}

	public int getIcms() {
		return icms;
	}

	public void setIcms(int icms) {
		this.icms = icms;
	}

	public int getMunicipal() {
		return municipal;
	}

	public void setMunicipal(int municipal) {
		this.municipal = municipal;
	}

	public void calculaImpostos(ProdutoVenda produtoVenda, int regiao) {
		int valorProduto = produtoVenda.produto.getValor() * produtoVenda.quantidade;
		
		setIcms((int) ( regiao == 0 ? valorProduto * 0.18 : valorProduto * 0.12 ));
		setMunicipal((int) ( regiao == 0 ? 0 : valorProduto * 0.04 ));
	}
}