package terceira_aula.exercicio_time;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter @Setter
public class Time {

    private String nome;
    private ArrayList<Jogador> jogadores;

    void cadastrarTime() {
        nome = JOptionPane.showInputDialog("Digite o NOME do TIME");
        System.out.println("Time: " + nome);
        this.jogadores = new ArrayList<>();

        int op = 0;
        Jogador j = new Jogador();
        do {
            j.cadastrarJogador();
            jogadores.add(j);
            System.out.println(j.toString());
            String[] opcoes = {"Sim", "Não"};
            op = JOptionPane.showOptionDialog(null,"Cadastrar novo JOGADOR?","Jogador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        } while (op != 1);
    }

    boolean isNomeTime(String nomeTime) {
        return getNome().equalsIgnoreCase(nomeTime);
    }

}
