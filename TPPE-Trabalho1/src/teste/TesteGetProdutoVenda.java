package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Collection;
import java.util.Arrays;
import org.junit.Test;

import app.ProdutoVenda;
import app.Produto;

@RunWith(Parameterized.class)
public class TesteGetProdutoVenda {
	
	private ProdutoVenda produtoVenda;
	private Produto produto;
	
	public TesteGetProdutoVenda ( ProdutoVenda produtoVenda, Produto produto ) {
		this.produtoVenda = produtoVenda;
		this.produto = produto;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Produto produto1 = new Produto(1, "areia", 15000 , "m3");
		Produto produto2 = new Produto(2, "cimento", 5000 , "saco");
		Produto produto3 = new Produto(3, "tauba", 2000 , "unidade");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, 1, 0);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, 2, 0);
		ProdutoVenda produtoVenda3 = new ProdutoVenda(produto3, 3, 0);
		
		Object[][] parametros = new Object[][] {
			{produtoVenda1, produto1},
			{produtoVenda2, produto2},
			{produtoVenda3, produto3}
		};
		
		return Arrays.asList(parametros);
	}
	

	@Test
    public void testGetProduto() {
        assertEquals(produtoVenda.getProduto(), produto);
    }

}
