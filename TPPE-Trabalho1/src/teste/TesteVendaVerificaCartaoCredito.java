package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Collection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import app.Cliente;
import app.Produto;
import app.ProdutoVenda;
import app.Venda;

@RunWith(Parameterized.class)
public class TesteVendaVerificaCartaoCredito {

	private Venda venda;
	private int id;
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private String metodoPagamento;
	private LocalDateTime data;
	private String cartaoCredito;
	private boolean cartaoCreditoEhDaLoja;
	
	public TesteVendaVerificaCartaoCredito (int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento, String cartaoCredito, boolean cartaoCreditoEhDaLoja) {
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.metodoPagamento = metodoPagamento;
		this.data = data;
		this.cartaoCredito = cartaoCredito;
		this.cartaoCreditoEhDaLoja = cartaoCreditoEhDaLoja;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1);
		LocalDateTime date1 = LocalDateTime.now().minusDays(1);
		Cliente cliente1 = new Cliente(1, "Paulinho Antonio", 2 , true, true);
		
		ArrayList<ProdutoVenda> produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		
		Object[][] parametros = new Object[][] {
			{1, produtos1, cliente1, date1, "PIX", "", false},
			{2, produtos1, cliente1, date1, "DEBITO", "", false},
			{3, produtos1, cliente1, date1, "PIX", "1234 5678 9123 4567", false},
			{4, produtos1, cliente1, date1, "CREDITO", "1234 5678 9123 4567", false},
			{5, produtos1, cliente1, date1, "CREDITO", "1234", false},
			{6, produtos1, cliente1, date1, "CREDITO", "4296 1311 1111 2222", false},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcVendaAttributes() {
		if ( cartaoCredito.equals("") ) {
			venda = new Venda(id, produtos, cliente, data, metodoPagamento, false);
		} else {
			venda = new Venda(id, produtos, cliente, data, metodoPagamento, false, cartaoCredito);
		}
		
		assertEquals(venda.verificaCartaoCredito(cartaoCredito), cartaoCreditoEhDaLoja);
	}

}
