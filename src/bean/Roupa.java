package bean;

public class Roupa {
	// values
	protected int codigo;
	protected double preco;
	
	// constructor
	public Roupa(int codigo, double preco) {
		this.codigo = codigo;
		this.preco = preco;
	}

	public Roupa() {
		super();
	}

	// methods
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Roupa [codigo=" + codigo + ", preco=" + preco + "]";
	}
}
