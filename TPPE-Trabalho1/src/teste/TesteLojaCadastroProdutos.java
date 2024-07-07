package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import app.Loja;
import app.Produto;

@RunWith(Parameterized.class)
public class TesteLojaCadastroProdutos {
	
	private ArrayList<Produto> produtos;
	
	public TesteLojaCadastroProdutos (ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		
		Produto prod1 = new Produto(1, "Enxada", 3500, "unidade");
		Produto prod2 = new Produto(2, "Trena a Laser", 30599, "unidade");
		Produto prod3 = new Produto(3, "Facao", 3000, "unidade");
		Produto prod4 = new Produto(4, "Estopa", 999, "saco");
		Produto prod5 = new Produto(5, "Piso", 2700, "m2");
		
		ArrayList<Produto> produtos1 = new ArrayList<Produto>();
		ArrayList<Produto> produtos2 = new ArrayList<Produto>();
		ArrayList<Produto> produtos3 = new ArrayList<Produto>();
		
		produtos1.add(prod1);
		produtos1.add(prod2);
		produtos1.add(prod3);
		
		produtos2.add(prod4);
		produtos2.add(prod5);
		
		Object[][] parametros = new Object[][] {
			{produtos1},
			{produtos2},
			{produtos3}
		};
		
		return Arrays.asList(parametros);
	}

    @Test
    public void cadastroProdutos() {
    	Loja loja = new Loja();
    	
    	for ( Produto pro : produtos ) {
			loja.cadastrarProduto(pro);
		}
    	
        ArrayList<Produto> clis = loja.getProdutos();

        assertEquals(produtos, clis);
    }
}
