package aula05.exercicio_farmacia2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Venda {

    private Cliente cliente;
    private Produto produto;
    private int qtd;
    private String medico;

    @Override
    public String toString() {
        return cliente.getNome() + " - " + produto.getNome() + " - " + (produto.getValor() * qtd);
    }

    public boolean isCliente(Cliente c) {
        return c.getNome().equalsIgnoreCase(cliente.getNome());
    }
}