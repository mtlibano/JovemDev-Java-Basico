package quarta_aula.exercicio_livro;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Autor {
	
	private String nome;
	private String sexo;
	private int idade;
	
	public void cadastrar() {
		nome = JOptionPane.showInputDialog("Informe o nome autor").trim();
		while (!validarNome(nome)) {
			JOptionPane.showMessageDialog(null, "Nome autor deve ser composto");
			nome = JOptionPane.showInputDialog("Informe o nome autor").trim() ;
		}

		sexo = String.valueOf(JOptionPane.showInputDialog(null,"Selecione o sexo", "Seleção de sexo", JOptionPane.QUESTION_MESSAGE, null, OpcoesSexo.values(), OpcoesSexo.values()));

		boolean validar = false;
		while (!validar) {
			try {
				idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade autor"));
				if (idade > 0) {
					validar = true;
				} else {
					JOptionPane.showMessageDialog(null, "Dado inválido");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Dado inválido");
			}
		}
	}

	private boolean validarNome(String nome) {
		String[] palavras = nome.split(" ");
		return palavras.length == 2;
	}

	public String toString() {
		return "Autor: " + nome + ", sexo: " + sexo + ", idade: " + idade;
	}
}