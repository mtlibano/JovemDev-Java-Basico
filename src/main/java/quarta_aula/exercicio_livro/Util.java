package quarta_aula.exercicio_livro;

import javax.swing.JOptionPane;
import java.util.List;

public class Util {
	
	public static int menuPrincipal() {
		String menu = "1 - Cadatrar Autor\n"
				+ "2 - Cadastrar Livro\n"
				+ "3 - Listar todos os livros\n"
				+ "4 - Pesquisar por autor\n"
				+ "5 - Pesquisar por valor\n"
				+ "6 - Listar autores menores de 12 anos\n"
				+ "7 - Listar livros pelo sexo autor\n\n"
				+ "8 - Sair";
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
			pos ++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return listaAutor.get(op-1);
	}
	
	public static Autor listarAutores(List<Autor> autores) {
		
		
		return null;

	}
	
	public static void cadastrarLivro(List<Livro> livros, List<Autor> autores) {
		Livro livro = new Livro();
		
		livro.setTitulo(JOptionPane.showInputDialog("Digite o título do livro").toLowerCase());
		livro.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço (R$)")));
		
		int op = 0;
		do {
			Autor a = new Autor();
			a = Util.mostrarOpcoesAutores(autores);
			livro.add(a);
			
            String[] opcoes = {"Sim", "Não"};
            op = JOptionPane.showOptionDialog(null,"Cadastrar novo AUTOR?","Lista de Autores", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        } while (op != 1);

	}
	

}
