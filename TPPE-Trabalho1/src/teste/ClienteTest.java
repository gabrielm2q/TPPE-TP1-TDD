package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Cliente;

public class ClienteTest {

	@Test
    public void cadastrarCliente() {
		// cadastrar da capital, nao prime
        Cliente cliente = new Cliente(1, "Mariana", 2 , true, false);
        assertEquals(1, cliente.getId()); 
        assertEquals("Mariana", cliente.getNome());
        assertEquals(2, cliente.getEstado()); 
        assertTrue(cliente.getEhCapital()); 
        assertFalse(cliente.getEhPrime());
    }
	
	@Test
    public void cadastrarPrime() {
		// cadastrar cliente prime, da capital
        Cliente cliente = new Cliente(1, "Paulinho Ant�nio", 2 , true, true);
        assertEquals(1, cliente.getId()); 
        assertEquals("Paulinho Ant�nio", cliente.getNome());
        assertEquals(2, cliente.getEstado()); 
        assertTrue(cliente.getEhCapital()); 
        assertTrue(cliente.getEhPrime());
    }
	
	@Test
    public void cadastrarNaoCapital() {
		// cadastrar cliente do interior e n�o prime
        Cliente cliente = new Cliente(1, "Paulinho Ant�nio", 2 , false, false);
        assertEquals(1, cliente.getId()); 
        assertEquals("Paulinho Ant�nio", cliente.getNome());
        assertEquals(2, cliente.getEstado()); 
        assertFalse(cliente.getEhCapital()); 
        assertFalse(cliente.getEhPrime());
    }

}
