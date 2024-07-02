package suites;

import org.junit.runners.Suite;

import teste.TesteCadastroCliente;
import teste.TesteClienteAdicionaCashback;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({TesteClienteAdicionaCashback.class, TesteCadastroCliente.class})
public class ClienteTests {
	
}
