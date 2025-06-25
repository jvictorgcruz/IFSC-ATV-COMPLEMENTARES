package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import java.util.Map;

public abstract class Modalidade {
    private final int id;
    private final String nome;

    public Modalidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Modalidade{id=" + id + ", nome='" + nome + "'}";
    }

    public String nome() {
        return nome;
    }

    public abstract Map<Integer, AtividadeComplementar> atividades();
}
