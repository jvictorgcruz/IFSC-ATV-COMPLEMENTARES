package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import java.util.Map;

public abstract class Modalidade {
    private int id;
    private final String nome;

    public Modalidade(String nome) {
        this.nome = nome;
    }

    public String nome() {
        return nome;
    }

    public abstract Map<Integer, AtividadeComplementar> atividades();
}
