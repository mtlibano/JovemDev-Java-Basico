package terceira_aula.exercicio_time;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static int menuPrincipal() {
        String menu = "1 - Cadastrar TIME\n"
                + "2 - Listar todos os jogadores de um time\n"
                + "3 - Verificar artilheiro do campeonato\n"
                + "4 - Verificar qual time fez mais GOLS\n\n"
                + "5 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public static void cadastrarTime(List<Time> times) {
        Time t = new Time();
        t.cadastrar();
        times.add(t);
    }
    
    public static Time escolheTime(List<Time> times) {
        String menu = "Selecione um time\n";
        int pos = 1;
        for (Time time : times) {
            menu += pos + " - " + time.getNome() + "\n";
            pos++;
        }
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return times.get(op-1);
    }
    
    static String listarJogadoresTime(List<Time> times) {
    	Time t = escolheTime(times);
        return t.listJogadores();
    }

    public static String artilheiroCampeonato(List<Time> times) {
        Jogador artilheiro = new Jogador();
        for (Time time : times) {
            if (time.getArtilheiro().getQtdGols() > artilheiro.getQtdGols()) {
                artilheiro = time.getArtilheiro();
            }
        }
        return artilheiro.toString();
    }

    public static String timeMaisGols(List<Time> times) {
        Time timeMaisGols = new Time();
        for (Time time : times) {
            if (time.getGols() > timeMaisGols.getGols()) {
                timeMaisGols = time;
            }
        }
        return timeMaisGols.getNome();
    }
}