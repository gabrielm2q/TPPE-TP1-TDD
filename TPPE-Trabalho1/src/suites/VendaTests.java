package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import teste.TesteGetVenda;
import teste.TesteVendaCalculaFrete;
import teste.TesteVendaVerificaCartaoCredito;


@RunWith(Suite.class)
@Suite.SuiteClasses({TesteGetVenda.class, TesteVendaCalculaFrete.class, TesteVendaVerificaCartaoCredito.class})
public class VendaTests {
	
}
