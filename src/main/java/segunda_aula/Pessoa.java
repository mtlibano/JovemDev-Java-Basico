package segunda_aula;

import javax.swing.JOptionPane;

public class Pessoa {
	
	String nome;
	String sexo;
	double peso;
	double altura;
	
	double calculaImc() {
		return peso / (altura * altura);
	}
	
	void cadastro() {
		nome = JOptionPane.showInputDialog("Digite o nome");
		sexo = JOptionPane.showInputDialog("Digite o sexo (M/F)");
		peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso (kg)"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura (m)"));
	}
	
	public String toString() {
		
		String avaliacao = "";
		
		double imc = calculaImc();
		
		if (sexo.equalsIgnoreCase("MASCULINO")) {
			if (imc < 20.7) {
				avaliacao =  "abaixo do peso";
			} else if (imc <= 26.4) {
				avaliacao = "peso ideal";
			} else if (imc <= 27.8) {
				avaliacao = "pouco acima do peso";
			} else if (imc <= 31.1) {
				avaliacao = "acima do peso";
			} else if (imc > 31.2 ) {
				avaliacao = "obesidade";
			}
		} else if (sexo.equalsIgnoreCase("FEMININO")) {
			if (imc < 19.1) {
				avaliacao = "abaixo do peso";
			} else if (imc <= 25.8) {
				avaliacao = "peso ideal";
			} else if (imc <= 27.3) {
				avaliacao = "pouco acima do peso";
			} else if (imc <= 32.3) {
				avaliacao = "acima do peso";
			} else if (imc > 32.4 ) {
				avaliacao = "obesidade";
			}
		}
		return "valor " + imc + ", resultado " + avaliacao;
	}
}