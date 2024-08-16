package app;


/*
 * Foi aplicada a operacao de refatoracao Substituir Metodo
 * por Metodo-Objeto sobre o metodo Venda::calculaValorFinal(),
 * onde, a partir de toda a logica de implementacao do codigo
 * que calcula o valor final da venda foi movida para esta
 * nova classe, na qual o metodo compute(), a partir dos atributos
 * utilizados na logica original, eh responsavel por retornar o 
 * valor final da compra.
 * 
 * Apos a operacao de refatoracao, os testes previamente 
 * desenvolvidos foram executados com sucesso, indicando 
 * a inalteracao da logica original do codigo.
 * */
public class ValorFinalCalculator {
	public Venda venda;
	private int valorFinal;
	private Cliente cliente;
	private int valorTotal;
	private boolean cartaoCreditoEhDaLoja;
	
	public ValorFinalCalculator(Venda venda) {
		this.venda = venda;
		this.valorFinal = venda.valorFinal;
		this.cliente = venda.cliente;
		this.valorTotal = venda.valorTotal;
		this.cartaoCreditoEhDaLoja = venda.cartaoCreditoEhDaLoja;
	}
	
	public int compute() {
		if ( this.cliente.getEhEspecial() ) {
			this.venda.desconto += (int) (this.valorTotal * ( this.cartaoCreditoEhDaLoja ? 0.2 : 0.1 ));
			this.valorFinal = (int) (this.valorTotal * ( this.cartaoCreditoEhDaLoja ? 0.8 : 0.9 ));
		} else {
			this.valorFinal = this.venda.valorTotal;
		}
		
		if ( this.venda.cliente.getEhPrime() ) {
			if ( this.valorFinal >= this.cliente.getSaldoCashback() ) {
				this.venda.cliente.setSaldoCashback(0);
				this.valorFinal -= this.cliente.getSaldoCashback();
			} else {
				this.venda.cliente.setSaldoCashback(this.cliente.getSaldoCashback() - this.valorFinal);
				this.valorFinal = 0;
			}
		}
		
		return this.valorFinal;
	}

}
