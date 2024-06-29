package app;

import java.util.ArrayList;

public class Loja {
	private ArrayList<Cliente> clientes;
	// lista de compras -> pra ver se eh especial

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public int cadastroCliente(Cliente c) {
		clientes.add(c);
		return clientes.lastIndexOf(c);
	}
}
