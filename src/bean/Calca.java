package bean;

public class Calca extends Roupa{
	// values
	protected int numero;

	// constructor
	public Calca(int codigo, double preco, int numero) {
		super(codigo, preco);
		this.numero = numero;
	}

	public Calca() {
		
	}

	// methods
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Calca [numero=" + numero + "]";
	}
}
