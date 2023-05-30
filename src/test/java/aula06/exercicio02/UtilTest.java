package aula06.exercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    private Util bd = new Util();

    @Test
    @BeforeEach
    void init() {
        bd.clearData();
        Professor p1 = new Professor("prof1", EnumFormacao.GRADUACAO);
        Professor p2 = new Professor("prof2", EnumFormacao.ESPECIALIZACAO);
        Professor p3 = new Professor("prof3", EnumFormacao.POS_GRADUACAO);
        bd.addProfessor(p1);
        bd.addProfessor(p2);
        bd.addProfessor(p3);

        Disciplina d1 = new Disciplina("matematica", 60.0, p1);
        Disciplina d2 = new Disciplina("fisica", 40.0, p2);
        bd.addDisciplina(d1);
        bd.addDisciplina(d2);
    }

    @Test
    @DisplayName("Teste cadastro professor")
    void testAddProfessor() {
        List<Professor> lista = bd.listAllProf();
        assertEquals(3, lista.size());
        Professor p = new Professor("prof4", EnumFormacao.ESPECIALIZACAO);
        lista.add(p);
        lista = bd.listAllProf();
        assertEquals(4, lista.size());
        assertEquals("prof4", lista.get(3).getNome());
    }

    @Test
    @DisplayName("Teste cadastro disciplina")
    void testAddDisciplina() {
        List<Disciplina> lista = bd.listAllDisciplina();
        assertEquals(2, lista.size());
        Disciplina d = new Disciplina("quimica", 20.0, bd.listAllProf().get(2));
        lista.add(d);
        lista = bd.listAllDisciplina();
        assertEquals(3, lista.size());
        assertEquals("quimica", lista.get(2).getNome());
        assertEquals("prof3", lista.get(2).getProfessor().getNome());
    }

    @Test
    @DisplayName("Teste cadastro aluno")
    void testAddAluno() {
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        disciplinas.add(bd.listAllDisciplina().get(0));
        disciplinas.add(bd.listAllDisciplina().get(1));
        Aluno a = new Aluno("Max Tiago", disciplinas);
        bd.addAluno(a);
        assertEquals("Max Tiago", bd.listAllAluno().get(0).getNome());
        assertEquals("matematica", bd.listAllAluno().get(0).getDisciplinas().get(0).getNome());
    }





}


