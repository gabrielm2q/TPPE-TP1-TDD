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
import app.Cliente;

@RunWith(Parameterized.class)
public class TesteLojaCadastroClientes {
	
	private ArrayList<Cliente> clientes;
	
	public TesteLojaCadastroClientes (ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		
		Cliente cli1 = new Cliente(1, "Chico Buarque de Hollanda", 4, true, true);
		Cliente cli2 = new Cliente(2, "Tom Jobim", 4, true, false);
		Cliente cli3 = new Cliente(3, "Vinicius de Moraes", 4, false, false);
		
		ArrayList<Cliente> clientes1 = new ArrayList<Cliente>();
		ArrayList<Cliente> clientes2 = new ArrayList<Cliente>();
		ArrayList<Cliente> clientes3 = new ArrayList<Cliente>();
		
		clientes1.add(cli1);
		clientes1.add(cli2);
		clientes1.add(cli3);
		
		clientes2.add(cli1);
		
		Object[][] parametros = new Object[][] {
			{clientes1},
			{clientes2},
			{clientes3}
		};
		
		return Arrays.asList(parametros);
	}

    @Test
    public void cadastroClientes() {
    	Loja loja = new Loja();
    	
    	for ( Cliente cli : clientes ) {
			loja.cadastrarCliente(cli);
		}
    	
        ArrayList<Cliente> clis = loja.getClientes();

        assertEquals(clientes, clis);
    }
}
