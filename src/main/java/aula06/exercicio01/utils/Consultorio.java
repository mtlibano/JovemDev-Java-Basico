package aula06.exercicio01.utils;

import aula06.exercicio01.models.Medicamento;
import aula06.exercicio01.models.Pessoa;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Consultorio {

    private List<Medicamento> medicamentos = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrarMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public void cadastrarPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public boolean existeMedicamento(Medicamento m) {
        return medicamentos.contains(m);
    }

    public boolean exitePessoa(Pessoa p) {
        return pessoas.contains(p);
    }

    public void prescreveMedicamento(Pessoa p, Medicamento m) {
        if (existeMedicamento(m) && exitePessoa(p)) {
            p.addMedicamento(m);
        }
    }
}