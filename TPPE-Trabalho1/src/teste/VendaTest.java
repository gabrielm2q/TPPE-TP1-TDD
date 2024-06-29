package teste;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Cliente;
import app.Produto;
import app.ProdutoVenda;
import app.Venda;

public class VendaTest {
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	private ProdutoVenda produtoVenda1;
	private ProdutoVenda produtoVenda2;
	private ProdutoVenda produtoVenda3;
	private Venda venda1;
//	private Venda venda2;
//	private Venda venda3;
	private Cliente cliente1;
	private LocalDateTime date1;
	private ArrayList<ProdutoVenda> produtos1;
	
	@Before
	public void setup() {
		produto1 = new Produto(1, "areia", 15000 , "m3");
		produto2 = new Produto(2, "cimento", 5000 , "saco");
		produto3 = new Produto(3, "tauba", 2000 , "unidade");
		produtoVenda1 = new ProdutoVenda(produto1, 1);
		produtoVenda2 = new ProdutoVenda(produto2, 2);
		produtoVenda3 = new ProdutoVenda(produto3, 3);
		cliente1 = new Cliente(1, "Paulinho Antônio", 2 , true, true);
		date1 = LocalDateTime.now().minusDays(1);
		produtos1 = new ArrayList<ProdutoVenda>();
		produtos1.add(produtoVenda1);
		produtos1.add(produtoVenda2);
		produtos1.add(produtoVenda3);
		venda1 = new Venda(1, produtos1, cliente1, date1);
	}
	
	@Test
	public void getValorTotalVenda() {
		int expected = produtoVenda1.getValorParcial() + produtoVenda2.getValorParcial() + produtoVenda3.getValorParcial();
		assertEquals(expected, venda1.calculaValorTotal());
	}
	
	@Test
	public void getClienteVenda() {
		Cliente expected = cliente1;
		assertEquals(expected, venda1.getCliente());
	}
	
	@Test
	public void getDataVenda() {
		LocalDateTime expected = date1;
		assertEquals(expected, venda1.getData());
	}
	
	@Test
	public void vendaIncluiProdutosVenda() {
		ArrayList<ProdutoVenda> expected = produtos1;
		assertEquals(expected, venda1.getProdutos());
	}

}
