package aula06.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	private List<Professor> bdProfessor = new ArrayList<Professor>();
	private List<Aluno> bdAluno = new ArrayList<Aluno>();
	private List<Disciplina> bdDisciplina = new ArrayList<Disciplina>();
	
	public Professor addProfessor(Professor p) {
		bdProfessor.add(p);
		return p;
	}
	
	public Disciplina addDisciplina(Disciplina d, List<Professor> p) {
		bdDisciplina.add(d);
		return d;
	}
	
	public Aluno addAluno(Aluno a, List<Disciplina> d) {
		bdAluno.add(a);
		return a;
	}
	
	
}