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
	
	public Disciplina addDisciplina(Disciplina d) {
		bdDisciplina.add(d);
		return d;
	}
	
	public Aluno addAluno(Aluno a) {
		bdAluno.add(a);
		return a;
	}

	public List<Professor> listAllProf() {
		return bdProfessor;
	}

	public List<Disciplina> listAllDisciplina() {
		return bdDisciplina;
	}

	public List<Aluno> listAllAluno() {
		return bdAluno;
	}

	public void clearData() {
		bdProfessor.clear();
		bdAluno.clear();
		bdDisciplina.clear();
	}
}