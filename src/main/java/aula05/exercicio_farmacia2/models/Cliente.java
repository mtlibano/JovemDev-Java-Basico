package aula05.exercicio_farmacia2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Cliente {

    private String nome;
    private double saldoDevedor;

    public boolean pagar(double valor) {
        if (valor > 0 && getSaldoDevedor() >= valor) {
            saldoDevedor = getSaldoDevedor() - valor;
            return true;
        }
        return false;
    }

    public void addCredito(double valor) {
        saldoDevedor = getSaldoDevedor() + valor;
    }
}