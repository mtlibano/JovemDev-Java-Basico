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
		nome = JOptionPane.showInputDialog("Informe o nome autor");
		sexo = JOptionPane.showInputDialog("Digite o sexo autor");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade autor"));
	}
}