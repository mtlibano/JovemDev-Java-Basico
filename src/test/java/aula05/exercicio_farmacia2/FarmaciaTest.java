package aula05.exercicio_farmacia2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import aula05.exercicio_farmacia2.models.*;
import aula05.exercicio_farmacia2.utils.Farmacia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FarmaciaTest {

    private Farmacia farmacia = new Farmacia();
    private Cliente c = null;
    private Medicamento m1 = null;
    private Medicamento m2 = null;
    private Perfumaria p1 = null;
    private EquipamentoMedico e1 = null;

    @BeforeEach
    public void init() {
        farmacia.getVendas().clear();

        c = new Cliente("Cliente", 0);
        m1 = new Medicamento("M1", 10, 10, false);
        m2 = new Medicamento("M1", 10, 10, true);
        p1 = new Perfumaria("P1", 10, 10);
        e1 = new EquipamentoMedico("E1", 0, 10);
    }

    @Test
    @DisplayName("Venda de medicamento com receita sem informar o médico")
    void testVenderMedicamentoComReceitaSemMedico() {
        farmacia.vender(c, m2, 3, null);
        assertEquals(0, c.getSaldoDevedor());
        assertEquals(10, m2.getQtdEstoque());
    }

    @Test
    @DisplayName("Venda de medicamento com receita informando o médico")
    void testVenderMedicamentoComReceitaComMedico() {
        farmacia.vender(c, m2, 3, "Médico");
        assertEquals(30, c.getSaldoDevedor());
        assertEquals(7, m2.getQtdEstoque());
    }

    @Test
    @DisplayName("Venda de medicamento com quantidade acima do estoque")
    void testVenderMedicamentoSemEstoque() {
        farmacia.vender(c, m1, 20, null);
        assertEquals(0, c.getSaldoDevedor());
        assertEquals(10, m1.getQtdEstoque());
    }

    @Test
    @DisplayName("Venda de perfumaria para cliente com dívida maior que 300,00")
    void testVenderPerfumariaComDivida() {
        c.addCredito(350);
        farmacia.vender(c, p1, 1, null);
        assertEquals(350, c.getSaldoDevedor());
        assertEquals(10, p1.getQtdEstoque());
    }

    @Test
    @DisplayName("Venda de Equipamento médico sem estoque")
    void testVenderEquipamentoMedico() {
        farmacia.vender(c, e1, 1, null);
        assertEquals(10, c.getSaldoDevedor());
        assertEquals(-1, e1.getQtdEstoque());
    }

    @Test
    @DisplayName("Listar Vendas de um cliente")
    void testVListarVendasCliente() {
        farmacia.vender(c, m1, 1, null);
        farmacia.vender(c, m2, 1, null);
        farmacia.vender(c, p1, 50, null);
        farmacia.vender(c, e1, 1, null);
        List<Venda> vendas = farmacia.vendasPorCliente(c);
        assertEquals(2, vendas.size());
        assertEquals(20, c.getSaldoDevedor());
    }
}