package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Collection;
import java.util.Arrays;
import org.junit.Test;

import app.Produto;

@RunWith(Parameterized.class)
public class TesteGetProduto {
	
	private int codigo;
	private String descricao;
	private int valor;
	private String unidade;
	
	public TesteGetProduto ( int codigo, String descricao, int valor, String unidade ) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.unidade = unidade;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{1, "Enxada", 3500, "unidade"},
			{2, "Trena a Laser", 30599, "unidade"},
			{3, "Facao", 3000, "unidade"},
			{4, "Estopa", 999, "saco"},
			{5, "Piso", 2700, "m2"}
		};
		
		return Arrays.asList(parametros);
	}

    @Test
    public void getAtributosProduto() {
        Produto produto = new Produto(codigo, descricao, valor, unidade);
        
        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valor, produto.getValor());
        assertEquals(unidade, produto.getUnidade());
    }
}
