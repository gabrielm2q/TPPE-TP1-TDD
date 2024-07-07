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
public class TesteVendaCalculaFrete {

	private Venda venda;
	private int id;
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private String metodoPagamento;
	private LocalDateTime data;
	private int valorFrete;
	
	public TesteVendaCalculaFrete (int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento, int valorFrete) {
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.metodoPagamento = metodoPagamento;
		this.data = data;
		this.valorFrete = valorFrete;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1);
		LocalDateTime date1 = LocalDateTime.now().minusDays(1);
	
		Cliente cliente1 = new Cliente(1, "Paulinho Antonio", 0, false, true);
		Cliente cliente2 = new Cliente(2, "Paulinho", 0, true, true);
		Cliente cliente3 = new Cliente(3, "Antonio", 1, false, true);
		Cliente cliente4 = new Cliente(4, "Paulinho Antonio", 1, true, true);
		Cliente cliente5 = new Cliente(5, "Paulinho", 2, false, true);
		Cliente cliente6 = new Cliente(6, "Antonio", 2, true, true);
		Cliente cliente7 = new Cliente(7, "Paulinho Antonio", 3, false, true);
		Cliente cliente8 = new Cliente(8, "Paulinho", 3, true, true);
		Cliente cliente9 = new Cliente(9, "Antonio", 4, false, true);
		Cliente cliente10 = new Cliente(10, "Paulinho Antonio", 4, true, true);
		Cliente cliente11 = new Cliente(11, "Paulinho", 5, false, true);
		Cliente cliente12 = new Cliente(12, "Antonio", 5, true, true);
		
		ArrayList<ProdutoVenda> produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		
		String metodoPagamento = "PIX";
		
		Object[][] parametros = new Object[][] {
			{1, produtos1, cliente1, date1, metodoPagamento, 0},
			{2, produtos1, cliente2, date1, metodoPagamento, 500},
			{3, produtos1, cliente3, date1, metodoPagamento, 1300},
			{4, produtos1, cliente4, date1, metodoPagamento, 1000},
			{5, produtos1, cliente5, date1, metodoPagamento, 1800},
			{6, produtos1, cliente6, date1, metodoPagamento, 1500},
			{7, produtos1, cliente7, date1, metodoPagamento, 2500},
			{8, produtos1, cliente8, date1, metodoPagamento, 2000},
			{9, produtos1, cliente9, date1, metodoPagamento, 1000},
			{10, produtos1, cliente10, date1, metodoPagamento, 700},
			{11, produtos1, cliente11, date1, metodoPagamento, 1300},
			{12, produtos1, cliente12, date1, metodoPagamento, 1000}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcVendaAttributes() {
		venda = new Venda(id, produtos, cliente, data, metodoPagamento);
		
		assertEquals(venda.calculaFrete(), valorFrete);
	}

}
