package teste;

import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.Collection;
import java.util.Arrays;
import org.junit.Test;

import app.Cliente;

@RunWith(Parameterized.class)
public class TesteClienteAdicionaCashback {

	
	private Cliente cliente;
	private int saldoCashback;
	private int valorAdicionado;
	
	public TesteClienteAdicionaCashback ( Cliente cliente, int valorAdicionado, int saldoCashback ) {
		this.cliente = cliente;
		this.saldoCashback = saldoCashback;
		this.valorAdicionado = valorAdicionado;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		String nome1 = "Andre", nome2 = "Debora", nome3 = "Mariana", nome4 = "Mariano";
		Cliente cliente1 = new Cliente(1, nome1, 1, true, false);
		Cliente cliente2 = new Cliente(2, nome2, 2, true, true);
		Cliente cliente3 = new Cliente(3, nome3, 2, true, true);
		Cliente cliente4 = new Cliente(4, nome4, 1, true, true);
		
		cliente2.setSaldoCashback(1234);

		Object[][] parametros = new Object[][] {
			{cliente1, 4567, 4567},
			{cliente2, 6789, 8023},
			{cliente3, 0, 0},
			{cliente4, -1, 0}
		};
		
		return Arrays.asList(parametros);
	}
	
    @Test
    public void incrementarCashback() {
        assertEquals(cliente.adicionarCashback(valorAdicionado), saldoCashback);
    }
}
