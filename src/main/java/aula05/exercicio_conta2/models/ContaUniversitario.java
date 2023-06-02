package aula05.exercicio_conta2.models;

import lombok.Getter;

@Getter
public class ContaUniversitario extends Conta{

    public ContaUniversitario(String nome, int numero, int agencia, double saldo) {
        super(nome, numero, agencia, saldo);
    }

    @Override
    public boolean deposito(double valor) {
        if (getSaldo() + valor <= 2000) {
            saldo = getSaldo() + valor;
            return true;
        }
        return false;
    }
}
