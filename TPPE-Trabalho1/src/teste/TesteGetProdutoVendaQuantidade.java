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
public class TesteGetProdutoVendaQuantidade {
	
	private ProdutoVenda produtoVenda;
	private int quantidade;
	
	public TesteGetProdutoVendaQuantidade ( ProdutoVenda produtoVenda, int quantidade ) {
		this.produtoVenda = produtoVenda;
		this.quantidade = quantidade;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		Produto produto2 = new Produto(2, "cimento", 5000 , "saco");
		Produto produto3 = new Produto(3, "tauba", 2000 , "unidade");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1, 1);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, 2, 0);
		ProdutoVenda produtoVenda3 = new ProdutoVenda(produto3, 3, 1);
		
		Object[][] parametros = new Object[][] {
			{produtoVenda1, 1},
			{produtoVenda2, 2},
			{produtoVenda3, 3}
		};
		
		return Arrays.asList(parametros);
	}
	

	@Test
    public void testGetQuantidade() {
        assertEquals(produtoVenda.getQuantidade(), quantidade);
    }

}
