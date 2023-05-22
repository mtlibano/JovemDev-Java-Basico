package primeira_aula;

import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		
		int op = 0;
		do {
			String nome = JOptionPane.showInputDialog("Digite o nome");
			String sexo = JOptionPane.showInputDialog("Digite o sexo");
			double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso (kg)"));
			double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite o altura (m)"));
			System.out.print("Nome: " + nome + ", sexo: " + sexo + ", resultado IMC: ");
			tabelaImc(calculoImc(peso, altura));
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Novo cadastro\n1 - Sim\n2 - Não"));
			
		} while (op == 1);			
		
		//Pessoa p1 = new Pessoa("Max", "Masculino", 81.0, 1.80);			
		//p1.tabelaImc(p1.calculoImc());

	}
	
	public static double calculoImc(double peso, double altura) {
		 return peso / (altura*altura);
	}
	
	public static void tabelaImc(double imc) {
		
		if (imc < 16) {
			System.out.println("Baixo peso Grau III");
		} else if (imc < 16.99) {
			System.out.println("Baixo peso Grau II");
		} else if (imc < 18.49) {
			System.out.println("Baixo peso Grau I");
		} else if (imc < 24.99) {
			System.out.println("Peso Ideal");
		} else if (imc < 29.99) {
			System.out.println("Sobrepeso");
		} else if (imc < 34.99) {
			System.out.println("Obesidade Grau I");
		} else if (imc < 39.99) {
			System.out.println("Obesidade Grau II");
		}else if (imc >= 40) {
			System.out.println("Obesidade Grau III");
		}		
	}

}
