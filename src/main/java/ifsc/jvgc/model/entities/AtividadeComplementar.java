package ifsc.jvgc.model.entities;

import ifsc.jvgc.model.entities.modalidades.Modalidade;
import ifsc.jvgc.model.strategy.EstrategiaValidacao;

public class AtividadeComplementar {
    private int id;
    private final String descricao;
    private final DocumentacaoComprobatoria documentacao;
    private final HorasPorAtividade horasPorAtividade;
    private final int limiteMaximo;
    private final Modalidade modalidade;
    private final EstrategiaValidacao estrategia;

    public AtividadeComplementar(String descricao, DocumentacaoComprobatoria documentacao,
                                 HorasPorAtividade horasPorAtividade, int limiteMaximo, Modalidade modalidade, EstrategiaValidacao estrategia) {
        this.descricao = descricao;
        this.documentacao = documentacao;
        this.horasPorAtividade = horasPorAtividade;
        this.limiteMaximo = limiteMaximo;
        this.modalidade = modalidade;
        this.estrategia = estrategia;
    }

    public int limiteMaximo() {
        return this.limiteMaximo;
    }

    public HorasPorAtividade horasPorAtividade() {
        return this.horasPorAtividade;
    }

    public String descricao() {
        return this.descricao;
    }

    public Modalidade modalidade() {
        return this.modalidade;
    }

    public EstrategiaValidacao estrategia() {
        return this.estrategia;
    }
}
