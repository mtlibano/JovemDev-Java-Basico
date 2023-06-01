package aula05.exercicio_farmacia;

import aula05.exercicio_farmacia.models.*;
import aula05.exercicio_farmacia.utils.Farmacia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FarmaciaTest {

    private final Farmacia farmacia = new Farmacia();

    @BeforeEach
    void init() {
        farmacia.getClientes().clear();
        farmacia.getProdutos().clear();

        Produto p1 = new Medicamento("ritalina", 20, 10.0, true);
        Produto p2 = new Medicamento("vivance", 10, 10.0, false);
        Produto p3 = new Perfumaria("homme", 4, 80.0);
        Produto p4 = new Perfumaria("212", 6,100.0);
        Produto p5 = new EquipMedico("laser", 2, 200.0);
        farmacia.addProduto(p1);
        farmacia.addProduto(p2);
        farmacia.addProduto(p3);
        farmacia.addProduto(p4);
        farmacia.addProduto(p5);

        Cliente c1 = new Cliente("max", 200.0);
        Cliente c2 = new Cliente("niki", 400.0);
        farmacia.addCliente(c1);
        farmacia.addCliente(c2);
    }

    @Test
    @DisplayName("Test cadastro cliente")
    void testAddCliente() {
        Cliente c = new Cliente("joao", 100);
        farmacia.addCliente(c);
        assertEquals(3, farmacia.getClientes().size());
    }

    @Test
    @DisplayName("Test venda produto Medicamento reter receita")
    void testVendaMedicamento() {
        farmacia.vendaProduto(farmacia.getClientes().get(0), farmacia.getProdutos().get(0), 10);
        assertEquals(10, farmacia.getProdutos().get(0).getEstoque());
        assertEquals(300, farmacia.getClientes().get(0).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test venda produto Medicamento sem receita")
    void testVendaMedicamentoSemReceita() {
        farmacia.vendaProduto(farmacia.getClientes().get(1), farmacia.getProdutos().get(1), 5);
        assertEquals(5, farmacia.getProdutos().get(1).getEstoque());
        assertEquals(450, farmacia.getClientes().get(1).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test venda produto Perfumaria")
    void testVendaPerfumaria() {
        farmacia.vendaProduto(farmacia.getClientes().get(0), farmacia.getProdutos().get(2), 2);
        assertEquals(2, farmacia.getProdutos().get(2).getEstoque());
        assertEquals(360, farmacia.getClientes().get(0).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test venda produto Perfumaria com Saldo Devedor")
    void testVendaPerfumariaSaldoDevedor() {
        farmacia.vendaProduto(farmacia.getClientes().get(1), farmacia.getProdutos().get(3), 1);
        assertEquals(6, farmacia.getProdutos().get(3).getEstoque());
        assertEquals(400, farmacia.getClientes().get(1).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test venda produto Equipamentos Medicos")
    void testVendaEquipamentosMedico() {
        farmacia.vendaProduto(farmacia.getClientes().get(0), farmacia.getProdutos().get(4), 1);
        assertEquals(1, farmacia.getProdutos().get(4).getEstoque());
        assertEquals(400, farmacia.getClientes().get(0).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test venda produto Equipamentos Medicos Sem Estoque")
    void testVendaEquipamentosMedicoSemEstoque() {
        farmacia.vendaProduto(farmacia.getClientes().get(1), farmacia.getProdutos().get(4), 4);
        assertEquals(-2, farmacia.getProdutos().get(4).getEstoque());
        assertEquals(1200, farmacia.getClientes().get(1).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test pagar divida")
    void testPagarDivida() {
        farmacia.pagarSaldoDevedor(farmacia.getClientes().get(0), 100);
        assertEquals(100, farmacia.getClientes().get(0).getSaldoDevedor());
    }

    @Test
    @DisplayName("Test buscar cliente por nome")
    void testBuscarClienteNome() {
        Cliente c = farmacia.getClienteNome("niki");
        assertEquals("niki", c.getNome());
    }

    @Test
    @DisplayName("Test buscar produto por nome")
    void testBuscarProdutoNome() {
        Produto p = farmacia.getProdutoNome("homme");
        assertEquals("homme", p.getNome());
    }
}
