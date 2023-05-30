package aula06.exercicio02;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

		Aluno a1 = new Aluno("max");
		Aluno a2 = new Aluno("mari");
		bd.addAluno(a1);
		bd.addAluno(a2);
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
		List<Disciplina> lista = bd.listAllDisciplina();
		assertEquals(2, lista.size());
		Aluno a = new Aluno("Max Tiago");
		bd.addAluno(a);
		assertEquals("Max Tiago", bd.listAllAluno().get(2).getNome());
	}

	@Test
	@DisplayName("Teste buscar aluno por nome")
	void testGetAlunoNome() {
		Aluno a = bd.getAlunoNome("max");
		assertEquals("max", a.getNome());
	}

	@Test
	@DisplayName("Teste buscar disciplina por nome")
	void testGetDisciplinaNome() {
		Disciplina d = bd.getDisciplinaNome("fisica");
		assertEquals("fisica", d.getNome());
		assertEquals(40, d.getCargaHoraria());
	}

	@Test
	@DisplayName("Teste add Disciplina Aluno")
	void testAddDisciplinaAluno() {
		Professor professor1 = new Professor("joao", EnumFormacao.ESPECIALIZACAO);
		Disciplina disciplina1 = new Disciplina("math", 60, professor1);
		Aluno aluno1 = new Aluno("pedro");

		bd.matricularAluno(aluno1, disciplina1);

	}

	@Test
	@DisplayName("Teste informar notas")
	void testInformarNotas() {
		Professor professor1 = new Professor("joao", EnumFormacao.ESPECIALIZACAO);
		Disciplina disciplina1 = new Disciplina("math", 60, professor1);
		Disciplina disciplina2 = new Disciplina("ingles", 40, professor1);
		Aluno aluno1 = new Aluno("pedro");

		bd.matricularAluno(aluno1, disciplina1);
		bd.matricularAluno(aluno1, disciplina2);

		double[] notasAluno1Disciplina1 = {8.0, 9.0, 7.0};
		double[] notasAluno1Disciplina2 = {7.0, 6.0, 5.0};

		bd.informarNotas(aluno1, disciplina1, notasAluno1Disciplina1);
		bd.informarNotas(aluno1, disciplina2, notasAluno1Disciplina2);
		
		assertEquals(8, aluno1.getNotas().get(disciplina1)[0]);
		assertEquals(5, aluno1.getNotas().get(disciplina2)[2]);	
	}
	
	@Test
	@DisplayName("Teste listar disciplinas de um aluno com sua média")
	void testListarDisciplinasAlunoMedia() {
		Professor professor1 = new Professor("joao", EnumFormacao.ESPECIALIZACAO);
		Disciplina disciplina1 = new Disciplina("math", 60, professor1);
		Disciplina disciplina2 = new Disciplina("ingles", 40, professor1);
		Aluno aluno1 = new Aluno("pedro");

		bd.matricularAluno(aluno1, disciplina1);
		bd.matricularAluno(aluno1, disciplina2);

		double[] notasAluno1Disciplina1 = {8.0, 9.0, 7.0};
		double[] notasAluno1Disciplina2 = {7.0, 6.0, 5.0};

		bd.informarNotas(aluno1, disciplina1, notasAluno1Disciplina1);
		bd.informarNotas(aluno1, disciplina2, notasAluno1Disciplina2);
		
		bd.listarDisciplinasAlunoMedia(aluno1);
		assertTrue(aluno1.getDisciplinas().contains(disciplina1));
        assertTrue(aluno1.getDisciplinas().contains(disciplina2));
	}
	
	
	@Test
	@DisplayName("Teste listar disciplinas com professores com pós-graduação")
	void testListarDisciplinaPosGraduacao() {
		Professor prof1 = new Professor("clavison", EnumFormacao.ESPECIALIZACAO);
		Professor prof2 = new Professor("thiago", EnumFormacao.POS_GRADUACAO);
		Professor prof3 = new Professor("joao", EnumFormacao.GRADUACAO);
		Disciplina disciplina1 = new Disciplina("math", 60, prof1);
		Disciplina disciplina2 = new Disciplina("ingles", 40, prof2);
		Disciplina disciplina3 = new Disciplina("fisica", 40, prof3);
		bd.addDisciplina(disciplina1);
		bd.addDisciplina(disciplina2);
		bd.addDisciplina(disciplina3);
				
		bd.listarDisciplinasPosGraduacao();
	}
}