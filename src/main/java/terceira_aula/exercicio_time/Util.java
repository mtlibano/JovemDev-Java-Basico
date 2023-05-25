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
    
    public static Time escolheTime(List<Time> times) {
    	
    }
    
    static String listarJogadoresTime(ArrayList<Time> times) {
    	String nomeTime = JOptionPane.showInputDialog("Digite o nome do time");
    	String retorno = "";
    	
    	for (Time time : times) {
    		if (time.getNome().equalsIgnoreCase(nomeTime)) {
    			retorno += time.listJogadores();
    		}
		}
    	return retorno;
    }

}