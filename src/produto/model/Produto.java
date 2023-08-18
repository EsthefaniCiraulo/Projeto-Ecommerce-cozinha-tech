package produto.model;

public abstract class Produto {

	private int codigo;
	private double valor;
	private String nome;
	private String descricao;
	private Boolean ativa;
	private int tipo;


	public Produto(int codigo, double valor, String nome, String descricao, Boolean ativa, int tipo) {
		this.codigo = codigo;
		this.valor = valor;
		this.nome = nome;
		this.descricao = descricao;
		this.ativa = ativa;
		this.setTipo(tipo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	
	}
	
	public String getValorFormatado() {
		return "R$"+this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	private void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}


	public void ExcluirProduto() {
		setAtiva(false);
	}

	public void DetalharProduto() {
		System.out.println("\n\n***********************************************************");
		System.out.println("Detalhe do Produto:");
		System.out.println("***********************************************************");
		System.out.println("Código: " + this.codigo);
		System.out.println("Nome: " + this.nome);
		System.out.println("Descrição: " + this.descricao);
		System.out.println("Valor: " + this.valor);
		System.out.println("Ativo: " + this.ativa);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
