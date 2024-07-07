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
public class TesteVendaCalculaValorFinal {

	private Venda venda;
	private int id;
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private String metodoPagamento;
	private LocalDateTime data;
	private String cartaoCredito;
	private int valorEsperado;
	
	public TesteVendaCalculaValorFinal (int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento, String cartaoCredito, int valorEsperado) {
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.metodoPagamento = metodoPagamento;
		this.data = data;
		this.cartaoCredito = cartaoCredito;
		this.valorEsperado = valorEsperado;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1, 0);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto1, 1, 1);

		LocalDateTime date1 = LocalDateTime.now().minusDays(1);
		
		Cliente cliente1 = new Cliente(1, "Paulinho Antonio", 0, true, false);
		Cliente cliente2 = new Cliente(2, "Paulinho Antonio", 1, true, false);
		Cliente cliente3 = new Cliente(3, "Paulinho Antonio", 0, true, true);
		Cliente cliente4 = new Cliente(4, "Paulinho Antonio", 1, false, true);
		cliente2.setEhEspecial(true);
		cliente4.setEhEspecial(true);
		
		ArrayList<ProdutoVenda> produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		
		ArrayList<ProdutoVenda> produtos2 = new ArrayList<ProdutoVenda>();
		produtos2.add(produtoVenda2);
		
		Object[][] parametros = new Object[][] {
			{1, produtos1, cliente1, date1, "PIX", "", 18200},
			{2, produtos2, cliente2, date1, "PIX", "", 16290},
			{3, produtos1, cliente3, date1, "BOLETO", "", 17700},
			{4, produtos2, cliente4, date1, "BOLETO", "", 15660},
			{5, produtos2, cliente2, date1, "CREDITO", "1234 5678 9123 4567", 16290},
			{6, produtos2, cliente2, date1, "CREDITO", "4296 1378 9123 4567", 14480}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcValorFinal() {
		venda = new Venda(id, produtos, cliente, data, metodoPagamento, cartaoCredito);
		
		assertEquals(valorEsperado, venda.getValorFinal());
	}

}
