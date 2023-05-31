package aula05.exercicio_conta.models;

import lombok.Getter;

@Getter
public class ContaUniversitario extends Conta{

	public ContaUniversitario(int numero, int agencia, String nomeCorrentista, double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}
	
	@Override
	public void deposito(double valor) {
		if (2000 >= (saldo + valor)) {
			saldo += valor;
		}
	}
	
	@Override
	public void saque(double valor) {
		if (valor <= saldo) {
			saldo -= valor;			
		}
	}
	
	@Override
	public boolean transferencia(double valor) {
		return  2000 <= (saldo + valor);
	}
}