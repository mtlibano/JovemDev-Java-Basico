package terceira_aula.exercicio_time;

import javax.swing.*;
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
                    break;
                case 2:
                    Util.listarJogadoresTime(time);

            }


        } while (op != 5);








    }

}
