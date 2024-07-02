package suites;

import org.junit.runners.Suite;

import teste.TesteGetProdutoVendaValorParcial;
import teste.TesteGetProdutoVendaQuantidade;
import teste.TesteGetProdutoVenda;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({TesteGetProdutoVenda.class, TesteGetProdutoVendaQuantidade.class, TesteGetProdutoVendaValorParcial.class})
public class ProdutoVendaTests {
	
}
