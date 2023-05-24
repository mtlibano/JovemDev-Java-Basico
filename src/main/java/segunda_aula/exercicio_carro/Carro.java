package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Carro {

	String marca;
	int ano;
	String cor;

	public enum opcoes {
		PRETO("Preto"), BRANCO("Branco"), CINZA("Cinza");

		private final String descricao;

		opcoes(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return this.descricao;
		}
	}

	public void cadastrar() {
		marca = JOptionPane.showInputDialog("Digite a marca");

		int anoAtual = LocalDate.now().getYear();
		boolean validao = false;

		while (!validao) {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
				if (ano <= anoAtual) {
					validao = true;
				} else {
					JOptionPane.showMessageDialog(null, "Ano inválido");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ano inválido");
			}
		}

		String[] arrayCor = {opcoes.PRETO.getDescricao(), opcoes.BRANCO.getDescricao(), opcoes.CINZA.getDescricao()};
		cor = String.valueOf(JOptionPane.showInputDialog(null, "Selecione a COR", "Seleção de cor", JOptionPane.QUESTION_MESSAGE, null, arrayCor, arrayCor[0]));

		System.out.println(marca + " " + ano + " " + cor);
	}

	public String toString() {
		return "Marca: " + marca + ", ano: " + ano + ", cor: " + cor;
	}
}