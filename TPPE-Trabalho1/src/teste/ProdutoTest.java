package teste;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Produto;

public class ProdutoTest {

    @Test
    public void cadastrarProduto1() {
        Produto produto = new Produto(1, "areia", 15000, "m3");
        assertEquals(1, produto.getCodigo());
        assertEquals("areia", produto.getDescricao());
        assertEquals(15000, produto.getValor());
        assertEquals("m3", produto.getUnidade());
    }

    @Test
    public void cadastrarProduto2() {
        Produto produto = new Produto(2, "cimento", 5000, "saco");
        assertEquals(2, produto.getCodigo());
        assertEquals("cimento", produto.getDescricao());
        assertEquals(5000, produto.getValor());
        assertEquals("saco", produto.getUnidade());
    }

    @Test
    public void cadastrarProduto3() {
        Produto produto = new Produto(3, "tauba", 2000, "unidade");
        assertEquals(3, produto.getCodigo());
        assertEquals("tauba", produto.getDescricao());
        assertEquals(2000, produto.getValor());
        assertEquals("unidade", produto.getUnidade());
    }
}
