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
public class TesteGetVenda {
	
	private Venda venda;
	private int id;
	private ArrayList<ProdutoVenda> produtos;
	private Cliente cliente;
	private LocalDateTime data;
	private String metodoPagamento;
	
	public TesteGetVenda (int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, LocalDateTime data, String metodoPagamento) {
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.data = data;
		this.metodoPagamento = metodoPagamento;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		Produto produto2 = new Produto(2, "cimento", 5000 , "saco");
		Produto produto3 = new Produto(3, "tauba", 2000 , "unidade");
		
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1, 0);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, 2, 0);
		ProdutoVenda produtoVenda3 = new ProdutoVenda(produto3, 3, 0);
		
		LocalDateTime date1 = LocalDateTime.now().minusDays(1);
		LocalDateTime date2 = LocalDateTime.now().minusDays(7);
		LocalDateTime date3 = LocalDateTime.now().minusDays(31);
		LocalDateTime date4 = LocalDateTime.now();
		Cliente cliente1 = new Cliente(1, "Paulinho Antonio", 2 , true, true);
		
		ArrayList<ProdutoVenda> produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		produtos1.add(produtoVenda2);
		produtos1.add(produtoVenda3);
		
		ArrayList<ProdutoVenda> produtos2 = new ArrayList<ProdutoVenda>();
		produtos2.add(produtoVenda1);
		produtos2.add(produtoVenda2);
		
		ArrayList<ProdutoVenda> produtos3 = new ArrayList<ProdutoVenda>();
		produtos3.add(produtoVenda1);
		
		ArrayList<ProdutoVenda> produtos4 = new ArrayList<ProdutoVenda>();
		
		String metPag1 = "PIX";
		String metPag2 = "BOLETO";
		
		Object[][] parametros = new Object[][] {
			{1, produtos1, cliente1, date1, metPag1},
			{2, produtos2, cliente1, date2, metPag1},
			{3, produtos3, cliente1, date3, metPag2},
			{4, produtos4, cliente1, date4, metPag2}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcVendaAttributes() {
		venda = new Venda(id, produtos, cliente, data, metodoPagamento);
		
		assertEquals(venda.getId(), id);
		assertEquals(venda.getProdutos(), produtos);
		assertEquals(venda.getCliente(), cliente);
		assertEquals(venda.getData(), data);
		assertEquals(venda.getMetodoPagamento(), metodoPagamento);
	}

}
