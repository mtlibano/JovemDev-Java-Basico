package aula06.exercicio01.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum EnumAdmMedicamentos {

    INJETAVEL ("Injetável"),
    TOPICO ("Tópico"),
    ORAL ("Oral"),
    SUPOSITORIO ("Supositório");

    private String descricao;

}