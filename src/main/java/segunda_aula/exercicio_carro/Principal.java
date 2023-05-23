package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	static List<Carro> carros = new ArrayList<Carro>();
	
	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar\n2 - Listar veículos por ano\n3 - Listar veículos por marca\n4 - Listar veículos por cor\n\n5 - Sair";
		
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (op == 1) {
				Carro c = new Carro();
				c.cadastrar();
				carros.add(c);
			} else if (op == 2) {
				
				int anoInicio = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano inicial"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final"));
				
				for (Carro c : carros) {
					if (c.ano >= anoInicio && c.ano <= anoFinal) {
						System.out.println(c.toString());
					}
				}
				
			} else if (op == 3) {
				
				
				
			}
			
		} while (op != 5);


	}

}
