package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;

import java.util.Map;

public abstract class Modalidade implements AtividadesModalidade {
    private int id;
    private final String nome;

    public Modalidade(String nome) {
        this.nome = nome;
    }

    public String nome() {
        return nome;
    }

    public abstract Map<Integer, AtividadeComplementar> atividades();

    public abstract double proporcaoPermitida();
}
