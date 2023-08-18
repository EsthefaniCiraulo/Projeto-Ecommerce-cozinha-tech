package produto.model;

public class ProdutoFisico extends Produto {
	
	private double peso;

	public ProdutoFisico(int codigo, double valor, String nome, String descricao, Boolean ativa,double peso) {
		super(codigo, valor, nome, descricao, ativa,1);
		// TODO Auto-generated constructor stub
		this.setPeso(peso);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getPesoFormatado() {
		return this.peso+"kg";
	}
	
	@Override
	public void DetalharProduto() {
		System.out.println("\n\n***********************************************************");
		System.out.println("Detalhe do Produto Fisico:");
		System.out.println("***********************************************************");
		System.out.println("Código: " + this.getCodigo());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Descrição: " + this.getDescricao());
		System.out.println("Valor: " + this.getValorFormatado());
		//System.out.println("Ativo: " + this.getAtiva());
		System.out.println("Peso: " + this.getPesoFormatado());
	
	}

}
