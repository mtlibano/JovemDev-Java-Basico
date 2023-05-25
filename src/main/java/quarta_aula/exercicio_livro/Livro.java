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

	public void cadastrar() {
		titulo = JOptionPane.showInputDialog("Digite o título do livro").toLowerCase();
		preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro (R$)"));	
	}

}
