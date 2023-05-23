package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

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

		marca = JOptionPane.showInputDialog("Digite a marca do veículo");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do veículo"));

		int op = Integer.parseInt(JOptionPane.showInputDialog("Digte a cor\n1 - Preto\n2 - Branco\n3 - Cinza"));
		if (op == 1) {
			cor = opcoes.PRETO.getDescricao();
		} else if (op == 2) {
			cor = opcoes.BRANCO.getDescricao();
		} else if (op == 3) {
			cor = opcoes.CINZA.getDescricao();
		}

		System.out.println(marca + " " + ano + " " + cor);

	}
	
	public String toString() {
		return "Marca: " + marca + ", ano: " + ano + ", cor: " + cor;		
	}
	
	
	

}
