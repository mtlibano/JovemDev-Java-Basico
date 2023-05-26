package terceira_aula.exercicio_time;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter @Setter
public class Time {

    private String nome;
    private ArrayList<Jogador> jogadores;

    public void cadastrar() {
        nome = JOptionPane.showInputDialog("Digite o NOME do TIME");

        this.jogadores = new ArrayList<>();

        int op = 0;
        Jogador j = new Jogador();
        do {
            j.cadastrar();
            jogadores.add(j);

            String[] opcoes = {"Sim", "Não"};
            op = JOptionPane.showOptionDialog(null,"Cadastrar novo JOGADOR?","Jogador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        } while (op != 1);
    }
    
    public String listJogadores() {
    	String print = "Time: " + nome + "\n\n";
    	for (Jogador jogador : jogadores) {
    		print += jogador.toString();
		}
    	return print;
    }
    
    public Jogador getArtilheiro() {
    	Jogador artilheiro = jogadores.get(0);
    	
    	for (Jogador jogador : jogadores) {
			if (jogador.getQtdGols() > artilheiro.getQtdGols()) {
				artilheiro = jogador;
			}			
		}
    	return artilheiro;
    }
    
    public int getGols() {

        int gols = 0;
        for (Jogador jogador : jogadores) {
            gols += jogador.getQtdGols();
        }
        return gols;
    }
}