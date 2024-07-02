package suites;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProdutoVendaTests.class, ClienteTests.class, VendaTests.class})
public class AllTests {
	
}
