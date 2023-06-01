package aula05.exercicio_conta.models;

import lombok.Getter;

@Getter
public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, int agencia, String nomeCorrentista, double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
    }
}