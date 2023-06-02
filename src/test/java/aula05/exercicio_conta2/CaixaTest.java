package aula05.exercicio_conta2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aula05.exercicio_conta2.models.Conta;
import aula05.exercicio_conta2.models.ContaEspecial;
import aula05.exercicio_conta2.models.ContaUniversitario;
import aula05.exercicio_conta2.utils.Caixa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaixaTest {

    private Caixa caixa = new Caixa();

    @BeforeEach
    public void init() {
        caixa.getContas().clear();
        caixa.addConta(new Conta("Corr 1", 1, 1, 10));
        caixa.addConta(new ContaEspecial("Corr 2", 2, 2, 10, 500));
        caixa.addConta(new ContaUniversitario("Corr 3", 3, 3, 10));
    }

    @Test
    @DisplayName("Transferencia ente Cta Corr e Cta Univ possível")
    public void transf1() {
        Conta corr = caixa.getContas().get(0);
        ContaUniversitario univ = (ContaUniversitario)caixa.getContas().get(2);
        caixa.transferencia(10, corr, univ);
        assertEquals(0, corr.getSaldo());
        assertEquals(20, univ.getSaldo());
    }

    @Test
    @DisplayName("Transferencia ente Cta Corr e Cta Univ impossível")
    public void transf2() {
        Conta corr = caixa.getContas().get(0);
        ContaUniversitario univ = (ContaUniversitario)caixa.getContas().get(2);
        caixa.deposito(1990, univ);
        assertEquals(2000, univ.getSaldo());
        caixa.transferencia(10, corr, univ);
        assertEquals(10, corr.getSaldo());
        assertEquals(2000, univ.getSaldo());
    }
}