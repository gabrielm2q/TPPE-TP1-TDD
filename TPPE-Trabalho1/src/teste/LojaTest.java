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
        loja.setClientes(new ArrayList<>());
        Cliente cliente1 = new Cliente(1, "Mariana", 2 , true, false);
        Cliente cliente2 = new Cliente(2, "Paulinho Ant�nio", 2 , true, true);

        int index1 = loja.cadastroCliente(cliente1);
        assertEquals("O �ndice do primeiro cliente deve ser 0", 0, index1);
        assertEquals("A lista deve conter o cliente1 ap�s cadastro", cliente1, loja.getClientes().get(index1));

        int index2 = loja.cadastroCliente(cliente2);
        assertEquals("O �ndice do segundo cliente deve ser 1", 1, index2);
        assertEquals("A lista deve conter o cliente2 ap�s cadastro", cliente2, loja.getClientes().get(index2));
    }
}
