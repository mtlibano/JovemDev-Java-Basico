package aula06.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private static List<Professor> bdProfessor = new ArrayList<Professor>();
    private static List<Aluno> bdAluno = new ArrayList<Aluno>();
    private static List<Disciplina> bdDisciplina = new ArrayList<Disciplina>();

    public static Professor addProfessor(Professor p) {
        bdProfessor.add(p);
        return p;
    }

    public static Disciplina addDisciplina(Disciplina d) {
        bdDisciplina.add(d);
        return d;
    }

    public static Aluno addAluno(Aluno a) {
        bdAluno.add(a);
        return a;
    }

    public static void matricularAluno(Aluno nomeAluno, Disciplina nomeDisciplina) {
        nomeAluno.adicionarDisciplina(nomeDisciplina);
    }

    public static Aluno getAlunoNome(String nome) {
        return bdAluno.stream().filter(aluno -> aluno.getNome().equals(nome)).findFirst().orElse(null);
    }

    public static Disciplina getDisciplinaNome(String nome) {
        return bdDisciplina.stream().filter(disciplina -> disciplina.getNome().equals(nome)).findFirst().orElse(null);
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