package suites;

import org.junit.runners.Suite;

import teste.TesteLojaCadastroClientes;
import teste.TesteLojaCadastroProdutos;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({TesteLojaCadastroProdutos.class, TesteLojaCadastroClientes.class})
public class LojaTests {
	
}
