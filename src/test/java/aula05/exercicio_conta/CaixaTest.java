package aula05.exercicio_conta;

import aula05.exercicio_conta.models.ContaUniversitario;
import org.junit.jupiter.api.BeforeEach;

import aula05.exercicio_conta.models.Conta;
import aula05.exercicio_conta.models.ContaEspecial;
import aula05.exercicio_conta.utils.Caixa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaixaTest {
	
	Caixa caixa = new Caixa();
		
	@BeforeEach
	void init() {
		caixa.getContas().clear();
		
		Conta c1 = new Conta(1, 1, "max", 1000);
		Conta c2 = new Conta(2, 1, "mari", 2000);
		Conta ce1 = new ContaEspecial(3, 1, "pedro", 1200, 3000);
		Conta ce2 = new ContaEspecial(4, 1, "isa", 600, 1500);
		Conta cu1 = new ContaUniversitario(5, 1, "joao", 400);
		Conta cu2 = new ContaUniversitario(6, 1, "bia", 800);
		caixa.addConta(c1);
		caixa.addConta(c2);
		caixa.addConta(ce1);
		caixa.addConta(ce2);
		caixa.addConta(cu1);
		caixa.addConta(cu2);
	}

	@Test
	@DisplayName("Teste deposito conta")
	void testDepositoConta() {
		caixa.getContas().get(0).deposito(200);
		assertEquals(1200, caixa.getContas().get(0).getSaldo());
	}

	@Test
	@DisplayName("Teste deposito contaEspecial")
	void testDepositoContaEspecial() {
		caixa.getContas().get(2).deposito(200);
		assertEquals(1400, caixa.getContas().get(2).getSaldo());
	}

	@Test
	@DisplayName("Teste deposito contaUniversitario")
	void testDepositoContaUniversitario() {
		caixa.getContas().get(4).deposito(200);
		assertEquals(600, caixa.getContas().get(4).getSaldo());
	}

	@Test
	@DisplayName("Teste deposito contaUniversitario ERROR")
	void testDepositoContaUniversitarioError() {
		caixa.getContas().get(5).deposito(2000);
		assertEquals(800, caixa.getContas().get(5).getSaldo());
	}

	@Test
	@DisplayName("Teste saque conta")
	void testSaqueConta() {
		caixa.getContas().get(0).saque(200);
		assertEquals(800, caixa.getContas().get(0).getSaldo());
	}

	@Test
	@DisplayName("Teste saque contaEspecial")
	void testSaqueContaEspecial() {
		caixa.getContas().get(2).saque(200);
		assertEquals(1000, caixa.getContas().get(2).getSaldo());
	}

	@Test
	@DisplayName("Teste saque contaEspecial utilizando Limite")
	void testSaqueContaEspecialLimite() {
		double valor = 0;
		caixa.getContas().get(3).saque(1000);
		assertEquals(0, caixa.getContas().get(3).getSaldo());
		if (caixa.getContas().get(2) instanceof ContaEspecial) {
			ContaEspecial ce = (ContaEspecial) caixa.getContas().get(3);
			valor = ce.getLimite();
		}
		assertEquals(1100, valor);
	}

	@Test
	@DisplayName("Teste saque contaUniversitario")
	void testSaqueContaUniversitario() {
		caixa.getContas().get(4).saque(200);
		assertEquals(200, caixa.getContas().get(4).getSaldo());
	}

	@Test
	@DisplayName("Teste tranferencia conta>contaEspecial")
	void testTransferenciaTipo1() {
		caixa.transferencia(caixa.getContas().get(0), caixa.getContas().get(2), 400);
		assertEquals(600, caixa.getContas().get(0).getSaldo());
		assertEquals(1600, caixa.getContas().get(2).getSaldo());
	}

	@Test
	@DisplayName("Teste tranferencia conta>contaUniversitario")
	void testTransferenciaTipo2() {
		caixa.transferencia(caixa.getContas().get(0), caixa.getContas().get(4), 400);
		assertEquals(600, caixa.getContas().get(0).getSaldo());
		assertEquals(800, caixa.getContas().get(4).getSaldo());
	}

	@Test
	@DisplayName("Teste tranferencia conta>contaUniversitario ERROR")
	void testTransferenciaTipo2Error() {
		caixa.transferencia(caixa.getContas().get(1), caixa.getContas().get(4), 1800);
		assertEquals(2000, caixa.getContas().get(1).getSaldo());
		assertEquals(400, caixa.getContas().get(4).getSaldo());
	}

	@Test
	@DisplayName("Teste tranferencia contaEspecial>conta")
	void testTransferenciaTipo3() {
		caixa.transferencia(caixa.getContas().get(2), caixa.getContas().get(0), 600);
		assertEquals(600, caixa.getContas().get(2).getSaldo());
		assertEquals(1600, caixa.getContas().get(0).getSaldo());
	}
}
