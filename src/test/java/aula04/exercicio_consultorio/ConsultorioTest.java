package aula04.exercicio_consultorio;

import aula04.exercicio_consultorio.models.Medicamento;
import aula04.exercicio_consultorio.models.Pessoa;
import aula04.exercicio_consultorio.enums.EnumAdmMedicamentos;
import aula04.exercicio_consultorio.utils.Consultorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsultorioTest {

    Consultorio consultorio = new Consultorio();

    @BeforeEach
    void init() {
        consultorio.getMedicamentos().clear();
        consultorio.getPessoas().clear();
        Pessoa p1 = new Pessoa("Pessoa 1", "Gripe");
        p1.addCondicaoSaude("Diabetes");
        p1.addCondicaoSaude("Pressão Alta");

        Pessoa p2 = new Pessoa("Pessoa 2", "Dor");
        p2.addCondicaoSaude("Pressão Alta");

        Pessoa p3 = new Pessoa("Pessoa 3", "Dengue");

        consultorio.getPessoas().add(p1);
        consultorio.getPessoas().add(p2);
        consultorio.getPessoas().add(p3);

        Medicamento m1 = new Medicamento("Medicamento 1", EnumAdmMedicamentos.ORAL);
        m1.addIndicacao("Dor");
        m1.addIndicacao("Febre");
        m1.addContraIndicacao("Diabetes");

        Medicamento m2 = new Medicamento("Medicamento 2", EnumAdmMedicamentos.INJETAVEL);
        m2.addIndicacao("Gripe");

        consultorio.getMedicamentos().add(m1);
        consultorio.getMedicamentos().add(m2);
    }

    @Test
    @DisplayName("Teste cadastrar Medicamento")
    void addMedicamento() {
        Medicamento m = new Medicamento("Teste 1", EnumAdmMedicamentos.ORAL);
        consultorio.cadastrarMedicamento(m);
        assertEquals(3, consultorio.getMedicamentos().size());
    }

    @Test
    @DisplayName("Teste cadastrar Pessoa")
    void addPessoa() {
        Pessoa p = new Pessoa("Teste", "");
        consultorio.cadastrarPessoa(p);
        assertEquals(4, consultorio.getPessoas().size());
    }

    @Test
    @DisplayName("Teste prescricao ok")
    void addPrescricaoOK() {
        Pessoa p = consultorio.getPessoas().get(1);
        Medicamento m = consultorio.getMedicamentos().get(0);
        consultorio.prescreveMedicamento(p, m);
        assertEquals(1, p.getMedicamentos().size());
        assertEquals("Medicamento 1", p.getMedicamentos().get(0).getNome());
    }

    @Test
    @DisplayName("Teste prescricao por falha na indicação")
    void addPrescricaoFalhaIndicacao() {
        Pessoa p = consultorio.getPessoas().get(0);
        Medicamento m = consultorio.getMedicamentos().get(0);
        consultorio.prescreveMedicamento(p, m);
        assertEquals(0, p.getMedicamentos().size());
    }

    @Test
    @DisplayName("Teste pessoa existe")
    void existePessoa() {
        Pessoa p = consultorio.getPessoas().get(2);
        assertTrue(consultorio.exitePessoa(p));
    }

    @Test
    @DisplayName("Teste medicamento existe")
    void existeMedicamento() {
        Medicamento m = consultorio.getMedicamentos().get(1);
        assertTrue(consultorio.existeMedicamento(m));
    }
}