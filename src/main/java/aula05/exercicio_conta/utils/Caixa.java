package aula05.exercicio_conta.utils;

import aula05.exercicio_conta.models.Conta;
import aula05.exercicio_conta.models.ContaUniversitario;
import lombok.Getter;
import java.util.List;
import java.util.ArrayList;

@Getter
public class Caixa {
	
	private final List<Conta> contas = new ArrayList<>();
	
	public void addConta(Conta c) {
		contas.add(c);
	}
	
	public void transferencia(Conta conta1, Conta conta2, double valor) {
		if (conta1.transferencia(valor) && !(conta2 instanceof ContaUniversitario)) {
			conta1.saque(valor);
			conta2.deposito(valor);
		} else if (conta1.transferencia(valor) && conta2 instanceof ContaUniversitario) {
			if (2000 >= (conta2.getSaldo()+valor)) {
				conta1.saque(valor);
				conta2.deposito(valor);
			}
		}

	}
}