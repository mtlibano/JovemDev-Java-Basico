package aula05.exercicio_farmacia.utils;

import aula05.exercicio_farmacia.models.*;
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

    public void calcEstoqueSaldo(Produto p, Cliente c, int qtd) {
        p.movimentoEstoque(qtd);
        c.addSaldoDevedor((qtd * p.getValor()));
    }

    public void vendaProduto(Cliente c, Produto p, int qtd) {
        if (p instanceof Medicamento && p.inEstoque(qtd)) {
            Medicamento m = (Medicamento) p;
            if (m.isReterReceita()) {
                System.out.println("Informe o nome do médico que prescreveu o medicamento");
            }
            calcEstoqueSaldo(p, c, qtd);
        } else if (p instanceof Perfumaria) {
            Perfumaria pe = (Perfumaria) p;
            if (pe.verificarVenda(qtd, c.getSaldoDevedor())) {
                calcEstoqueSaldo(p, c, qtd);
            }
        } else if (p instanceof EquipMedico) {
            calcEstoqueSaldo(p, c, qtd);
        }
    }

    public void pagarSaldoDevedor(Cliente c, double valor) {
        c.pagarDivida(valor);
    }

    public Cliente getClienteNome(String nome) {
        return clientes.stream().filter(cliente -> cliente.getNome().equals(nome)).findFirst().orElse(null);
    }

    public Produto getProdutoNome(String nome) {
        return produtos.stream().filter(produto -> produto.getNome().equals(nome)).findFirst().orElse(null);
    }
}
