package bean;

public class Cliente {
	// values
	private String nome;

	// constructor
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}
	
	public Cliente() {
		super();
	}

	// methods
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}
}
