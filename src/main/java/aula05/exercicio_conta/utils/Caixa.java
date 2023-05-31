package aula05.exercicio_conta.utils;

import aula05.exercicio_conta.models.Conta;
import aula05.exercicio_conta.models.ContaEspecial;
import aula05.exercicio_conta.models.ContaUniversitario;
import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class Caixa {
	
	private List<Conta> contas = new ArrayList<>();
	private List<ContaEspecial> contasEspecial = new ArrayList<>();
	private List<ContaUniversitario> contasUniversitario = new ArrayList<>();
	
	public void addConta(Conta c) {
		contas.add(c);
	}
	
	public void addContaEspecial(ContaEspecial ce) {
		contasEspecial.add(ce);
	}
	
	public void addContaUniversitario(ContaUniversitario cu) {
		contasUniversitario.add(cu);
	}
	
	public void deposito(Conta conta, double valor) {
		conta.deposito(valor);
	}
	
	public void saque(Conta conta, double valor) {
		conta.saque(valor);
	}
	
	public void transferencia(Conta conta1, Conta conta2, double valor) {
		if (conta1.transferencia(valor)) {
			conta1.saque(valor);
			conta2.deposito(valor);
		}		
	}
}