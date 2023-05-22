package primeira_aula;

public class Pessoa {
	
	private String nome;
	private String sexo;
	private double peso;
	private double altura;
	
	public Pessoa(String nome, String sexo, double peso, double altura) {
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public double calculoImc() {
		 return this.peso / (this.altura*this.altura);
	}
	
	public void tabelaImc(double imc) {
		
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