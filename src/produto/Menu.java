package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produto.controller.ProdutoController;
import produto.model.Produto;
import produto.model.ProdutoDigital;
import produto.model.ProdutoFisico;
import produto.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ProdutoController produtoController = new ProdutoController();
		int codigo, tipoProduto;
		double valor, peso;
		String nome, descricao, serial;

		ProdutoFisico pf1 = new ProdutoFisico(1, 50, "Conjunto de copos", "Conjunto de copos de vidro chanfrado", true,
				5);
		produtoController.cadastrarProduto(pf1);
		ProdutoFisico pf2 = new ProdutoFisico(2, 150, "Panela de Pressão", "Panela de Pressão anti-explosão", true, 7);
		produtoController.cadastrarProduto(pf2);
		ProdutoDigital pd1 = new ProdutoDigital(3, 100, "Ebook Receitas",
				"Ebook de receitas contendo mais de 100 receitas e dicas", true, "ABC-123");
		produtoController.cadastrarProduto(pd1);

		Scanner leia = new Scanner(System.in);

		int opcao;
		
        String menuArt = 
        "  ___          ___    ___    __  __   __  __   ___   ___    ___   ___          \n" +
        " | __|  ___   / __|  / _ \\  |  \\/  | |  \\/  | | __| | _ \\  / __| | __|         \n" +
        " | _|  |___| | (__  | (_) | | |\\/| | | |\\/| | | _|  |   / | (__  | _|          \n" +
        " |___|        \\___|  \\___/  |_|  |_| |_|  |_| |___| |_|_\\  \\___| |___|         \n" +
        "   ___    ___    ____  ___   _  _   _  _     _       _____   ___    ___   _  _ \n" +
        "  / __|  / _ \\  |_  / |_ _| | \\| | | || |   /_\\     |_   _| | __|  / __| | || |\n" +
        " | (__  | (_) |  / /   | |  | .` | | __ |  / _ \\      | |   | _|  | (__  | __ |\n" +
        "  \\___|  \\___/  /___| |___| |_|\\_| |_||_| /_/ \\_\\     |_|   |___|  \\___| |_||_|\n" +
        "                                                                               ";

		while (true) {

			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND
					+ "*******************************************************************************");
			System.out.println("                                                                               ");
			System.out.println(menuArt);
			System.out.println("                                                                               ");
			System.out.println("*******************************************************************************");
			System.out.println("                                                                               ");
			System.out.println("            1 - Cadastrar Produto                                              ");
			System.out.println("            2 - Listar Produtos             	                               ");
			System.out.println("            3 - Buscar Produtos pelo código                                    ");
			System.out.println("            4 - Editar Produto                                                 ");
			System.out.println("            5 - Excluir Produto                                                ");
			System.out.println("            9 - Sair                                                           ");
			System.out.println("                                                                               ");
			System.out.println("*******************************************************************************");
			System.out.println("Entre com a opção desejada:                                                    ");
			System.out.println("                                                                               ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\nE-commerce Agradece sua Visita!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Insira o codigo do Produto:");
				codigo = leia.nextInt();
				System.out.println("Insira o nome do Produto:");
				leia.skip("\\R?");
				nome = leia.nextLine();
				System.out.println("Insira a descrição do Produto:");
				leia.skip("\\R?");
				descricao = leia.nextLine();
				System.out.println("Insira o valor do Produto:");
				valor = leia.nextDouble();
				do {
					System.out.println("Insira o tipo do Produto(1 - Fisico ou 2 - Digital):");
					tipoProduto = leia.nextInt();
				} while (tipoProduto != 1 && tipoProduto != 2);
				if (tipoProduto == 1) {
					System.out.println("Insira o peso do Produto:");
					peso = leia.nextDouble();
					produtoController.cadastrarProduto(new ProdutoFisico(codigo, valor, nome, descricao, true, peso));
				}
				if (tipoProduto == 2) {
					System.out.println("Insira o serial do Produto:");
					leia.skip("\\R?");
					serial = leia.nextLine();
					produtoController
							.cadastrarProduto(new ProdutoDigital(codigo, valor, nome, descricao, true, serial));
				}

				keyPress();

				break;
			case 2:
				produtoController.listarTodosProdutos();
				keyPress();

				break;
			case 3:
				System.out.println("Insira o codigo do Produto:");
				codigo = leia.nextInt();
				produtoController.procurarPorCodigo(codigo);
				keyPress();

				break;
			case 4:
				System.out.println("Insira o codigo do Produto:");
				codigo = leia.nextInt();
				Produto produto = produtoController.buscarNaCollection(codigo);

				if (produto != null) {

					System.out.println("Insira o nome do Produto:");
					leia.skip("\\R?");
					nome = leia.nextLine();
					System.out.println("Insira a descrição do Produto:");
					leia.skip("\\R?");
					descricao = leia.nextLine();
					System.out.println("Insira o valor do Produto:");
					valor = leia.nextDouble();
					if (produto.getTipo() == 1) {
						System.out.println("Insira o peso do Produto:");
						peso = leia.nextDouble();
						produtoController.editar(new ProdutoFisico(codigo, valor, nome, descricao, true, peso));
					}
					if (produto.getTipo() == 2) {
						System.out.println("Insira o serial do Produto:");
						leia.skip("\\R?");
						serial = leia.nextLine();
						produtoController.editar(new ProdutoDigital(codigo, valor, nome, descricao, true, serial));
					}
				}else {
					System.out.println("Produto Não Encontrado");
				}
				keyPress();
				break;
			case 5:
				System.out.println("Insira o codigo do Produto:");
				codigo = leia.nextInt();
				produtoController.deletar(codigo);
				keyPress();

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();

				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}