package terceira_aula.exercicio_time;

import lombok.Getter;
import lombok.Setter;

import javax.swing.JOptionPane;

@Getter @Setter
public class Jogador {

    private String nome;
    private int numCamisa;
    private int qtdGols;

    void cadastrarJogador() {
        this.nome = JOptionPane.showInputDialog("Informe o NOME do jogador");
        this.numCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da CAMISA"));
        this.qtdGols = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de GOLS"));
    }

    public String toString() {
        return "Nome: " + getNome()
                + ", número camisa: " + getNumCamisa()
                + ", qtd gols: " + getQtdGols()
                + "\n========================";
    }
}
