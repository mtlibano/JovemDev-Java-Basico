package aula05.exercicio_conta2.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Conta {

    private String nome;
    private int numero;
    private int agencia;
    protected double saldo;

    public boolean deposito(double valor) {
        if (valor > 0) {
            saldo = getSaldo() + valor;
            return true;
        }
        return false;
    }

    public boolean saque(double valor) {
        if (getSaldo() >= valor) {
            saldo = getSaldo() - valor;
            return true;
        }
        return false;
    }

    public boolean transferencia(double valor, Conta destino) {
        if (saque(valor)) {
            if (destino.deposito(valor)) {
                return true;
            } else {
                deposito(valor);
                return false;
            }
        }
        return false;
    }
}
