package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import entities.Funcionario;
import entities.Produto;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ArrayList<Produto> produtos = new ArrayList<>();
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		int opcao = -1;

		while (opcao != 0) {
			System.out.println("=-=-=Menu de estoque=-=-=");
			System.out.println("1 - Cadastrar funcionario");
			System.out.println("2 - Cadastrar produto");
			System.out.println("3 - Atualizar produto");
			System.out.println("4 - Remover produto");
			System.out.println("5 - Relatorio");

			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				cadastrarFuncionario(funcionarios, sc);
				break;
			case 2:
				cadastrarProduto(produtos, funcionarios, sc);
				break;
			case 3:
				atualizarProduto(produtos, sc);
				break;
			case 4:
				removerProduto(produtos, sc);
				break;
			case 5:
				exibirProduto(produtos, funcionarios, sc);
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção invalida!!");
				break;
			}
			System.out.println();
		}

		sc.close();

	}

	public static void cadastrarFuncionario(ArrayList<Funcionario> funcionarios, Scanner sc) {
		Random random = new Random();

		System.out.println();
		System.out.println("=-=-=Cadastrar Funcionario=-=-=");

		int id = random.nextInt(1000);
		System.out.println("ID gerado automaticamente: " + id);

		// Verificar se o ID é igual
		for (Funcionario f : funcionarios) {
			if (f.getId().equals(id)) {
				int novoId = random.nextInt(1500);
				id = novoId;
				System.out.println("ID informado anteriormente já está sendo utilizado");
				System.out.println("Seu novo ID é: " + id);
			}
		}

		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();

		// Estanciar
		Funcionario funcionario = new Funcionario(id, nome);

		// Add
		funcionarios.add(funcionario);

		System.out.println("Funcionario cadastrado com sucesso!!!");
	}

	public static void cadastrarProduto(ArrayList<Produto> produtos, ArrayList<Funcionario> funcionarios, Scanner sc)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println();
		System.out.println("=-=-=Cadastrar Produto=-=-=");

		// Só pode cadastrar produto se tiver funcionario
		if (funcionarios.isEmpty()) {
			System.out.println("Funcionarios não cadastrado");
			return;
		}

		System.out.print("Codigo: ");
		int codigo = sc.nextInt();

		// Verificar se tem codigo igual
		for (Produto p : produtos) {
			if (p.getCodigo().equals(codigo)) {
				System.out.println(
						"Código já utilizado pelo produto com código " + p.getCodigo() + " e nome " + p.getNome());
				return;
			}
		}

		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();

		System.out.print("Preço da unidade: R$");
		double precoUnidade = sc.nextDouble();
		if (precoUnidade <= 0) {
			System.out.println("Informe um valor válido para o preço, maior que 0!!!");
			return;
		}

		System.out.print("Quantidade: ");
		int quantidade = sc.nextInt();
		if (quantidade <= 0) {
			System.out.println("Informe um valor válido para a quantidade, maior que 0!!!");
			return;
		}

		double valorTotal = quantidade * precoUnidade;

		// Tratamento de erro de data invalida
		Date validade = null;
		boolean dataValida = false;
		while (!dataValida) {
			try {
				System.out.print("Data de Validade (dd/mm/yyyy): ");
				validade = sdf.parse(sc.next());
				dataValida = true;
			} catch (ParseException e) {
				System.out.println("Data Invalida!! Digite novamente.");
			}
		}

		// Obter a data atual
		Date dataAtual = new Date();

		// Comparando as datas
		if (validade.compareTo(dataAtual) == 0 && validade.compareTo(dataAtual) > 0) {
			System.out.println("Produto com data válida para consumo.");
		} else if (validade.compareTo(dataAtual) < 0) {
			System.out.println("Produto vencido, a data informada é anterior à data atual.");
			return;
		}

		System.out.println("Disponível:");
		// Nomes dos funcionarios já cadastrados
		for (Funcionario f : funcionarios) {
			System.out.println("-> " + f.getNome());
		}

		System.out.print("Informe o nome do funcionario que está realizando o cadastro: ");
		sc.nextLine();
		String nomeFuncionario = sc.nextLine();

		// Verificar se existe um funcionário com esse nome
		Funcionario funcionarioResponsavel = null;
		for (Funcionario f : funcionarios) {
			if (f.getNome().equalsIgnoreCase(nomeFuncionario)) {
				funcionarioResponsavel = f;
				break;
			}
		}

		if (funcionarioResponsavel == null) {
			System.out.println("Funcionário não encontrado.");
			return;
		}

		// Estanciar
		Produto produto = new Produto(codigo, nome, precoUnidade, quantidade, valorTotal, validade,
				funcionarioResponsavel);

		// Add
		produtos.add(produto);
		System.out.println("Produto cadastrado no estoque com sucesso!!!");

	}

	public static void atualizarProduto(ArrayList<Produto> produtos, Scanner sc) {
		System.out.println();
		System.out.println("=-=-=Atualizar Produto=-=-=");

		// Verificar se tem produto cadastrado
		if (produtos.isEmpty()) {
			System.out.println("Não possui produto cadastrado");
			return;
		}

		System.out.print("Informe o código do produto: ");
		int codigo = sc.nextInt();
		for (Produto p : produtos) {
			if (p.getCodigo().equals(codigo)) {
				System.out.print("Preço: ");
				double novoPreco = sc.nextDouble();
				p.setPrecoUnidade(novoPreco); // Atualizando os valores

				System.out.print("Quantidade: ");
				int novaQuantidade = sc.nextInt();
				p.setQuantidade(novaQuantidade); // Atualizando os valores

				double novoValorTotal = novoPreco * novaQuantidade;
				p.setValorTotal(novoValorTotal);
				
				System.out.println("Produto atualizado com sucesso!!");
			} else {
				System.out.println("Codigo informado é invalido!!!");
				return;
			}
		}
	}

	public static void removerProduto(ArrayList<Produto> produtos, Scanner sc) {
		System.out.println();
		System.out.println("=-=-=Remover Produto=-=-=");

		// Verificar se tem produto cadastrado
		if (produtos.isEmpty()) {
			System.out.println("Não possui produto cadastrado");
			return;
		}

		System.out.print("Informe o código do produto: ");
		int codigo = sc.nextInt();
		for (Produto p : produtos) {
			if (p.getCodigo().equals(codigo)) {
				System.out.print("Deseja remover o " + p.getNome() + " de codigo " + p.getCodigo() + "?");
				char resp = sc.next().charAt(0);
				if (resp == 's' || resp == 'S') {
					produtos.remove(p);
					System.out.println("Produto removido com sucesso!");
				} else {
					System.out.println("Voltado para o menu!!");
					return;
				}
				// sair do loop após remover o produto
				return;
			} else {
				System.out.println("Codigo do produto informado não encontrado!!!");
				return;
			}
		}
	}

	public static void exibirProduto(ArrayList<Produto> produtos, ArrayList<Funcionario> funcionarios, Scanner sc) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (produtos.isEmpty() && funcionarios.isEmpty()) {
			System.out.println("Não possui produtos cadastrados e funcionarios");
			return;
		} else {
			for (Produto p : produtos) {
			    System.out.println();
			    System.out.println("=-=-=-Produto-=-=-=");
			    System.out.println(p.toString());
			}

			for (Funcionario f : funcionarios) {
				System.out.println();
				System.out.println("=-=-=-Funcionario-=-=-=");
				System.out.println(f.toString());
			
			}
		}

		System.out.println();
		System.out.println("Produtos cadastrados: " + produtos.size());
		System.out.println("Funcionarios cadastrados: " + funcionarios.size());
	}

}
