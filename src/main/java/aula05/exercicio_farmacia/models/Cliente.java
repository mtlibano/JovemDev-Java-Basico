package aula05.exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {

    private String nome;
    private double saldoDevedor;

    public void addSaldoDevedor(double valor) {
        saldoDevedor += valor;
    }

    public void pagarDivida(double valor) {
        saldoDevedor -= valor;
    }
}
