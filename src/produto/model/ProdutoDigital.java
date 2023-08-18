package produto.model;

public class ProdutoDigital extends Produto {
	
	private String serial;

	public ProdutoDigital(int codigo, double valor, String nome, String descricao, Boolean ativa, String serial) {
		super(codigo, valor, nome, descricao, ativa,2);
		// TODO Auto-generated constructor stub

	this.setSerial(serial);
	
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	@Override
	public void DetalharProduto() {
		System.out.println("\n\n***********************************************************");
		System.out.println("Detalhe do Produto Digital:");
		System.out.println("***********************************************************");
		System.out.println("Código: " + this.getCodigo());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Descrição: " + this.getDescricao());
		System.out.println("Valor: " + this.getValorFormatado());
		//System.out.println("Ativo: " + this.getAtiva());
		System.out.println("serial: " + this.serial);
	
	}
	

	
}
 