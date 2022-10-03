package bean;

public class Vestido extends Roupa {
	// values
	protected String estampa;

	// constructor
	public Vestido(int codigo, double preco, String estampa) {
		super(codigo, preco);
		this.estampa = estampa;
	}

	public Vestido() {
		
	}

	// methods
	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

	@Override
	public String toString() {
		return "Vestido [estampa=" + estampa + "]";
	}
}
