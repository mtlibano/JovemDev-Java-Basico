package aula06.exercicio01.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter @RequiredArgsConstructor
public class Pessoa {

    @NonNull
    private String nome;
    @NonNull
    private String sintoma;
    private List<String> alergias = new ArrayList<String>();
    private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

    public boolean addMedicamento(Medicamento m) {
        if (m.isIndicado(sintoma) && m.isContraIndicacao(alergias)) {
            medicamentos.add(m);
            return true;
        }
        return false;
    }

    public void addCondicaoSaude(String condicaoSaude) {
        alergias.add(condicaoSaude);
    }

}