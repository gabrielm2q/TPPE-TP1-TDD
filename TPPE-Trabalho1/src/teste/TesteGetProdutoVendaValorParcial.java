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
	private int valorICMS;
	private int valorMunicipal;
	
	public TesteGetProdutoVendaValorParcial ( ProdutoVenda produtoVenda, int valorParcial, int valorICMS, int valorMunicipal ) {
		this.produtoVenda = produtoVenda;
		this.valorParcial = valorParcial;
		this.valorICMS = valorICMS;
		this.valorMunicipal = valorMunicipal;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		int quantidade1 = 3, quantidade2 = 6, quantidade3 = 9;
		int preco1 = 15000, preco2 = 5000, preco3 = 2000;
		Produto produto1 = new Produto(1, "areia", preco1 , "m3");
		Produto produto2 = new Produto(2, "cimento", preco2 , "saco");
		Produto produto3 = new Produto(3, "tauba", preco3 , "unidade");
		ProdutoVenda produtoVenda1 = new ProdutoVenda(produto1, quantidade1, 0);
		ProdutoVenda produtoVenda2 = new ProdutoVenda(produto2, quantidade2, 1);
		ProdutoVenda produtoVenda3 = new ProdutoVenda(produto3, quantidade3, 2);
		int valorParcial1 = (quantidade1 * preco1);
		valorParcial1 = valorParcial1 + (int) ( valorParcial1 * 0.18 );
		int valorParcial2 = (quantidade2 * preco2);
		valorParcial2 = valorParcial2 + (int) ( valorParcial2 * 0.12 ) + (int) ( valorParcial2 * 0.04 );
		int valorParcial3 = (quantidade3 * preco3);
		valorParcial3 = valorParcial3 + (int) ( valorParcial3 * 0.12 ) + (int) ( valorParcial3 * 0.04 );
		
		
		Object[][] parametros = new Object[][] {
			{produtoVenda1, valorParcial1, (int) ( (quantidade1 * preco1) * 0.18 ), 0},
			{produtoVenda2, valorParcial2, (int) ( (quantidade2 * preco2) * 0.12 ), (int) ( (quantidade2 * preco2) * 0.04 )},
			{produtoVenda3, valorParcial3, (int) ( (quantidade3 * preco3) * 0.12 ), (int) ( (quantidade3 * preco3) * 0.04 )}
		};
		
		return Arrays.asList(parametros);
	}
	

	@Test
    public void testGetValorParcial() {
        assertEquals(produtoVenda.getValorParcial(), valorParcial);
        assertEquals(produtoVenda.getICMS(), valorICMS);
        assertEquals(produtoVenda.getMunicipal(), valorMunicipal);
    }

}
