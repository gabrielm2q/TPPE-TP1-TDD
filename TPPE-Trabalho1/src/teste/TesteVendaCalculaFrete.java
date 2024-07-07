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
	private boolean ehEspecial;
	
	public TesteVendaCalculaFrete (int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento, int valorFrete, boolean ehEspecial) {
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.metodoPagamento = metodoPagamento;
		this.data = data;
		this.valorFrete = valorFrete;
		this.ehEspecial = ehEspecial;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1);
		LocalDateTime date1 = LocalDateTime.now().minusDays(1);
	
		Cliente cliente1 = new Cliente(1, "Paulinho Antonio", 0, false, false);
		Cliente cliente2 = new Cliente(2, "Paulinho", 0, true, false);
		Cliente cliente3 = new Cliente(3, "Antonio", 1, false, false);
		Cliente cliente4 = new Cliente(4, "Paulinho Antonio", 1, true, false);
		Cliente cliente5 = new Cliente(5, "Paulinho", 2, false, false);
		Cliente cliente6 = new Cliente(6, "Antonio", 2, true, false);
		Cliente cliente7 = new Cliente(7, "Paulinho Antonio", 3, false, false);
		Cliente cliente8 = new Cliente(8, "Paulinho", 3, true, false);
		Cliente cliente9 = new Cliente(9, "Antonio", 4, false, false);
		Cliente cliente10 = new Cliente(10, "Paulinho Antonio", 4, true, false);
		Cliente cliente11 = new Cliente(11, "Paulinho", 5, false, false);
		Cliente cliente12 = new Cliente(12, "Antonio", 5, true, false);
		
		Cliente cliente13 = new Cliente(13, "Paulinho", 3, false, false);
		Cliente cliente14 = new Cliente(14, "Antonio", 3, true, false);
		
		Cliente cliente15 = new Cliente(15, "Paulinho", 3, false, true);
		Cliente cliente16 = new Cliente(16, "Antonio", 3, true, true);
		
		ArrayList<ProdutoVenda> produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		
		String metodoPagamento = "PIX";
		
		Object[][] parametros = new Object[][] {
			{1, produtos1, cliente1, date1, metodoPagamento, 0, false},
			{2, produtos1, cliente2, date1, metodoPagamento, 500, false},
			{3, produtos1, cliente3, date1, metodoPagamento, 1300, false},
			{4, produtos1, cliente4, date1, metodoPagamento, 1000, false},
			{5, produtos1, cliente5, date1, metodoPagamento, 1800, false},
			{6, produtos1, cliente6, date1, metodoPagamento, 1500, false},
			{7, produtos1, cliente7, date1, metodoPagamento, 2500, false},
			{8, produtos1, cliente8, date1, metodoPagamento, 2000, false},
			{9, produtos1, cliente9, date1, metodoPagamento, 1000, false},
			{10, produtos1, cliente10, date1, metodoPagamento, 700, false},
			{11, produtos1, cliente11, date1, metodoPagamento, 1300, false},
			{12, produtos1, cliente12, date1, metodoPagamento, 1000, false},
			
			{13, produtos1, cliente13, date1, metodoPagamento, 1750, true},
			{14, produtos1, cliente14, date1, metodoPagamento, 1400, true},
			
			{15, produtos1, cliente15, date1, metodoPagamento, 0, false},
			{16, produtos1, cliente16, date1, metodoPagamento, 0, true},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcVendaAttributes() {
		venda = new Venda(id, produtos, cliente, data, metodoPagamento, ehEspecial);
		
		assertEquals(valorFrete, this.venda.calculaFrete(ehEspecial));
	}

}