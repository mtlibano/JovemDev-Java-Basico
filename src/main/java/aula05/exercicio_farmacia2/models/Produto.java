package aula05.exercicio_farmacia2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Produto {

    private String nome;
    private int qtdEstoque;
    private double valor;

    public boolean vender(Venda v) {
        qtdEstoque = getQtdEstoque() - v.getQtd();
        v.getCliente().addCredito(getValor() * v.getQtd());
        return true;
    }
}