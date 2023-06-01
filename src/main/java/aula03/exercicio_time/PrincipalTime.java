package aula03.exercicio_time;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class PrincipalTime {

    public static void main(String[] args) {

        List<Time> times = new ArrayList<Time>();

        int op = 0;
        do {
            op = Util.menuPrincipal();
            switch (op) {
                case 1:
                    Util.cadastrarTime(times);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, Util.listarJogadoresTime(times));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, Util.artilheiroCampeonato(times));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, Util.timeMaisGols(times));
                    break;

            }
        } while (op != 5);
    }
}