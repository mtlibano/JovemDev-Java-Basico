package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

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
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano inicial"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final"));
				int contador = 0;
				for (Carro c : carros) {
					if (c.ano >= anoInicial && c.ano <= anoFinal) {
						System.out.println(c.toString());
						contador++;
					}
				}
				System.out.println("Porcentagem de CARROS desse ANO: " + (contador*100/carros.size()) + "%");

			} else if (op == 3) {
				String listarMarca = JOptionPane.showInputDialog("Digite a MARCA para listar");
				int contador = 0;
				for (Carro c : carros) {
					if (c.marca.equalsIgnoreCase(listarMarca)) {
						System.out.println(c.toString());
						contador++;
					}
				}
				System.out.println("Porcentagem de CARROS dessa MARCA: " + (contador*100/carros.size()) + "%");

			} else if (op == 4) {
				String listarCor = String.valueOf(JOptionPane.showInputDialog(null, "Selecione a COR", "Opções de cores", JOptionPane.QUESTION_MESSAGE, null, Carro.opcoes.values(), Carro.opcoes.values()));
				int contador = 0;
				for (Carro c : carros) {
					if (c.cor.equalsIgnoreCase(listarCor)) {
						System.out.println(c.toString());
						contador++;
					}
				}
				System.out.println("Porcentagem de CARROS com essa COR: " + (contador*100/carros.size()) + "%");
			}
		} while (op != 5);
	}
}