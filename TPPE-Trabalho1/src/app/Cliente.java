package app;

public class Cliente {
    private int id;
    private String nome;
    private boolean ehPrime; // 1 padrao, 2 especial, 3 prime
    private int estado;
    private boolean ehCapital;
    private int saldoCashback = 0; // valor em centavos   
    
    /// buscar na de vendas as compras do cliente pra determinar o tipo

    public Cliente(int id, String nome, int estado, boolean ehCapital, boolean ehPrime) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.ehCapital = ehCapital;
        this.ehPrime = ehPrime;
    }

	public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean getEhPrime() {
        return ehPrime;
    }

    public int getEstado() {
		return estado;
	}
    
    public boolean getEhCapital() {
		return ehCapital;
	}


    public double getSaldoCashback() {
        return saldoCashback;
    }

    public void adicionarCashback(int valor) {
        saldoCashback += valor;
    }
}

