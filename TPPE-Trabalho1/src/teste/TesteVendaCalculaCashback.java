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
public class TesteVendaCalculaCashback {

	private Venda venda;
	private int id;
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private String metodoPagamento;
	private LocalDateTime data;
	private String cartaoCredito;
	private int valorEsperado;
	
	public TesteVendaCalculaCashback (int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento, String cartaoCredito, int valorEsperado) {
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
		
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1, 1);

		LocalDateTime date1 = LocalDateTime.now().minusDays(1);
		
		Cliente cliente1 = new Cliente(1, "Paulinho", 1, true, true);
		Cliente cliente2 = new Cliente(2, "Paulinho Antonio", 1, false, true);
		Cliente cliente3 = new Cliente(3, "Antonio", 1, true, true);
		Cliente cliente4 = new Cliente(4, "Paulinha", 1, false, true);
		cliente2.setEhEspecial(true);
		cliente4.setEhEspecial(true);
		
		ArrayList<ProdutoVenda> produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		
		Object[][] parametros = new Object[][] {
			{1, produtos1, cliente1, date1, "BOLETO", null, 522},
			{2, produtos1, cliente2, date1, "BOLETO", null, 469},
			{3, produtos1, cliente3, date1, "CREDITO", "1234 5678 9123 4567", 522},
			{4, produtos1, cliente4, date1, "CREDITO", "4296 1378 9123 4567", 696}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcCashback() {
		venda = new Venda(id, produtos, cliente, data, metodoPagamento, cartaoCredito);
		
		assertEquals(valorEsperado, venda.getValorCashback());
	}

}
