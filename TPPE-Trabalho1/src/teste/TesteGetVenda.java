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
	private int valorTotal;
	private LocalDateTime data;
	
	public TesteGetVenda (Venda venda, int id, ArrayList<ProdutoVenda> produtos, Cliente cliente, int valorTotal, LocalDateTime data) {
		this.venda = venda;
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.data = data;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		Produto produto2 = new Produto(2, "cimento", 5000 , "saco");
		Produto produto3 = new Produto(3, "tauba", 2000 , "unidade");
		
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, 2);
		ProdutoVenda produtoVenda3 = new ProdutoVenda(produto3, 3);
		
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
		
		Venda venda1 = new Venda(1, produtos1, cliente1, date1);
		Venda venda2 = new Venda(2, produtos2, cliente1, date2);
		Venda venda3 = new Venda(3, produtos3, cliente1, date3);
		Venda venda4 = new Venda(4, produtos4, cliente1, date4);
		
		Object[][] parametros = new Object[][] {
			{venda1, 1, produtos1, cliente1, 31000, date1},
			{venda2, 2, produtos2, cliente1, 25000, date2},
			{venda3, 3, produtos3, cliente1, 15000, date3},
			{venda4, 4, produtos4, cliente1, 0, date4}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test 
	public void calcVendaAttributes() {
		assertEquals(venda.getId(), id);
		assertEquals(venda.getProdutos(), produtos);
		assertEquals(venda.getCliente(), cliente);
		assertEquals(venda.calculaValorTotal(), valorTotal);
		assertEquals(venda.getData(), data);
	}

}
