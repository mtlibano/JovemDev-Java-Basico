package aula05.exercicio_conta.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Conta {
	
	protected int numero;
	protected int agencia;
	protected String nomeCorrentista;
	protected double saldo;
	
	public void deposito(double valor) {
		this.saldo += valor;
	}
	
	public void saque(double valor) {
		if (valor <= saldo) {
			saldo -= valor;			
		}
	}
	
	public boolean transferencia(double valor) {
		return valor <= saldo;
	}
}
