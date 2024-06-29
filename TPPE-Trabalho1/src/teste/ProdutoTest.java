package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Produto;

public class ProdutoTest {

	@Test
	public void cadastrarProduto() {
        Produto produto = new Produto(1, "areia", 15000 , "m3");
        assertEquals(1, produto.getCodigo()); 
        assertEquals("areia", produto.getDescricao());
        assertEquals(15000, produto.getValor()); 
        assertEquals("m3", produto.getUnidade());
    }
	
	@Test
	public void cadastrarProduto2() {
        Produto produto = new Produto(1, "p�", 7769 , "unidade");
        assertEquals(1, produto.getCodigo()); 
        assertEquals("p�", produto.getDescricao());
        assertEquals(7769, produto.getValor()); 
        assertEquals("unidade", produto.getUnidade());
    }

}
