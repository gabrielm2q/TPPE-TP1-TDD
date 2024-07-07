package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import app.Loja;
import app.Produto;
import app.ProdutoVenda;
import app.Venda;
import app.Cliente;

@RunWith(Parameterized.class)
public class TesteLojaValidacaoClienteEspecial {
	
	private Loja loja;
	private Cliente cli1;
	private Cliente cli2;
	private Cliente cli3;
	private Cliente cli4;
	private int idCliente;
	private boolean ehEspecial;
	
	public TesteLojaValidacaoClienteEspecial (int idCliente, boolean ehEspecial) {
		this.idCliente = idCliente;
		this.ehEspecial = ehEspecial;
	}	
	
	@Before
	public void setup() {
		loja = new Loja();
		
		Produto prod1 = new Produto(1, "Enxada", 2500, "unidade");
		Produto prod2 = new Produto(2, "Trena a Laser", 2500, "unidade");
		Produto prod3 = new Produto(3, "Facao", 2500, "unidade");
		Produto prod4 = new Produto(3, "Facao", 2500, "unidade");
		
		loja.cadastrarProduto(prod1);
		loja.cadastrarProduto(prod2);
		loja.cadastrarProduto(prod3);
		loja.cadastrarProduto(prod4);
		
		cli1 = new Cliente(1, "Vinicius de Moraes", 4, true, true);
		cli2 = new Cliente(2, "Darcy Ribeiro", 4, true, false);
		cli3 = new Cliente(3, "Chico Moedas", 4, false, false);
		cli4 = new Cliente(4, "Jungkook", 4, true, true);
		
		loja.cadastrarCliente(cli1);
		loja.cadastrarCliente(cli2);
		loja.cadastrarCliente(cli3);
		loja.cadastrarCliente(cli4);
		
		LocalDateTime dataAtual = LocalDateTime.now();
		
		ProdutoVenda prodVenda1 = new ProdutoVenda(prod1, 4);
		ProdutoVenda prodVenda2 = new ProdutoVenda(prod2, 3);
		ProdutoVenda prodVenda3 = new ProdutoVenda(prod3, 2);
		ProdutoVenda prodVenda4 = new ProdutoVenda(prod4, 1);
		
		ArrayList<ProdutoVenda> prods1 = new ArrayList<ProdutoVenda>();
		ArrayList<ProdutoVenda> prods2 = new ArrayList<ProdutoVenda>();
		ArrayList<ProdutoVenda> prods3 = new ArrayList<ProdutoVenda>();
		ArrayList<ProdutoVenda> prods4 = new ArrayList<ProdutoVenda>();
		prods1.add(prodVenda1);
		prods1.add(prodVenda2);
		prods1.add(prodVenda3);
		prods1.add(prodVenda4);
		
		Venda venda1 = new Venda(1, prods1, cli1, dataAtual);
		Venda venda2 = new Venda(2, prods1, cli2, dataAtual.minusDays(15));
		Venda venda3 = new Venda(3, prods4, cli2, dataAtual.minusDays(31));
		Venda venda4 = new Venda(4, prods3, cli4, dataAtual.minusDays(31));
		Venda venda5 = new Venda(5, prods2, cli4, dataAtual.minusDays(32));
		
		loja.cadastrarVenda(venda1);
		loja.cadastrarVenda(venda2);
		loja.cadastrarVenda(venda3);
		loja.cadastrarVenda(venda4);
		loja.cadastrarVenda(venda5);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		
		Object[][] parametros = new Object[][] {
			{1, true},
			{2, true},
			{3, false},
			{4, false}
		};
		
		return Arrays.asList(parametros);
	}

    @Test
    public void verificacaoClienteEspecial() {
    	Cliente client = loja.getClienteById(idCliente);
        assertEquals(loja.ehEspecial(client), ehEspecial);
    }
}
