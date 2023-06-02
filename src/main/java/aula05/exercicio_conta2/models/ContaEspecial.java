package aula05.exercicio_conta2.models;

import lombok.Getter;

@Getter
public class ContaEspecial extends Conta {

    private double limite;

    public ContaEspecial(String nome, int numero, int agencia, double saldo, double limite) {
        super(nome, numero, agencia, saldo);
        this.limite = limite;
    }

    @Override
    public boolean saque(double valor) {
        if (getSaldo() + getLimite() >= valor) {
            saldo = getSaldo() - valor;
            return true;
        }
        return false;
    }
}
