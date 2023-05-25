package terceira_aula.exercicio_time;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PrincipalTime {

    public static void main(String[] args) {

        ArrayList<Time> time = new ArrayList<>();

        int op = 0;
        do {
            op = Util.menuPrincipal();
            switch (op) {
                case 1:
                    Time t = new Time();
                    t.cadastrarTime();
                    JOptionPane.showMessageDialog(null, t.listJogadores());
                    break;
                case 2:
                	JOptionPane.showMessageDialog(null, Util.listarJogadoresTime(time));
    				break;

            }


        } while (op != 5);








    }

}
