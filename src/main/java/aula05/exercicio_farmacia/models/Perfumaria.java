package aula05.exercicio_farmacia.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
public class Perfumaria extends Produto{

    public Perfumaria(String nome, int estoque, double valor) {
        super(nome, estoque, valor);
    }

    @Override
    public boolean dividaCliente(double valor) {
        return valor < 300;
    }

}
