package aula05.exercicio_conta.models;

import lombok.Getter;

@Getter
public class ContaEspecial extends Conta {
	
	private double limite;

	public ContaEspecial(int numero, int agencia, String nomeCorrentista, double saldo, double limite) {
		super(numero, agencia, nomeCorrentista, saldo);
		this.limite = limite;
	}
	
	@Override
	public void saque(double valor) {
		double aux = 0;
		if (valor <= saldo) {
			saldo -= valor;			
		} else {
			aux = valor - saldo;
			saldo = 0;
			limite -= aux;
		}
	}
	
}