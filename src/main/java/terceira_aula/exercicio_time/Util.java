package terceira_aula.exercicio_time;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Util {

    static int menuPrincipal() {
        String menu = "1 - Cadastrar TIME\n"
                + "2 - Listar todos os jogadores de um time\n"
                + "3 - Verificar artilheiro do campeonato\n"
                + "4 - Verificar qual time fez mais GOLS\n\n"
                + "5 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    static void listarJogadoresTime(ArrayList<Time> time) {

        String nomeTime = JOptionPane.showInputDialog("Informe o nome do TIME");

        for (Time t : time) {

            //if (t.getNome().equalsIgnoreCase(nomeTime)) {

                System.out.println(t.getNome());

                ArrayList<Jogador> jogadores = t.getJogadores();

                System.out.println("Jogadores do Time " + t.getNome() + ":");
                for (Jogador jogador : jogadores) {

                    System.out.println("Nome: " + jogador.getNome() + ", Número da camisa: " + jogador.getNumCamisa());
                }

                /*for (Jogador j : t.getJogadores()) {
                    System.out.println(j.getNome());
                    //print += j.getNome();
                }*/
           //}
        }
    }
}