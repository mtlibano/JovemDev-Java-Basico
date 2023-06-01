package aula05.exercicio_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {

    protected String nome;
    protected int estoque;
    protected double valor;

    public boolean inEstoque(int qtd) {
        return estoque > qtd;
    }

    public void movimentoEstoque(int qtd) {
        estoque -= qtd;
    }
}
