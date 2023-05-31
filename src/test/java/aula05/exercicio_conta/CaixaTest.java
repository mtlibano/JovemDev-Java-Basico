package aula05.exercicio_conta;

import org.junit.jupiter.api.BeforeEach;

import aula05.exercicio_conta.models.Conta;
import aula05.exercicio_conta.models.ContaEspecial;
import aula05.exercicio_conta.utils.Caixa;

public class CaixaTest {
	
	Caixa caixa = new Caixa();
		
	@BeforeEach
	void init() {
		caixa.getContas().clear();
		caixa.getContasEspecial().clear();
		caixa.getContasUniversitario().clear();
		
		Conta c1 = new Conta(1, 1, "max", 1000);
		Conta c2 = new Conta(2, 1, "mari", 500);
		Conta ce1 = new ContaEspecial(3, 1, "pedro", 1200, 3000);
		Conta ce2 = new ContaEspecial(4, 1, "pedro", 600, 1500);
		Conta cu1 = new ContaUniversitario
		
		
	}
	
	

}
