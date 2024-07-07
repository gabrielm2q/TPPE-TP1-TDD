package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import teste.TesteGetVenda;
import teste.TesteVendaCalculaCashback;
import teste.TesteVendaCalculaFrete;
import teste.TesteVendaCalculaValorFinal;
import teste.TesteVendaCalculaValorTotal;
import teste.TesteVendaVerificaCartaoCredito;


@RunWith(Suite.class)
@Suite.SuiteClasses({TesteGetVenda.class, TesteVendaCalculaFrete.class, TesteVendaVerificaCartaoCredito.class, TesteVendaCalculaValorTotal.class, TesteVendaCalculaValorFinal.class, TesteVendaCalculaCashback.class})
public class VendaTests {
	
}
