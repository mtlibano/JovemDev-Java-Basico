package aula05.exercicio_farmacia2.utils;

import java.util.List;
import java.util.ArrayList;

import aula05.exercicio_farmacia2.models.Cliente;
import aula05.exercicio_farmacia2.models.Produto;
import aula05.exercicio_farmacia2.models.Venda;
import lombok.Getter;

@Getter
public class Farmacia {

    private List<Venda> vendas = new ArrayList<>();

    public void vender(Cliente cliente, Produto produto, int qt, String medico) {
        Venda v = new Venda(cliente, produto, qt, medico);
        if (produto.vender(v)) {
            vendas.add(v);
        }
    }

    public List<Venda> vendasPorCliente(Cliente c) {
//		List<Venda> vendasEncontradas = new ArrayList<>();
//		for (Venda venda : vendas) {
//			if(venda.isCliente(c)) {
//				vendasEncontradas.add(venda);
//			}
//		}
//		return vendasEncontradas;

        return vendas.stream().filter( v -> v.isCliente(c)).toList();
    }
}