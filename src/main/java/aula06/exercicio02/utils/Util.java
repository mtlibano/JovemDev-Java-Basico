package aula06.exercicio02.utils;

import aula06.exercicio02.enums.EnumFormacao;
import aula06.exercicio02.models.Aluno;
import aula06.exercicio02.models.Disciplina;
import aula06.exercicio02.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private final List<Professor> bdProfessor = new ArrayList<>();
    private final List<Aluno> bdAluno = new ArrayList<>();
    private final List<Disciplina> bdDisciplina = new ArrayList<>();

    public void addProfessor(Professor p) {
        bdProfessor.add(p);
    }

    public void addDisciplina(Disciplina d) {
        bdDisciplina.add(d);
    }

    public void addAluno(Aluno a) {
        bdAluno.add(a);
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {
        aluno.adicionarDisciplina(disciplina);
    }
    
    public void informarNotas(Aluno aluno, Disciplina disciplina, double[] notas) {
        aluno.adicionarNotas(disciplina, notas);
    }
    
    public void listarDisciplinasAlunoMedia(Aluno aluno) {
        System.out.println("Disciplinas matriculadas pelo aluno " + aluno.getNome() + ":");
        for (Disciplina disciplina : aluno.getDisciplinas()) {
            double media = aluno.calcularMedia(disciplina);
            System.out.println("- " + disciplina.getNome() + " (Média: " + media + ")");
        }
    }

    public void listarDisciplinasPosGraduacao() {
        System.out.println("Disciplinas lecionadas por professores com pós-graduação:");
        for (Disciplina disciplina : bdDisciplina) {
            Professor professor = disciplina.getProfessor();
            if (professor.getFormacao().equals(EnumFormacao.POS_GRADUACAO)) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }

    public Aluno getAlunoNome(String nome) {
        return bdAluno.stream().filter(aluno -> aluno.getNome().equals(nome)).findFirst().orElse(null);
    }

    public Disciplina getDisciplinaNome(String nome) {
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