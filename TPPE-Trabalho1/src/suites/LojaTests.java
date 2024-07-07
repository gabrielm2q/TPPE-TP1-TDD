package suites;

import org.junit.runners.Suite;

import teste.TesteLojaCadastroClientes;
import teste.TesteLojaCadastroProdutos;
import teste.TesteLojaValidacaoClienteEspecial;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({TesteLojaCadastroProdutos.class, TesteLojaCadastroClientes.class, TesteLojaValidacaoClienteEspecial.class})
public class LojaTests {
	
}
