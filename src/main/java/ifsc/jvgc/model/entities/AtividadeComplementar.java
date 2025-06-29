package ifsc.jvgc.model.entities;

import ifsc.jvgc.model.entities.modalidades.Modalidade;
import ifsc.jvgc.model.strategy.EstrategiaValidacao;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtividadeComplementar that = (AtividadeComplementar) o;

        return descricao.equals(that.descricao) &&
                modalidade.getClass().equals(that.modalidade.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, modalidade.getClass());
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
