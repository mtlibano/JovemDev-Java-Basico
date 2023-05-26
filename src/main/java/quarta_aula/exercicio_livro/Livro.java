package quarta_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

	private String titulo;
	private double preco;
	private List<Autor> autores = new ArrayList<>();

	public void cadastrar(List<Autor> listaAutores) {

		do {
			titulo = JOptionPane.showInputDialog("Digite o título do livro").toLowerCase().trim();
		} while (!validarTitulo());

		do {
			try {
				preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro (R$)"));
			} catch (NumberFormatException e) {
			}
		} while (!validarPreco());

		int op = 0;
		int count = 0;
		Autor autor = new Autor();
		do {
			
			autor = Util.mostrarOpcoesAutores(listaAutores);
			if (autores.contains(autor)) {
				JOptionPane.showMessageDialog(null, "Autor já cadastrado no livro");
			} else {
				autores.add(autor);
				count++;
			}
			
			if (count < 4) {
				String[] opcoes = { "Sim", "Não" };
				op = JOptionPane.showOptionDialog(null, "Cadastrar novo AUTOR?", "Lista de Autores",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			} else {
				JOptionPane.showMessageDialog(null, "Número máximo de AUTORES por LIVRO(4)");
				break;
			}
		} while (op != 1);
	}

	public boolean validarTitulo() {
		if (!titulo.equalsIgnoreCase("")) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Título inválido");
		return false;
	}

	public boolean validarPreco() {
		if (preco > 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Preço inválido");
		return false;
	}

	public String toString() {
		return "Título: " + titulo + " - R$ " + preco;
	}

	public String listAutores() {
		String print = toString() + "\n";
		for (Autor autor : autores) {
			print += autor.toString() + "\n";
		}
		return print;
	}

	public boolean isAutor(String nomeAutor) {
		boolean verificar = false;
		for (Autor autor : autores) {
			if (nomeAutor.equalsIgnoreCase(autor.getNome())) {
				verificar = true;
			}
		}
		return verificar;
	}

	public boolean isAutorCrianca() {
		boolean verificar = false;
		for (Autor autor : autores) {
			if (autor.getIdade() <= 12) {
				verificar = true;
			}
		}
		return verificar;
	}

	public boolean isAutorSexo(String sexo) {
		boolean verificar = true;
		for (Autor autor : autores) {
			if (!autor.getSexo().equalsIgnoreCase(sexo)) {
				verificar = false;
				break;
			}
		}
		return verificar;
	}
}