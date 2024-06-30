package app;

public class Produto {
	private int codigo;
	private String descricao;
	private int valor; // em centavos
	private String unidade; //(pe�a, unidade, metro, cm3, etc...)
	
	public Produto(int codigo, String descricao, int valor, String unidade) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.unidade = unidade;
	}
	public int getCodigo() {
		return codigo;
	}
	 public void setCodigo(int codigo) {
	        this.codigo = codigo;
	   }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
}
