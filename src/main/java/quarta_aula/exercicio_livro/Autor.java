package quarta_aula.exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {

	private String nome;
	private String sexo;
	private int idade;

	public void cadastrar() {

		do {
			nome = JOptionPane.showInputDialog("Informe o nome autor").trim();
		} while (!validarNome());

		sexo = String.valueOf(JOptionPane.showInputDialog(null, "Selecione o sexo", "Seleção de sexo",
				JOptionPane.QUESTION_MESSAGE, null, OpcoesSexo.values(), OpcoesSexo.values())).toLowerCase();

		do {
			try {
				idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade autor"));
			} catch (NumberFormatException e) {}
		} while (!validarIdade());
	}

	private boolean validarNome() {
		String[] palavras = nome.split(" ");
		if (palavras.length == 2) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Nome autor deve ser composto\n(Nome + Sobrenome)");
			return false;
		}
	}

	private boolean validarIdade() {
		if (idade > 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Idade inválida");
		return false;
	}

	public String toString() {
		return "Autor: " + nome + ", " + sexo + ", " + idade + " anos";
	}
}