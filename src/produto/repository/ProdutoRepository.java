package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {
	
	public void procurarPorCodigo(int codigo);
	public void listarTodosProdutos();
	public void cadastrarProduto(Produto produto);
	public void editar(Produto prodduto);
	public void deletar(int codigo);

}
