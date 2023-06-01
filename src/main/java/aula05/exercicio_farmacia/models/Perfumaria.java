package aula05.exercicio_farmacia.models;

import lombok.Getter;

@Getter
public class Perfumaria extends Produto{

    public Perfumaria(String nome, int estoque, double valor) {
        super(nome, estoque, valor);
    }

    public boolean dividaCliente(double valor) {
        return valor < 300;
    }

    public boolean verificarVenda(int qtd, double valor) {
        return inEstoque(qtd) && dividaCliente(valor);
    }
}