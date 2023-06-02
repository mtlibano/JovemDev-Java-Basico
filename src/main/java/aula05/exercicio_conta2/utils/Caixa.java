package aula05.exercicio_conta2.utils;

import aula05.exercicio_conta2.models.Conta;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Caixa {

    List<Conta> contas = new ArrayList<>();

    public void addConta(Conta c) {
        contas.add(c);
    }

    public boolean deposito(double valor, Conta c) {
        return c.deposito(valor);
    }

    public boolean saque(double valor, Conta c) {
        return c.saque(valor);
    }

    public boolean transferencia(double valor, Conta conta1, Conta conta2) {
        return conta1.transferencia(valor, conta2);
    }

}
