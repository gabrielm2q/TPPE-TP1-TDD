package app;

public class Cliente {
    private int id;
    private String nome;
    private boolean ehPrime; // 1 padrao, 2 especial, 3 prime
    private int regiao; // 0 - DF; 1 - Centro-Oeste; 2 - Nordeste; 3 - Norte; 4 - Sudeste; 5 - Sul;
    private boolean ehCapital;
    private int saldoCashback = 0; // valor em centavos   
    
    /// buscar na de vendas as compras do cliente pra determinar o tipo

    public Cliente(int id, String nome, int regiao, boolean ehCapital, boolean ehPrime) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
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

    public void setEhPrime(boolean ehPrime) {
        this.ehPrime = ehPrime;
    }
    
    public int getRegiao() {
		return regiao;
	}
    
    public boolean getEhCapital() {
		return ehCapital;
	}

    public int getSaldoCashback() {
        return saldoCashback;
    }
    
    public void setSaldoCashback(int saldoCashback) {
    	this.saldoCashback = saldoCashback;
    }

    public int adicionarCashback(int valor) {
        if ( valor >= 0 )  this.saldoCashback += valor;
        return this.saldoCashback;
    }
}

