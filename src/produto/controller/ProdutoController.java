package produto.controller;

import java.util.ArrayList;

import produto.model.Produto;
import produto.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	@Override
	public void procurarPorCodigo(int codigo) {
		Produto produto = buscarNaCollection(codigo);
		
		if(produto==null) {
			System.out.println("Produto "+ codigo + " não encontrado");
			return;
		}
		
		produto.DetalharProduto();
		
	}

	@Override
	public void listarTodosProdutos() {
		for (var produto : produtos) {
			produto.DetalharProduto();
		}
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		produtos.add(produto);
		System.out.println("\nProduto Inserido com Sucesso");
	}

	@Override
	public void editar(Produto produto) {
		var localizarProduto = buscarNaCollection(produto.getCodigo());
		
		if(localizarProduto==null) {
			System.out.println("Produto "+ produto.getCodigo() + " não encontrado");
			return;
		}
		
		produtos.set(produtos.indexOf(localizarProduto),produto);

	}

	@Override
	public void deletar(int codigo) {
		Produto produto = buscarNaCollection(codigo);
		
		if(produto==null) {
			System.out.println("Produto "+ codigo + " não encontrado");
			return;
		}
		
		if(produtos.remove(produto)==true) {
			System.out.println("Produto Removido Com Sucesso!");
		}

	}
	
	public Produto buscarNaCollection(int codigo) {
		for(var produto:produtos) {
			if(produto.getCodigo()==codigo) {
				return produto;
			}
		}
		return null;
	}

}
