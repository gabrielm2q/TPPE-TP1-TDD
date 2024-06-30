package teste;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

import app.Loja;
import app.Cliente;

public class LojaTest {

    @Test
    public void cadastroDoisClientes() {
    	Loja loja = new Loja();
    	
    	loja.cadastrarCliente(1, "Mariana", 2 , true, false);
    	loja.cadastrarCliente(2, "Paulinho Antônio", 2 , true, true);
        
        Cliente cliente1 = loja.getClientes().get(0);
        Cliente cliente2 = loja.getClientes().get(1);

        assertEquals("A lista deve conter o cliente1 após cadastro", 1, cliente1.getId());
        assertEquals("A lista deve conter o cliente2 após cadastro", 2, cliente2.getId());
        assertEquals("O nome do cliente1 deve ser Mariana", "Mariana", cliente1.getNome());
        assertEquals("O nome do cliente2 deve ser Paulinho Antônio", "Paulinho Antônio", cliente2.getNome());
    
    }
}
