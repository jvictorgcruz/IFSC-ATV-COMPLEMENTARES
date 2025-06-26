package ifsc.jvgc.model;

import ifsc.jvgc.model.modalidades.Modalidade;

public class AtividadeComplementar {
    private int id;
    private final String descricao;
    private final DocumentacaoComprobatoria documentacao;
    private final HorasPorAtividade horasPorAtividade;
    private final int limiteMaximo;
    private final Modalidade modalidade;

    public AtividadeComplementar(String descricao, DocumentacaoComprobatoria documentacao,
                                 HorasPorAtividade horasPorAtividade, int limiteMaximo, Modalidade modalidade) {
        this.descricao = descricao;
        this.documentacao = documentacao;
        this.horasPorAtividade = horasPorAtividade;
        this.limiteMaximo = limiteMaximo;
        this.modalidade = modalidade;
    }

    public int getLimiteMaximo() {
        return this.limiteMaximo;
    }

    public String descricao() {
        return this.descricao;
    }

    public Modalidade modalidade() {
        return this.modalidade;
    }

    public int limiteMaximo() {
        return this.limiteMaximo;
    }
}
