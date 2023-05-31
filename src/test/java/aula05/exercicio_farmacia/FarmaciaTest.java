package aula05.exercicio_farmacia;

import aula05.exercicio_farmacia.models.*;
import aula05.exercicio_farmacia.utils.Farmacia;
import org.junit.jupiter.api.BeforeEach;

public class FarmaciaTest {

    private final Farmacia farmacia = new Farmacia();

    @BeforeEach
    void init() {
        farmacia.getClientes().clear();
        farmacia.getProdutos().clear();

        Produto p1 = new Medicamento("ritalina", 20, 10.0);
        Produto p2 = new Medicamento("vivance", 10, 10.0);
        Produto p3 = new Perfumaria("homme", 4, 200.0);
        Produto p4 = new Perfumaria("212", 6,100.0);
        Produto p5 = new EquipMedico("platina", 10, 50.0);
        Produto p6 = new EquipMedico("laser", 4, 40.0);
        farmacia.addProduto(p1);
        farmacia.addProduto(p2);
        farmacia.addProduto(p3);
        farmacia.addProduto(p4);
        farmacia.addProduto(p5);
        farmacia.addProduto(p6);

        Cliente c1 = new Cliente("max", 200.0);
        Cliente c2 = new Cliente("niki", 400.0);

    }

}
