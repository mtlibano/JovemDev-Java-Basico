package aula05.exercicio_farmacia.utils;

import aula05.exercicio_farmacia.models.Cliente;
import aula05.exercicio_farmacia.models.Produto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Farmacia {

    List<Produto> produtos = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void addProduto(Produto p) {
        produtos.add(p);
    }

    public void vendaProduto(Cliente c, Produto p, int qtd) {
        if (p.verificarVenda(qtd, c.getSaldo())) {
            p.setEstoque(p.getEstoque() - qtd);
            c.setSaldo(c.getSaldo() + (qtd*p.getValor()));
        }
    }

    public void pagarDivida(Cliente c, double valorPago) {
        c.setSaldo(c.getSaldo()-valorPago);
    }
}
