package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;

import app.ProdutoVenda;
import app.Produto;

@RunWith(Parameterized.class)
public class TesteGetProdutoVendaValorParcial {
	
	private ProdutoVenda produtoVenda;
	private int valorParcial;
	
	public TesteGetProdutoVendaValorParcial ( ProdutoVenda produtoVenda, int valorParcial ) {
		this.produtoVenda = produtoVenda;
		this.valorParcial = valorParcial;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		int quantidade1 = 3, quantidade2 = 6, quantidade3 = 9;
		int preco1 = 15000, preco2 = 5000, preco3 = 2000;
		Produto produto1 = new Produto(1, "areia", preco1 , "m3");
		Produto produto2 = new Produto(2, "cimento", preco2 , "saco");
		Produto produto3 = new Produto(3, "tauba", preco3 , "unidade");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, quantidade1);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, quantidade2);
		ProdutoVenda produtoVenda3 = new ProdutoVenda(produto3, quantidade3);
		
		Object[][] parametros = new Object[][] {
			{produtoVenda1, quantidade1 * preco1},
			{produtoVenda2, quantidade2 * preco2},
			{produtoVenda3, quantidade3 * preco3}
		};
		
		return Arrays.asList(parametros);
	}
	

	@Test
    public void testGetValorParcial() {
        assertEquals(produtoVenda.getValorParcial(), valorParcial);
    }

}
