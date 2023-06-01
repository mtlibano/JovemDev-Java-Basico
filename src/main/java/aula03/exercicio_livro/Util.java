package aula03.exercicio_livro;

import javax.swing.JOptionPane;
import java.util.List;

public class Util {

	public static int menuPrincipal() {
		String menu = "1 - Cadatrar Autor\n" + "2 - Cadastrar Livro\n" + "3 - Listar todos os livros\n"
				+ "4 - Pesquisar por autor\n" + "5 - Pesquisar por valor\n" + "6 - Listar autores menores de 12 anos\n"
				+ "7 - Listar livros pelo sexo autor\n\n" + "8 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public static void cadastrarAutor(List<Autor> listaAutor) {
		Autor autor = new Autor();
		autor.cadastrar();
		listaAutor.add(autor);
	}

	public static Autor mostrarOpcoesAutores(List<Autor> listaAutor) {
		String menu = "Escolha um autor\n";
		int pos = 1;
		for (Autor autor : listaAutor) {
			menu += pos + " - " + autor.getNome() + "\n";
			pos++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return listaAutor.get(op - 1);
	}

	public static void cadastrarLivro(List<Livro> livros, List<Autor> autores) {
		if (!autores.isEmpty()) {
			Livro l = new Livro();
			l.cadastrar(autores);
			livros.add(l);
		} else {
			JOptionPane.showMessageDialog(null, "Não há autores cadastrados!\n\nPara cadastrar o LIVRO é necessário ao menos um AUTOR");
		}		
	}

	public static String listarTodosLivros(List<Livro> livros) {
		String print = "- LIVROS CADASTRADOS -\n\n";
		for (Livro livro : livros) {
			print += livro.listAutores() + "\n";
		}
		return print;
	}

	public static String buscarPorAutor(List<Livro> livros, List<Autor> autores) {
		Autor a = new Autor();
		a = Util.mostrarOpcoesAutores(autores);
		String print = "Autor: " + a.getNome() + "\n\nLivros:\n";

		for (Livro livro : livros) {
			if (livro.isAutor(a.getNome())) {
				print += livro.getTitulo() + "\n";
			}
		}
		return print;
	}

	public static String buscarPorValor(List<Livro> livros) {
		double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo"));
		double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo"));
		String print = "- Livros na faixa de preço -\nR$ " + valorMinimo + " até R$" + valorMaximo + "\n\n";

		for (Livro livro : livros) {
			if (livro.getPreco() >= valorMinimo && livro.getPreco() <= valorMaximo) {
				print += livro.getTitulo() + "\n";
			}
		}
		return print;
	}

	public static String listarLivrosAutoresCriancas(List<Livro> livros) {
		String print = "- Livros com autores crianças -\n\n";
		for (Livro livro : livros) {
			if (livro.isAutorCrianca()) {
				print += livro.getTitulo() + "\n";
			}
		}
		return print;
	}

	public static String listarLivrosPorSexo(List<Livro> livros) {
		String selectSexo = String.valueOf(JOptionPane.showInputDialog(null, "Selecione o sexo", "Seleção de sexo",
				JOptionPane.QUESTION_MESSAGE, null, OpcoesSexo.values(), OpcoesSexo.values()));
		String print = "- Livros com autores do gênero " + selectSexo + " -\n\n";

		for (Livro livro : livros) {
			if (livro.isAutorSexo(selectSexo)) {
				print += livro.getTitulo() + "\n";
			}
		}
		return print;
	}
}