package bean;

public class Camiseta extends Roupa {
	// values
	protected String tamanho;
	protected String cor;
	
	// constructor
	public Camiseta(int codigo, double preco, String tamanho, String cor) {
		super(codigo, preco);
		this.tamanho = tamanho;
		this.cor = cor;
	}

	public Camiseta() {
		
	}
	
	// methods
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Camiseta [tamanho=" + tamanho + ", cor=" + cor + "]";
	}
	
}
