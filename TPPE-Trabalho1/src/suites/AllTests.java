package suites;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProdutoVendaTests.class, ClienteTests.class, VendaTests.class, ProdutoTests.class, LojaTests.class})
public class AllTests {
	
}
