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
			double resultadoImc = calculoImc(peso, altura);
			System.out.print("Nome: " + nome + ", sexo: " + sexo + ", resultado IMC: " + resultadoImc + " = ");
			tabelaImc(calculoImc(peso, altura), sexo);
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Novo cadastro\n1 - Sim\n2 - Não"));
			
		} while (op == 1);
		
		//Pessoa p1 = new Pessoa("Max", "Masculino", 81.0, 1.80);			
		//p1.tabelaImc(p1.calculoImc());

	}
	
	public static double calculoImc(double peso, double altura) {
		 return peso / (altura*altura);
	}
	
	public static void tabelaImc(double imc, String sexo) {
		
		if (sexo.equalsIgnoreCase("MASCULINO")) {
			if (imc < 20.7) {
				System.out.println("abaixo do peso");
			} else if (imc <= 26.4) {
				System.out.println("peso ideal");
			} else if (imc <= 27.8) {
				System.out.println("pouco acima do peso");
			} else if (imc <= 31.1) {
				System.out.println("acima do peso");
			} else if (imc > 31.2 ) {
				System.out.println("obesidade");
			}
		} else if (sexo.equalsIgnoreCase("FEMININO")) {
			if (imc < 19.1) {
				System.out.println("abaixo do peso");
			} else if (imc <= 25.8) {
				System.out.println("peso ideal");
			} else if (imc <= 27.3) {
				System.out.println("pouco acima do peso");
			} else if (imc <= 32.3) {
				System.out.println("acima do peso");
			} else if (imc > 32.4 ) {
				System.out.println("obesidade");
			}
		}
	}
}