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
public class TesteCadastroCliente {

	
	private Cliente cliente;
	private int id;
	private String nome;
	private int regiao;
	private boolean ehCapital;
	private boolean ehPrime;
	
	public TesteCadastroCliente ( Cliente cliente, int id, String nome, int regiao, boolean ehCapital, boolean ehPrime ) {
		this.cliente = cliente;
		this.id = id;
		this.nome = nome;
		this.regiao = regiao;
		this.ehCapital = ehCapital;
		this.ehPrime = ehPrime;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		int id1 = 1, id2 = 2, id3 = 3, id4 = 4;
		String nome1 = "Andre", nome2 = "Debora", nome3 = "Mariana", nome4 = "Mariano"; 
		int regiao1 = 0, regiao2 = 2;
		Cliente cliente1 = new Cliente(id1, nome1, regiao1, true, false);
		Cliente cliente2 = new Cliente(id2, nome2, regiao2, true, true);
		Cliente cliente3 = new Cliente(id3, nome3, regiao2, false, false);
		Cliente cliente4 = new Cliente(id4, nome4, regiao1, false, true);
		
		Object[][] parametros = new Object[][] {
			{cliente1, id1, nome1, regiao1, true, false},
			{cliente2, id2, nome2, regiao2, true, true},
			{cliente3, id3, nome3, regiao2, false, false},
			{cliente4, id4, nome4, regiao1, false, true}
		};
		
		return Arrays.asList(parametros);
	}
	
    @Test
    public void cadastrarCliente() {
        assertEquals(cliente.getId(), id);
        assertEquals(cliente.getNome(), nome);
        assertEquals(cliente.getRegiao(), regiao);
        assertEquals(cliente.getEhCapital(), ehCapital);
        assertEquals(cliente.getEhPrime(), ehPrime);
    }
}
