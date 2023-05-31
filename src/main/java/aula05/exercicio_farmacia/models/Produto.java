package aula05.exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Produto {

    private String nome;
    private int estoque;
    private double valor;

    public boolean inEstoque(int qtd) {
        return estoque > qtd;
    }

    public boolean dividaCliente(double valor) {
        return true;
    }

    public boolean verificarVenda(int qtd, double valor) {
        return inEstoque(qtd) && dividaCliente(valor);
    }
}
