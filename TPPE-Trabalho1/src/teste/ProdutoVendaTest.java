package teste;

import static org.junit.Assert.*;

import org.junit.Before;

import app.Produto;
import app.ProdutoVenda;

import org.junit.Test;

public class ProdutoVendaTest {
	private Produto produto1;
	private Produto produto2;
	private Produto produto3;
	private ProdutoVenda produtoVenda1;
	private ProdutoVenda produtoVenda2;
	private ProdutoVenda produtoVenda3;
	
	@Before
	public void setup() {
		produto1 = new Produto(1, "areia", 15000 , "m3");
		produto2 = new Produto(2, "cimento", 5000 , "saco");
		produto3 = new Produto(3, "tauba", 2000 , "unidade");
		produtoVenda1 = new ProdutoVenda(produto1, 1);
		produtoVenda2 = new ProdutoVenda(produto2, 2);
		produtoVenda3 = new ProdutoVenda(produto3, 3);
	}
	
	@Test
    public void testGetProduto1() {
        assertEquals(produtoVenda1.getProduto(), produto1);
    }
	
	@Test
    public void testGetProduto2() {
        assertEquals(produtoVenda2.getProduto(), produto2);
    }
	
	@Test
    public void testGetProduto3() {
        assertEquals(produtoVenda3.getProduto(), produto3);
    }
	
	@Test
    public void testGetQuantidade1() {
        assertEquals(produtoVenda1.getQuantidade(), 1);
    }
	
	@Test
    public void testGetQuantidade2() {
        assertEquals(produtoVenda2.getQuantidade(), 2);
    }
	
	@Test
    public void testGetQuantidade3() {
        assertEquals(produtoVenda3.getQuantidade(), 3);
    }
	
	@Test
    public void testGetValorParcial1() {
        int expected = produto1.getValor() * 1;
        int result = produtoVenda1.getValorParcial();
        assertEquals(expected, result);
    }
	
	@Test
    public void testGetValorParcial2() {
        int expected = produto2.getValor() * 2;
        int result = produtoVenda2.getValorParcial();
        assertEquals(expected, result);
    }
	
	@Test
    public void testGetValorParcial3() {
        int expected = produto3.getValor() * 3;
        int result = produtoVenda3.getValorParcial();
        assertEquals(expected, result);
    }
}
